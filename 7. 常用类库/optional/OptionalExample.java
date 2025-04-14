package optional;

import java.util.Optional;

/**
 * Optional类示例
 */
public class OptionalExample {
    public static void main(String[] args) {
        // 1. 创建Optional对象
        System.out.println("=== 创建Optional ===");
        Optional<String> empty = Optional.empty();
        Optional<String> nonNull = Optional.of("Hello");
        Optional<String> nullable = Optional.ofNullable(null);

        // 2. 检查值是否存在
        System.out.println("\n=== 检查值 ===");
        System.out.println("empty是否存在值: " + empty.isPresent());
        System.out.println("nonNull是否存在值: " + nonNull.isPresent());

        // 3. 获取值
        System.out.println("\n=== 获取值 ===");
        System.out.println("nonNull的值: " + nonNull.get());
        System.out.println("empty的默认值: " + empty.orElse("Default"));
        System.out.println("nullable的计算值: " + 
            nullable.orElseGet(() -> "Computed Value"));

        // 4. 值转换
        System.out.println("\n=== 值转换 ===");
        Optional<String> mapped = nonNull.map(String::toUpperCase);
        System.out.println("转换后的值: " + mapped.orElse(""));

        // 5. 条件执行
        System.out.println("\n=== 条件执行 ===");
        nonNull.ifPresent(str -> System.out.println("值存在: " + str));
        empty.ifPresent(str -> System.out.println("这行不会执行"));

        // 6. 链式操作
        System.out.println("\n=== 链式操作 ===");
        String result = Optional.ofNullable("hello")
            .map(String::toUpperCase)
            .filter(str -> str.length() > 3)
            .orElse("too short");
        System.out.println("链式操作结果: " + result);
    }
} 