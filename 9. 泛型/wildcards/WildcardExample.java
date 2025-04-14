package wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型通配符示例
 */
public class WildcardExample {
    // 无界通配符示例
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // 上界通配符示例
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    // 下界通配符示例
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        // 测试无界通配符
        System.out.println("=== 无界通配符示例 ===");
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        System.out.print("字符串列表: ");
        printList(stringList);

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        System.out.print("整数列表: ");
        printList(intList);

        // 测试上界通配符
        System.out.println("\n=== 上界通配符示例 ===");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println("数字列表求和: " + sumOfList(numbers));

        // 测试下界通配符
        System.out.println("\n=== 下界通配符示例 ===");
        List<Number> numberList = new ArrayList<>();
        addNumbers(numberList);
        System.out.print("添加数字后的列表: ");
        printList(numberList);
    }
} 