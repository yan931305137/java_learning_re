package code;

import java.io.FileInputStream;
import java.io.IOException;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        // 使用var在try-with-resources中声明资源
        try (var inputStream = new FileInputStream("file.txt")) {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
