package code;

import java.util.Arrays;

public class MethodReferenceExample {
    public static void main(String[] args) {
        String[] array = {"banana", "apple", "orange"};

        // 静态方法引用
        Arrays.sort(array, String::compareToIgnoreCase);
        System.out.println("Sorted array: " + Arrays.toString(array));

        // 实例方法引用
        Arrays.asList(array).forEach(System.out::println);
    }
} 