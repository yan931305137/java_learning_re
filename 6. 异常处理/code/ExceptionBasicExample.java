package code;

/**
 * 基础异常处理示例
 */
public class ExceptionBasicExample {
    public static void main(String[] args) {
        // 1. try-catch基本用法
        System.out.println("=== try-catch示例 ===");
        try {
            int result = divide(10, 0);
            System.out.println("结果：" + result);
        } catch (ArithmeticException e) {
            System.out.println("发生算术异常：" + e.getMessage());
        }

        // 2. 多重catch示例
        System.out.println("\n=== 多重catch示例 ===");
        try {
            Object obj = null;
            if (Math.random() < 0.5) {
                obj.toString(); // 可能发生NullPointerException
            } else {
                int[] arr = new int[3];
                arr[5] = 10;   // 可能发生ArrayIndexOutOfBoundsException
            }
        } catch (NullPointerException e) {
            System.out.println("空指针异常：" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界异常：" + e.getMessage());
        } catch (Exception e) {
            System.out.println("其他异常：" + e.getMessage());
        }

        // 3. finally示例
        System.out.println("\n=== finally示例 ===");
        try {
            System.out.println("执行可能抛出异常的代码");
            throw new RuntimeException("测试异常");
        } catch (Exception e) {
            System.out.println("捕获异常：" + e.getMessage());
        } finally {
            System.out.println("finally块总是执行");
        }
    }

    public static int divide(int a, int b) {
        return a / b;
    }
} 