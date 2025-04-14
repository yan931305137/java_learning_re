package com.example.fileshare.client;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URI;

public class FileClient {
    private static final String SERVER_URL = "http://localhost:8080";
    private static final String WS_URL = "ws://localhost:8081";
    private WebSocketClient wsClient;
    
    public FileClient() {
        connectWebSocket();
    }
    
    private void connectWebSocket() {
        try {
            wsClient = new WebSocketClient(new URI(WS_URL)) {
                @Override
                public void onOpen(ServerHandshake handshake) {
                    System.out.println("WebSocket连接成功");
                }
                
                @Override
                public void onMessage(String message) {
                    System.out.println("收到服务器通知: " + message);
                }
                
                @Override
                public void onClose(int code, String reason, boolean remote) {
                    System.out.println("WebSocket连接关闭");
                }
                
                @Override
                public void onError(Exception ex) {
                    System.out.println("WebSocket错误: " + ex.getMessage());
                }
            };
            wsClient.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void uploadFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            String filename = path.getFileName().toString();
            
            URL url = new URL(SERVER_URL + "/upload");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("X-File-Name", filename);
            
            try (OutputStream os = conn.getOutputStream();
                 InputStream is = Files.newInputStream(path)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
            
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("文件上传成功");
            } else {
                System.out.println("文件上传失败: " + responseCode);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void downloadFile(int fileId, String savePath) {
        try {
            URL url = new URL(SERVER_URL + "/download?id=" + fileId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            try (InputStream is = conn.getInputStream();
                 OutputStream os = new FileOutputStream(savePath)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
            
            System.out.println("文件下载完成");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void listFiles() {
        try {
            URL url = new URL(SERVER_URL + "/list");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        FileClient client = new FileClient();
        
        // 测试上传文件
        client.uploadFile("test.txt");
        
        // 获取文件列表
        client.listFiles();
        
        // 测试下载文件
        client.downloadFile(1, "downloaded_test.txt");
    }
} 