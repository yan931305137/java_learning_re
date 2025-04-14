package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 9999;
    private static final int BUFFER_SIZE = 1024;
    
    public static void main(String[] args) {
        try (
            DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in)
        ) {
            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);
            
            while (true) {
                // 读取用户输入
                System.out.print("请输入消息：");
                String message = scanner.nextLine();
                
                if ("bye".equalsIgnoreCase(message)) {
                    break;
                }
                
                // 发送数据
                byte[] sendBuffer = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer,
                    sendBuffer.length,
                    serverAddress,
                    SERVER_PORT
                );
                socket.send(sendPacket);
                
                // 接收响应
                byte[] receiveBuffer = new byte[BUFFER_SIZE];
                DatagramPacket receivePacket = new DatagramPacket(
                    receiveBuffer,
                    receiveBuffer.length
                );
                socket.receive(receivePacket);
                
                // 显示响应
                String response = new String(
                    receivePacket.getData(),
                    0,
                    receivePacket.getLength()
                );
                System.out.println(response);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 