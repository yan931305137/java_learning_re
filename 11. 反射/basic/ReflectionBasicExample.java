package basic;

/**
 * 反射基础示例
 */
public class ReflectionBasicExample {
    private String name;
    private int age;
    
    public ReflectionBasicExample() {}
    
    public ReflectionBasicExample(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    private void privateMethod() {
        System.out.println("这是私有方法");
    }
    
    public static void main(String[] args) {
        try {
            // 1. 获取Class对象的三种方式
            // 方式1：类名.class
            Class<?> clazz1 = ReflectionBasicExample.class;
            
            // 方式2：对象.getClass()
            ReflectionBasicExample obj = new ReflectionBasicExample();
            Class<?> clazz2 = obj.getClass();
            
            // 方式3：Class.forName()
            Class<?> clazz3 = Class.forName("basic.ReflectionBasicExample");
            
            // 输出类信息
            System.out.println("完整类名：" + clazz1.getName());
            System.out.println("简单类名：" + clazz1.getSimpleName());
            System.out.println("包名：" + clazz1.getPackage().getName());
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
} 