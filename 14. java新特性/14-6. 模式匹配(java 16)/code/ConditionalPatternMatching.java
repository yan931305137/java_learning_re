package code;

public class ConditionalPatternMatching {
    public static void main(String[] args) {
        Object obj = 123;
        
        // 在条件语句中使用模式匹配
        if (obj instanceof Integer i && i > 100) {
            System.out.println("Integer value is greater than 100: " + i);
        } else {
            System.out.println("Not an Integer greater than 100");
        }
    }
}
