package code;

public class ArrayPracticalExample {
    public static void main(String[] args) {
        // 1. 数组最大值和最小值
        System.out.println("=== 查找最大值和最小值 ===");
        int[] numbers = {23, 45, 12, 67, 34, 89, 56, 78};
        int max = findMax(numbers);
        int min = findMin(numbers);
        System.out.println("最大值：" + max);
        System.out.println("最小值：" + min);

        // 2. 数组元素求和和平均值
        System.out.println("\n=== 计算总和和平均值 ===");
        double average = calculateAverage(numbers);
        System.out.println("总和：" + calculateSum(numbers));
        System.out.println("平均值：" + average);

        // 3. 数组元素查找
        System.out.println("\n=== 元素查找 ===");
        int target = 67;
        int position = findElement(numbers, target);
        if (position != -1) {
            System.out.println("元素 " + target + " 在位置 " + position);
        } else {
            System.out.println("元素 " + target + " 未找到");
        }

        // 4. 数组反转
        System.out.println("\n=== 数组反转 ===");
        System.out.println("原数组：" + java.util.Arrays.toString(numbers));
        reverseArray(numbers);
        System.out.println("反转后：" + java.util.Arrays.toString(numbers));

        // 5. 数组去重
        System.out.println("\n=== 数组去重 ===");
        int[] duplicates = {1, 3, 5, 3, 7, 1, 9, 3};
        System.out.println("原数组：" + java.util.Arrays.toString(duplicates));
        int[] unique = removeDuplicates(duplicates);
        System.out.println("去重后：" + java.util.Arrays.toString(unique));
    }

    // 查找最大值
    private static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组为空");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // 查找最小值
    private static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组为空");
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // 计算总和
    private static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // 计算平均值
    private static double calculateAverage(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组为空");
        }
        return (double) calculateSum(arr) / arr.length;
    }

    // 查找元素
    private static int findElement(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 数组反转
    private static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            // 交换元素
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // 数组去重
    private static int[] removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        
        // 使用Java 8的Stream特性去重
        return java.util.Arrays.stream(arr)
                             .distinct()
                             .toArray();
    }
} 