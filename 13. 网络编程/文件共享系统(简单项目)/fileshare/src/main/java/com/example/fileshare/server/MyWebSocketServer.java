package com.example.fileshare.server;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;

public class MyWebSocketServer extends WebSocketServer {
    private Set<WebSocket> connections;
    
    public MyWebSocketServer(int port) {
        super(new InetSocketAddress(port));
        connections = new HashSet<>();
    }
    
    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        connections.add(conn);
        System.out.println("新WebSocket连接：" + conn.getRemoteSocketAddress());
    }
    
    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        connections.remove(conn);
        System.out.println("WebSocket连接关闭：" + conn.getRemoteSocketAddress());
    }
    
    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("收到消息：" + message);
        broadcastMessage(message);
    }
    
    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.out.println("WebSocket错误：" + ex.getMessage());
    }
    
    @Override
    public void onStart() {
        System.out.println("WebSocket服务器启动在端口：" + getPort());
    }
    
    public void broadcastMessage(String message) {
        for (WebSocket conn : connections) {
            conn.send(message);
        }
    }
} 