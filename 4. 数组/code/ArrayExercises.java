package code;

/**
 * Java数组练习题
 * 完成下列所有练习题，加深对数组操作的理解
 */
public class ArrayExercises {
    public static void main(String[] args) {
        // 可以在这里测试你的答案
        System.out.println("=== 开始测试你的答案 ===");
        
        // 测试题1的答案
        int[] testArray = {1, 2, 3, 4, 5};
        System.out.println("第二大的数是：" + findSecondLargest(testArray));
    }

    /**
     * 练习1：找出数组中第二大的数
     * 要求：不能使用Arrays.sort()
     * 示例：[1,5,3,8,2] 返回 5
     */
    public static int findSecondLargest(int[] arr) {
        // 在这里写你的代码
        return 0; // 这是一个占位符，请修改它
    }

    /**
     * 练习2：合并两个有序数组
     * 要求：合并后的数组仍然有序
     * 示例：[1,3,5], [2,4,6] 返回 [1,2,3,4,5,6]
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        // 在这里写你的代码
        return new int[0]; // 这是一个占位符，请修改它
    }

    /**
     * 练习3：数组循环右移k位
     * 要求：空间复杂度 O(1)
     * 示例：[1,2,3,4,5], k=2 返回 [4,5,1,2,3]
     */
    public static void rotateArray(int[] arr, int k) {
        // 在这里写你的代码
    }

    /**
     * 练习4：找出数组中只出现一次的数字
     * 要求：其他数字都出现两次
     * 示例：[4,1,2,1,2] 返回 4
     */
    public static int findSingleNumber(int[] arr) {
        // 在这里写你的代码
        return 0; // 这是一个占位符，请修改它
    }

    /**
     * 练习5：判断数组是否为回文数组
     * 示例：[1,2,3,2,1] 返回 true
     */
    public static boolean isPalindrome(int[] arr) {
        // 在这里写你的代码
        return false; // 这是一个占位符，请修改它
    }

    /**
     * 练习6：找出数组中连续子数组的最大和
     * 示例：[-2,1,-3,4,-1,2,1,-5,4] 返回 6 (子数组 [4,-1,2,1])
     */
    public static int maxSubArray(int[] arr) {
        // 在这里写你的代码
        return 0; // 这是一个占位符，请修改它
    }

    /**
     * 练习7：实现数组的冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        // 在这里写你的代码
    }

    /**
     * 练习8：找出数组中重复的数字
     * 要求：数组长度为n，数字范围在0~n-1内
     * 示例：[2,3,1,0,2,5,3] 返回 2 或 3
     */
    public static int findDuplicate(int[] arr) {
        // 在这里写你的代码
        return -1; // 这是一个占位符，请修改它
    }

    /**
     * 练习9：实现二维数组的转置
     * 示例：[[1,2,3],     变成    [[1,4,7],
     *       [4,5,6],             [2,5,8],
     *       [7,8,9]]            [3,6,9]]
     */
    public static int[][] transpose(int[][] matrix) {
        // 在这里写你的代码
        return null; // 这是一个占位符，请修改它
    }

    /**
     * 练习10：在排序数组中找出给定数字的出现次数
     * 要求：时间复杂度应该是 O(log n)
     * 示例：[1,2,3,3,3,3,4,5], target=3 返回 4
     */
    public static int countOccurrences(int[] arr, int target) {
        // 在这里写你的代码
        return 0; // 这是一个占位符，请修改它
    }
} 