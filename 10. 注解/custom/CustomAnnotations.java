package custom;

import java.lang.annotation.*;

/**
 * 自定义注解示例
 */
// 1. 方法注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MethodInfo {
    String author() default "unknown";
    String date();
    int revision() default 1;
    String comments();
}

// 2. 类注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface ClassInfo {
    String value();
}

// 3. 字段注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldInfo {
    String description();
}

// 4. 可重复注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Roles.class)
@interface Role {
    String value();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Roles {
    Role[] value();
}

// 使用自定义注解的示例类
@ClassInfo("测试类")
@Role("admin")
@Role("user")
public class CustomAnnotations {
    
    @FieldInfo(description = "用户名")
    private String username;
    
    @MethodInfo(
        author = "张三",
        date = "2024/01/01",
        comments = "测试方法"
    )
    public void testMethod() {
        System.out.println("测试方法执行");
    }
} 