package code;

public class OperatorsExample {
    public static void main(String[] args) {
        // 1. 算术运算符示例
        System.out.println("=== 算术运算符 ===");
        int a = 10, b = 3;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("加法: " + (a + b));      // 13
        System.out.println("减法: " + (a - b));      // 7
        System.out.println("乘法: " + (a * b));      // 30
        System.out.println("除法: " + (a / b));      // 3
        System.out.println("取余: " + (a % b));      // 1
        
        // 自增自减
        int c = 5;
        System.out.println("\n当前c = " + c);
        System.out.println("c++: " + c++);    // 输出5，然后c变成6
        System.out.println("++c: " + ++c);    // c变成7，然后输出7
        System.out.println("c--: " + c--);    // 输出7，然后c变成6
        System.out.println("--c: " + --c);    // c变成5，然后输出5

        // 2. 关系运算符示例
        System.out.println("\n=== 关系运算符 ===");
        int x = 10, y = 20;
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("x > y: " + (x > y));     // false
        System.out.println("x < y: " + (x < y));     // true
        System.out.println("x >= y: " + (x >= y));   // false
        System.out.println("x <= y: " + (x <= y));   // true
        System.out.println("x == y: " + (x == y));   // false
        System.out.println("x != y: " + (x != y));   // true

        // 3. 逻辑运算符示例
        System.out.println("\n=== 逻辑运算符 ===");
        boolean p = true, q = false;
        System.out.println("p = " + p + ", q = " + q);
        System.out.println("p && q: " + (p && q));   // false
        System.out.println("p || q: " + (p || q));   // true
        System.out.println("!p: " + (!p));           // false
        
        // 短路效果演示
        int n = 10;
        boolean result = (n < 0) && (++n > 0);  // ++n不会执行
        System.out.println("短路&&后 n = " + n); // n仍然是10

        // 4. 位运算符示例
        System.out.println("\n=== 位运算符 ===");
        int m = 5;  // 二进制：0101
        int n2 = 3; // 二进制：0011
        System.out.println("m = " + m + ", n = " + n2);
        System.out.println("m & n: " + (m & n2));    // 1 (0001)
        System.out.println("m | n: " + (m | n2));    // 7 (0111)
        System.out.println("m ^ n: " + (m ^ n2));    // 6 (0110)
        System.out.println("~m: " + (~m));           // -6
        System.out.println("m << 1: " + (m << 1));   // 10 (1010)
        System.out.println("m >> 1: " + (m >> 1));   // 2 (0010)

        // 5. 赋值运算符示例
        System.out.println("\n=== 赋值运算符 ===");
        int k = 10;
        System.out.println("初始k = " + k);
        k += 5;  // 相当于 k = k + 5
        System.out.println("k += 5: " + k);
        k -= 3;  // 相当于 k = k - 3
        System.out.println("k -= 3: " + k);
        k *= 2;  // 相当于 k = k * 2
        System.out.println("k *= 2: " + k);
        k /= 4;  // 相当于 k = k / 4
        System.out.println("k /= 4: " + k);
        k %= 3;  // 相当于 k = k % 3
        System.out.println("k %= 3: " + k);

        // 6. 条件运算符示例
        System.out.println("\n=== 条件运算符 ===");
        int age = 20;
        String status = (age >= 18) ? "成年" : "未成年";
        System.out.println("年龄: " + age + "，状态: " + status);
        
        // 嵌套条件运算符
        int score = 75;
        String grade = (score >= 90) ? "优秀" : 
                      (score >= 60) ? "及格" : "不及格";
        System.out.println("分数: " + score + "，等级: " + grade);
    }
} 