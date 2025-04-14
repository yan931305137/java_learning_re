package code;

import java.util.List;

public class VarExample {
    public static void main(String[] args) {
        // 使用var声明局部变量
        var message = "Hello, World!";
        var number = 42;
        var list = List.of("apple", "banana", "cherry");

        System.out.println("Message: " + message);
        System.out.println("Number: " + number);

        // 使用var在增强型for循环中
        for (var fruit : list) {
            System.out.println("Fruit: " + fruit);
        }
    }
}