package members;

import java.lang.reflect.*;

/**
 * 类成员反射示例
 */
public class ClassMembersExample {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("basic.ReflectionBasicExample");
            
            // 1. 构造器相关
            System.out.println("=== 构造器信息 ===");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("构造器：" + constructor);
            }
            
            // 2. 字段相关
            System.out.println("\n=== 字段信息 ===");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("字段：" + field.getName() + 
                                 ", 类型：" + field.getType());
            }
            
            // 3. 方法相关
            System.out.println("\n=== 方法信息 ===");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("方法：" + method.getName() + 
                                 ", 返回类型：" + method.getReturnType());
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
} 