package tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8888;
    
    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("已连接到服务器");
            
            // 创建一个线程用于接收服务器消息
            new Thread(() -> {
                try {
                    String response;
                    while ((response = in.readLine()) != null) {
                        System.out.println(response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            
            // 主线程用于发送消息
            String message;
            while (true) {
                message = scanner.nextLine();
                out.println(message);
                
                if ("bye".equalsIgnoreCase(message)) {
                    break;
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 