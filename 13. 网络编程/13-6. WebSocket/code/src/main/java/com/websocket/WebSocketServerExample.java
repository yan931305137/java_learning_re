package com.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket")
public class WebSocketServerExample {
    private static final CopyOnWriteArraySet<WebSocketServerExample> connections = new CopyOnWriteArraySet<>();
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        connections.add(this);
        System.out.println("新连接: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("收到消息: " + message);
        for (WebSocketServerExample client : connections) {
            try {
                client.session.getBasicRemote().sendText("Echo: " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        connections.remove(this);
        System.out.println("连接关闭: " + session.getId());
    }
} 