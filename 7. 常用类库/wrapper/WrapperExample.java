package wrapper;

/**
 * 包装类使用示例
 */
public class WrapperExample {
    public static void main(String[] args) {
        // 1. 基本类型和包装类转换
        System.out.println("=== 基本类型和包装类 ===");
        int primitiveInt = 42;
        Integer wrapperInt = Integer.valueOf(primitiveInt); // 装箱
        int backToPrimitive = wrapperInt.intValue();       // 拆箱
        
        // 自动装箱和拆箱
        Integer autoBoxed = 100;    // 自动装箱
        int autoUnboxed = autoBoxed; // 自动拆箱

        // 2. 字符串转换
        System.out.println("\n=== 字符串转换 ===");
        String numStr = "123";
        int parsedInt = Integer.parseInt(numStr);
        double parsedDouble = Double.parseDouble("3.14");
        System.out.println("转换后的整数: " + parsedInt);
        System.out.println("转换后的浮点数: " + parsedDouble);

        // 3. 常用常量
        System.out.println("\n=== 包装类常量 ===");
        System.out.println("Integer最大值: " + Integer.MAX_VALUE);
        System.out.println("Integer最小值: " + Integer.MIN_VALUE);
        System.out.println("Double正无穷: " + Double.POSITIVE_INFINITY);
        System.out.println("Double负无穷: " + Double.NEGATIVE_INFINITY);

        // 4. 比较操作
        System.out.println("\n=== 比较操作 ===");
        Integer num1 = 127;
        Integer num2 = 127;
        Integer num3 = 128;
        Integer num4 = 128;
        System.out.println("num1 == num2: " + (num1 == num2));    // true
        System.out.println("num3 == num4: " + (num3 == num4));    // false
        System.out.println("num3.equals(num4): " + num3.equals(num4)); // true
    }
} 