package methods;

/**
 * 泛型方法示例
 */
public class GenericMethodExample {
    // 简单泛型方法
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // 多类型参数的泛型方法
    public static <T, U> void printPair(T first, U second) {
        System.out.println("(" + first + ", " + second + ")");
    }

    // 带边界的泛型方法
    public static <T extends Number> double sum(T[] array) {
        double sum = 0.0;
        for (T element : array) {
            sum += element.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        // 测试泛型方法
        System.out.println("=== 泛型方法示例 ===");
        String[] strings = {"Hello", "World", "Generics"};
        Integer[] numbers = {1, 2, 3, 4, 5};

        System.out.println("打印字符串数组:");
        printArray(strings);

        System.out.println("打印数字数组:");
        printArray(numbers);

        System.out.println("打印键值对:");
        printPair("Name", "John");
        printPair(1, "First");

        System.out.println("数组求和: " + sum(numbers));
    }
} 