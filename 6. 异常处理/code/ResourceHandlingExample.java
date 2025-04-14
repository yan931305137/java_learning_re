package code;

import java.io.*;

/**
 * 资源处理示例
 */
public class ResourceHandlingExample {
    public static void main(String[] args) {
        // 1. 传统方式处理资源
        System.out.println("=== 传统资源处理 ===");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("test.txt");
            br = new BufferedReader(fr);
            String line = br.readLine();
            System.out.println("读取的内容：" + line);
        } catch (IOException e) {
            System.out.println("IO异常：" + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException e) {
                System.out.println("关闭资源时发生异常：" + e.getMessage());
            }
        }

        // 2. try-with-resources方式（Java 7+）
        System.out.println("\n=== try-with-resources示例 ===");
        try (FileReader fileReader = new FileReader("test.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            System.out.println("读取的内容：" + line);
        } catch (IOException e) {
            System.out.println("IO异常：" + e.getMessage());
        }
    }
} 