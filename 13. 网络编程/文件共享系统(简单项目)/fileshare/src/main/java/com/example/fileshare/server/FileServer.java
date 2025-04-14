package com.example.fileshare.server;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import org.java_websocket.server.WebSocketServer;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.*;
import java.util.concurrent.Executors;

public class FileServer {
    private static final int PORT = 8080;
    private static final String UPLOAD_DIR = "uploads/";
    private final DatabaseManager dbManager;
    private final MyWebSocketServer wsServer;
    
    public FileServer() {
        this.dbManager = new DatabaseManager();
        this.wsServer = new MyWebSocketServer(8081);
        
        // 确保上传目录存在
        createUploadDirectory();
        
        // 初始化数据库
        dbManager.initDatabase();
        
        try {
            startHttpServer();
            wsServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void createUploadDirectory() {
        try {
            Files.createDirectories(Paths.get(UPLOAD_DIR));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void startHttpServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/upload", new UploadHandler());
        server.createContext("/download", new DownloadHandler());
        server.createContext("/list", new ListHandler());
        server.setExecutor(Executors.newFixedThreadPool(10));
        server.start();
        
        System.out.println("文件服务器启动在端口: " + PORT);
    }
    
    class UploadHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())) {
                try (InputStream is = exchange.getRequestBody()) {
                    // 获取文件名
                    String filename = exchange.getRequestHeaders()
                        .getFirst("X-File-Name");
                    
                    // 保存文件
                    Path filePath = Paths.get(UPLOAD_DIR + filename);
                    Files.copy(is, filePath, StandardCopyOption.REPLACE_EXISTING);
                    
                    // 保存到数据库
                    dbManager.addFile(filename, filePath.toString());
                    
                    // 通知WebSocket客户端
                    wsServer.broadcastMessage("新文件上传: " + filename);
                    
                    // 返回成功响应
                    String response = "文件上传成功";
                    exchange.sendResponseHeaders(200, response.length());
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(response.getBytes());
                    }
                }
            } else {
                exchange.sendResponseHeaders(405, -1); // Method Not Allowed
            }
        }
    }
    
    class DownloadHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                // 获取文件ID
                String query = exchange.getRequestURI().getQuery();
                String fileId = query.split("=")[1];
                
                // 更新下载次数
                dbManager.incrementDownloadCount(Integer.parseInt(fileId));
                
                // TODO: 根据fileId获取文件路径并发送文件
                // 这里简化处理，直接发送测试数据
                String response = "文件下载成功";
                exchange.sendResponseHeaders(200, response.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            } else {
                exchange.sendResponseHeaders(405, -1);
            }
        }
    }
    
    class ListHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                // 获取文件列表
                String response = generateFileListJson();
                exchange.getResponseHeaders().add("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, response.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            } else {
                exchange.sendResponseHeaders(405, -1);
            }
        }
        
        private String generateFileListJson() {
            // 将文件列表转换为JSON格式
            StringBuilder json = new StringBuilder("[");
            dbManager.getAllFiles().forEach(file -> {
                json.append(String.format(
                    "{\"id\":%d,\"name\":\"%s\",\"downloads\":%d},",
                    file.getId(), file.getFilename(), file.getDownloadCount()
                ));
            });
            if (json.charAt(json.length()-1) == ',') {
                json.setLength(json.length()-1);
            }
            json.append("]");
            return json.toString();
        }
    }
    
    public static void main(String[] args) {
        new FileServer();
    }
} 