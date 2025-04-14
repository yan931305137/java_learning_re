package code;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");

        // 使用Consumer接口
        Consumer<String> print = item -> System.out.println(item);
        list.forEach(print);
    }
} 