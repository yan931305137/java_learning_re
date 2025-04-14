package practical;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 实际应用示例：字段验证注解
 */
// 验证注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface NotNull {
    String message() default "字段不能为null";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Length {
    int min() default 0;
    int max() default Integer.MAX_VALUE;
    String message() default "长度不符合要求";
}

// 用户类
class User {
    @NotNull(message = "用户名不能为空")
    @Length(min = 4, max = 20, message = "用户名长度必须在4-20之间")
    private String username;
    
    @NotNull(message = "密码不能为空")
    @Length(min = 6, message = "密码长度不能少于6位")
    private String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

// 验证器
class Validator {
    public static void validate(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);
            
            // 验证@NotNull
            if (field.isAnnotationPresent(NotNull.class)) {
                NotNull notNull = field.getAnnotation(NotNull.class);
                if (value == null) {
                    throw new ValidationException(notNull.message());
                }
            }
            
            // 验证@Length
            if (field.isAnnotationPresent(Length.class) && value instanceof String) {
                Length length = field.getAnnotation(Length.class);
                String strValue = (String) value;
                if (strValue.length() < length.min() || strValue.length() > length.max()) {
                    throw new ValidationException(length.message());
                }
            }
        }
    }
}

// 自定义验证异常
class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

public class ValidationExample {
    public static void main(String[] args) {
        try {
            // 测试有效用户
            User validUser = new User("johndoe", "password123");
            Validator.validate(validUser);
            System.out.println("验证通过：有效用户");

            // 测试无效用户（用户名太短）
            User invalidUser = new User("jo", "password123");
            Validator.validate(invalidUser);
        } catch (ValidationException e) {
            System.out.println("验证失败：" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 