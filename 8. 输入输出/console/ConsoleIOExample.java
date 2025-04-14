package console;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 控制台输入输出示例
 */
public class ConsoleIOExample {
    public static void main(String[] args) {
        // 1. System.out 示例
        System.out.println("=== System.out示例 ===");
        System.out.println("普通输出");
        System.out.print("不换行输出");
        System.out.print("接着上一行\n");
        System.out.printf("格式化输出：名字=%s，年龄=%d%n", "张三", 20);

        // 2. Scanner输入示例
        System.out.println("\n=== Scanner输入示例 ===");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入你的名字：");
        String name = scanner.nextLine();
        
        System.out.print("请输入你的年龄：");
        int age = scanner.nextInt();
        
        System.out.printf("你好，%s！你是%d岁。%n", name, age);

        // 3. BufferedReader输入示例
        System.out.println("\n=== BufferedReader输入示例 ===");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("请输入一行文本：");
            String line = reader.readLine();
            System.out.println("你输入的是：" + line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 