package code;

public class MultiDimensionalArrayExample {
    public static void main(String[] args) {
        // 1. 二维数组的创建和初始化
        System.out.println("=== 二维数组示例 ===");
        // 方式1：直接初始化
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // 方式2：动态创建
        int[][] grid = new int[3][4];
        
        // 2. 不规则数组
        System.out.println("\n=== 不规则数组示例 ===");
        int[][] irregular = new int[3][];
        irregular[0] = new int[4];
        irregular[1] = new int[2];
        irregular[2] = new int[3];

        // 填充不规则数组
        for (int i = 0; i < irregular.length; i++) {
            for (int j = 0; j < irregular[i].length; j++) {
                irregular[i][j] = i + j;
            }
        }

        // 3. 二维数组遍历
        System.out.println("\n=== 二维数组遍历 ===");
        // 使用嵌套for循环
        System.out.println("矩阵内容：");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 使用增强for循环
        System.out.println("\n不规则数组内容：");
        for (int[] row : irregular) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        // 4. 二维数组常见应用
        System.out.println("\n=== 二维数组应用 ===");
        // 示例：成绩表
        String[] students = {"张三", "李四", "王五"};
        String[] subjects = {"语文", "数学", "英语"};
        int[][] scores = {
            {80, 90, 85},
            {75, 95, 88},
            {90, 80, 85}
        };

        // 打印成绩表
        System.out.println("学生成绩表：");
        // 打印科目
        System.out.print("\t");
        for (String subject : subjects) {
            System.out.print(subject + "\t");
        }
        System.out.println();

        // 打印每个学生的成绩
        for (int i = 0; i < students.length; i++) {
            System.out.print(students[i] + "\t");
            for (int score : scores[i]) {
                System.out.print(score + "\t");
            }
            System.out.println();
        }
    }
} 