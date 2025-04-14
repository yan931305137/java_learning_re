package string;

/**
 * String类使用示例
 */
public class StringExample {
    public static void main(String[] args) {
        // 1. 字符串创建
        System.out.println("=== 字符串创建 ===");
        String str1 = "Hello";
        String str2 = new String("Hello");
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1.equals(str2): " + str1.equals(str2));

        // 2. 常用方法
        System.out.println("\n=== 字符串方法 ===");
        String text = "  Hello, Java World!  ";
        System.out.println("长度: " + text.length());
        System.out.println("大写: " + text.toUpperCase());
        System.out.println("小写: " + text.toLowerCase());
        System.out.println("去空格: " + text.trim());
        System.out.println("替换: " + text.replace("Java", "Python"));
        System.out.println("子串: " + text.substring(8, 12));
        System.out.println("包含Java?: " + text.contains("Java"));

        // 3. 字符串分割
        String names = "Tom,Jerry,Spike";
        String[] nameArray = names.split(",");
        System.out.println("\n=== 字符串分割 ===");
        for (String name : nameArray) {
            System.out.println(name);
        }

        // 4. StringBuilder示例
        System.out.println("\n=== StringBuilder ===");
        StringBuilder sb = new StringBuilder();
        sb.append("Hello")
          .append(" ")
          .append("World")
          .append("!");
        System.out.println("StringBuilder结果: " + sb.toString());
        sb.insert(5, ",");
        System.out.println("插入后: " + sb.toString());
        sb.reverse();
        System.out.println("反转后: " + sb.toString());
    }
} 