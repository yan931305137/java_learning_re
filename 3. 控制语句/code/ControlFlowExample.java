package code;

public class ControlFlowExample {
    public static void main(String[] args) {
        // 1. if-else 示例
        System.out.println("=== if-else 示例 ===");
        int score = 85;
        
        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 80) {
            System.out.println("良好");
        } else if (score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

        // 2. switch-case 示例
        System.out.println("\n=== switch-case 示例 ===");
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
            case 7:
                System.out.println("周末");
                break;
            default:
                System.out.println("无效的日期");
        }

        // 3. for循环示例
        System.out.println("\n=== for循环示例 ===");
        // 基本for循环
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 增强for循环（foreach）
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 4. while循环示例
        System.out.println("\n=== while循环示例 ===");
        int count = 0;
        while (count < 5) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();

        // 5. do-while循环示例
        System.out.println("\n=== do-while循环示例 ===");
        int x = 1;
        do {
            System.out.print(x + " ");
            x++;
        } while (x <= 5);
        System.out.println();

        // 6. break和continue示例
        System.out.println("\n=== break和continue示例 ===");
        // break示例
        for (int i = 1; i <= 10; i++) {
            if (i == 5) break;
            System.out.print(i + " ");
        }
        System.out.println("\n--- break后 ---");

        // continue示例
        for (int i = 1; i <= 5; i++) {
            if (i == 3) continue;
            System.out.print(i + " ");
        }
        System.out.println("\n--- continue后 ---");
    }
} 