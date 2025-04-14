package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    private static final int PORT = 9999;
    private static final int BUFFER_SIZE = 1024;
    
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            System.out.println("UDP服务器启动，监听端口：" + PORT);
            
            byte[] receiveBuffer = new byte[BUFFER_SIZE];
            
            while (true) {
                // 创建接收数据包
                DatagramPacket receivePacket = new DatagramPacket(
                    receiveBuffer, receiveBuffer.length);
                
                // 接收数据
                socket.receive(receivePacket);
                
                // 处理接收到的数据
                String message = new String(
                    receivePacket.getData(), 
                    0, 
                    receivePacket.getLength()
                );
                System.out.println("收到消息：" + message);
                
                // 准备回复数据
                String response = "服务器回复：" + message;
                byte[] sendBuffer = response.getBytes();
                
                // 创建发送数据包
                DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer,
                    sendBuffer.length,
                    receivePacket.getAddress(),
                    receivePacket.getPort()
                );
                
                // 发送数据
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 