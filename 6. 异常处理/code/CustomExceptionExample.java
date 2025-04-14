package code;

/**
 * 自定义异常示例
 */
// 自定义异常类
class AgeException extends Exception {
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }

    public AgeException(String message, Throwable cause) {
        super(message, cause);
    }
}

// 自定义运行时异常
class NameException extends RuntimeException {
    public NameException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public static void validateAge(int age) throws AgeException {
        if (age < 0) {
            throw new AgeException("年龄不能为负数");
        }
        if (age > 150) {
            throw new AgeException("年龄不能超过150岁");
        }
    }

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NameException("姓名不能为空");
        }
    }

    public static void main(String[] args) {
        // 1. 测试检查时异常（code.AgeException）
        System.out.println("=== 测试检查时异常 ===");
        try {
            validateAge(-5);
        } catch (AgeException e) {
            System.out.println("年龄验证异常：" + e.getMessage());
        }

        // 2. 测试运行时异常（code.NameException）
        System.out.println("\n=== 测试运行时异常 ===");
        try {
            validateName("");
        } catch (NameException e) {
            System.out.println("姓名验证异常：" + e.getMessage());
        }
    }
} 