package learning_code;

public class DataTypesExample {
    public static void main(String[] args) {
        // 1. 基本数据类型示例
        System.out.println("=== 基本数据类型示例 ===");
        byte byteNum = 127;
        short shortNum = 32767;
        int intNum = 2147483647;
        long longNum = 9223372036854775807L;  // 注意L后缀
        float floatNum = 3.14f;               // 注意f后缀
        double doubleNum = 3.14159265359;
        char charValue = 'A';
        boolean boolValue = true;

        System.out.println("byte值: " + byteNum);
        System.out.println("short值: " + shortNum);
        System.out.println("int值: " + intNum);
        System.out.println("long值: " + longNum);
        System.out.println("float值: " + floatNum);
        System.out.println("double值: " + doubleNum);
        System.out.println("char值: " + charValue);
        System.out.println("boolean值: " + boolValue);

        // 2. 引用类型示例
        System.out.println("\n=== 引用类型示例 ===");
        String str = "Hello, Java!";
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("String值: " + str);
        System.out.println("数组第一个元素: " + numbers[0]);

        // 3. 自动装箱和拆箱示例
        System.out.println("\n=== 自动装箱和拆箱示例 ===");
        Integer boxedInt = 100;    // 自动装箱
        int unboxedInt = boxedInt; // 自动拆箱
        System.out.println("装箱后的值: " + boxedInt);
        System.out.println("拆箱后的值: " + unboxedInt);

        // 4. 类型转换示例
        System.out.println("\n=== 类型转换示例 ===");
        // 隐式转换
        int smallNum = 100;
        long bigNum = smallNum;    // int -> long
        System.out.println("隐式转换: " + bigNum);

        // 显式转换
        double pi = 3.14159;
        int roundedPi = (int) pi;  // double -> int
        System.out.println("显式转换: " + roundedPi);

        // 5. 常量示例
        System.out.println("\n=== 常量示例 ===");
        final double PI = 3.14159;
        final String COMPANY_NAME = "示例公司";
        System.out.println("常量PI: " + PI);
        System.out.println("常量公司名: " + COMPANY_NAME);

        // 6. 包装类使用示例
        System.out.println("\n=== 包装类示例 ===");
        Integer wrappedInt = Integer.valueOf(42);
        Double wrappedDouble = Double.valueOf(3.14);
        Boolean wrappedBoolean = Boolean.valueOf(true);
        
        System.out.println("Integer最大值: " + Integer.MAX_VALUE);
        System.out.println("Double最小值: " + Double.MIN_VALUE);
        System.out.println("Boolean的true值: " + wrappedBoolean);

        // 7. 字符串转换示例
        System.out.println("\n=== 字符串转换示例 ===");
        String numStr = "123";
        int parsedInt = Integer.parseInt(numStr);
        double parsedDouble = Double.parseDouble("3.14");
        System.out.println("字符串转整数: " + parsedInt);
        System.out.println("字符串转浮点: " + parsedDouble);
    }
} 