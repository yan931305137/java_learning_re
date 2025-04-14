package code;

public class ArrayBasicExample {
    public static void main(String[] args) {
        // 1. 数组声明和初始化
        System.out.println("=== 数组声明和初始化 ===");
        // 方式1：声明时不分配空间
        int[] numbers;
        numbers = new int[5];
        
        // 方式2：声明同时分配空间
        String[] fruits = new String[3];
        
        // 方式3：声明并初始化
        int[] scores = {95, 85, 75, 65, 88};
        String[] colors = {"红", "黄", "蓝"};

        // 2. 数组访问和修改
        System.out.println("\n=== 数组访问和修改 ===");
        System.out.println("第一个成绩：" + scores[0]);
        scores[0] = 98;  // 修改元素
        System.out.println("修改后的第一个成绩：" + scores[0]);
        System.out.println("数组长度：" + scores.length);

        // 3. 数组遍历
        System.out.println("\n=== 数组遍历方式 ===");
        // 方式1：普通for循环
        System.out.println("使用for循环遍历：");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();

        // 方式2：增强for循环（foreach）
        System.out.println("使用foreach遍历：");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();

        // 4. 数组默认值演示
        System.out.println("\n=== 数组默认值 ===");
        int[] nums = new int[3];
        String[] strs = new String[3];
        boolean[] bools = new boolean[3];
        
        System.out.println("整数数组默认值：" + nums[0]);
        System.out.println("字符串数组默认值：" + strs[0]);
        System.out.println("布尔数组默认值：" + bools[0]);

        // 5. 数组越界演示
        System.out.println("\n=== 数组越界演示 ===");
        try {
            System.out.println(scores[10]); // 访问不存在的索引
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界异常：" + e.getMessage());
        }
    }
} 