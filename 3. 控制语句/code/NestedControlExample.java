package code;

public class NestedControlExample {
    public static void main(String[] args) {
        // 1. 嵌套if示例
        System.out.println("=== 嵌套if示例 ===");
        int age = 25;
        boolean hasTicket = true;
        
        if (age >= 18) {
            if (hasTicket) {
                System.out.println("可以进入电影院");
            } else {
                System.out.println("请先购票");
            }
        } else {
            System.out.println("未成年人不能观看此电影");
        }

        // 2. 嵌套循环示例
        System.out.println("\n=== 嵌套循环示例 ===");
        // 打印乘法表
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d×%d=%-3d", j, i, i * j);
            }
            System.out.println();
        }

        // 3. 带标签的break示例
        System.out.println("\n=== 带标签的break示例 ===");
        outer: 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    break outer;
                }
                System.out.printf("i=%d, j=%d\n", i, j);
            }
        }
    }
} 