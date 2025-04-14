package code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "date");

        // 使用Stream API过滤和收集
        List<String> filtered = list.stream()
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());

        System.out.println("Filtered list: " + filtered);
    }
} 