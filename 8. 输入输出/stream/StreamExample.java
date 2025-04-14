package stream;

import java.io.*;

/**
 * 流操作示例
 */
public class StreamExample {
    public static void main(String[] args) {
        // 1. 文件字节流示例
        System.out.println("=== 文件字节流示例 ===");
        try (FileOutputStream fos = new FileOutputStream("byte.dat");
             FileInputStream fis = new FileInputStream("byte.dat")) {
            
            // 写入字节
            byte[] writeData = {65, 66, 67, 68, 69}; // ABCDE
            fos.write(writeData);
            System.out.println("数据已写入");
            
            // 读取字节
            byte[] readData = new byte[5];
            int bytesRead = fis.read(readData);
            System.out.print("读取的数据：");
            for (int i = 0; i < bytesRead; i++) {
                System.out.print((char)readData[i]);
            }
            System.out.println();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. 文件字符流示例
        System.out.println("\n=== 文件字符流示例 ===");
        try (FileWriter writer = new FileWriter("char.txt");
             FileReader reader = new FileReader("char.txt")) {
            
            // 写入字符
            writer.write("你好，Java！");
            System.out.println("数据已写入");
            
            // 读取字符
            char[] readBuffer = new char[1024];
            int charsRead = reader.read(readBuffer);
            System.out.println("读取的数据：" + new String(readBuffer, 0, charsRead));
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. 缓冲流示例
        System.out.println("\n=== 缓冲流示例 ===");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("buffered.txt"));
             BufferedReader br = new BufferedReader(new FileReader("buffered.txt"))) {
            
            // 写入数据
            bw.write("第一行");
            bw.newLine();
            bw.write("第二行");
            bw.newLine();
            System.out.println("数据已写入");
            
            // 读取数据
            String line;
            System.out.println("读取的数据：");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 