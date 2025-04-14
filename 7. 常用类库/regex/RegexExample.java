package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式示例
 */
public class RegexExample {
    public static void main(String[] args) {
        // 1. 基本匹配
        System.out.println("=== 基本匹配 ===");
        String text = "The quick brown fox jumps over the lazy dog";
        Pattern pattern = Pattern.compile("fox");
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println("Found 'fox' at position: " + matcher.start());
        }

        // 2. 邮箱验证
        System.out.println("\n=== 邮箱验证 ===");
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        System.out.println("test@email.com 是否有效: " + 
            "test@email.com".matches(emailPattern));
        System.out.println("invalid.email 是否有效: " + 
            "invalid.email".matches(emailPattern));

        // 3. 替换操作
        System.out.println("\n=== 替换操作 ===");
        String text2 = "The color is #FF0000 and #00FF00";
        Pattern colorPattern = Pattern.compile("#[A-Fa-f0-9]{6}");
        Matcher colorMatcher = colorPattern.matcher(text2);
        String result = colorMatcher.replaceAll("COLOR");
        System.out.println("替换后: " + result);

        // 4. 分组匹配
        System.out.println("\n=== 分组匹配 ===");
        String date = "2023-12-25";
        Pattern datePattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
        Matcher dateMatcher = datePattern.matcher(date);
        
        if (dateMatcher.matches()) {
            System.out.println("年: " + dateMatcher.group(1));
            System.out.println("月: " + dateMatcher.group(2));
            System.out.println("日: " + dateMatcher.group(3));
        }
    }
} 