package code;

public class PatternMatchingExample {
    public static void main(String[] args) {
        Object obj = "Hello, World!";
        
        // 使用模式匹配进行类型检查
        if (obj instanceof String s) {
            System.out.println("String length: " + s.length());
        } else {
            System.out.println("Not a String");
        }
    }
}