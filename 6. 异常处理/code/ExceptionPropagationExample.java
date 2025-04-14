package code;

/**
 * 异常传播示例
 */
public class ExceptionPropagationExample {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("在main方法中捕获异常：");
            System.out.println("异常类型：" + e.getClass().getName());
            System.out.println("异常消息：" + e.getMessage());
            System.out.println("异常堆栈：");
            e.printStackTrace();
        }
    }

    public static void method1() throws Exception {
        System.out.println("method1开始执行");
        method2();
        System.out.println("method1结束执行");
    }

    public static void method2() throws Exception {
        System.out.println("method2开始执行");
        method3();
        System.out.println("method2结束执行");
    }

    public static void method3() throws Exception {
        System.out.println("method3开始执行");
        throw new Exception("在method3中抛出异常");
    }
} 