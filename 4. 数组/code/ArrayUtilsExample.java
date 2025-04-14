package code;

import java.util.Arrays;
import java.util.Collections;

public class ArrayUtilsExample {
    public static void main(String[] args) {
        // 1. Arrays.toString() 示例
        System.out.println("=== Arrays.toString() 示例 ===");
        int[] numbers = {5, 2, 8, 1, 9};
        System.out.println("数组内容：" + Arrays.toString(numbers));

        // 2. Arrays.sort() 示例
        System.out.println("\n=== Arrays.sort() 示例 ===");
        Arrays.sort(numbers);
        System.out.println("排序后：" + Arrays.toString(numbers));

        // 降序排序（使用Integer数组）
        Integer[] nums = {5, 2, 8, 1, 9};
        Arrays.sort(nums, Collections.reverseOrder());
        System.out.println("降序排序：" + Arrays.toString(nums));

        // 3. Arrays.binarySearch() 示例
        System.out.println("\n=== Arrays.binarySearch() 示例 ===");
        int index = Arrays.binarySearch(numbers, 8);
        System.out.println("元素8的索引：" + index);

        // 4. Arrays.copyOf() 示例
        System.out.println("\n=== Arrays.copyOf() 示例 ===");
        int[] copied = Arrays.copyOf(numbers, numbers.length + 2);
        System.out.println("扩展复制：" + Arrays.toString(copied));

        // 5. Arrays.fill() 示例
        System.out.println("\n=== Arrays.fill() 示例 ===");
        int[] filled = new int[5];
        Arrays.fill(filled, 10);
        System.out.println("填充数组：" + Arrays.toString(filled));

        // 6. 数组复制的不同方式
        System.out.println("\n=== 数组复制的不同方式 ===");
        // 方式1：System.arraycopy()
        int[] source = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        System.arraycopy(source, 0, dest, 0, source.length);
        System.out.println("System.arraycopy()：" + Arrays.toString(dest));

        // 方式2：clone()
        int[] cloned = source.clone();
        System.out.println("clone()：" + Arrays.toString(cloned));

        // 7. 多维数组操作
        System.out.println("\n=== 多维数组操作 ===");
        int[][] matrix = {{1, 2}, {3, 4}};
        System.out.println("多维数组转字符串：" + Arrays.deepToString(matrix));

        // 8. 数组判等
        System.out.println("\n=== 数组判等 ===");
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 2, 4};
        
        System.out.println("arr1 equals arr2: " + Arrays.equals(arr1, arr2));
        System.out.println("arr1 equals arr3: " + Arrays.equals(arr1, arr3));
    }
} 