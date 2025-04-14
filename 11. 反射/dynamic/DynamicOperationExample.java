package dynamic;

import java.lang.reflect.*;

/**
 * 动态操作示例
 */
public class DynamicOperationExample {
    public static void main(String[] args) {
        try {
            // 1. 动态创建对象
            Class<?> clazz = Class.forName("basic.ReflectionBasicExample");
            Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
            Object obj = constructor.newInstance("张三", 25);
            
            // 2. 动态访问字段
            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true);  // 设置可访问私有字段
            System.out.println("原始name值：" + nameField.get(obj));
            nameField.set(obj, "李四");
            System.out.println("修改后name值：" + nameField.get(obj));
            
            // 3. 动态调用方法
            Method privateMethod = clazz.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true);  // 设置可访问私有方法
            privateMethod.invoke(obj);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 