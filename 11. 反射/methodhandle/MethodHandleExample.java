package methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * MethodHandle示例
 */
public class MethodHandleExample {
    private String message;
    
    public MethodHandleExample(String message) {
        this.message = message;
    }
    
    private void printMessage() {
        System.out.println(message);
    }
    
    public static void main(String[] args) {
        try {
            // 创建Lookup对象
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            
            // 获取构造器MethodHandle
            MethodType constructorType = MethodType.methodType(void.class, String.class);
            MethodHandle constructorHandle = lookup.findConstructor(
                MethodHandleExample.class, 
                constructorType
            );
            
            // 创建对象
            MethodHandleExample instance = (MethodHandleExample) constructorHandle
                .invoke("Hello MethodHandle!");
            
            // 获取私有方法的MethodHandle
            MethodType methodType = MethodType.methodType(void.class);
            MethodHandle methodHandle = lookup.findVirtual(
                MethodHandleExample.class,
                "printMessage",
                methodType
            );
            
            // 调用方法
            methodHandle.invoke(instance);
            
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
} 