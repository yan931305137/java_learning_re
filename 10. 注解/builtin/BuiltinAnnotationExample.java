package builtin;

import java.util.ArrayList;
import java.util.List;

/**
 * 内置注解示例
 */
public class BuiltinAnnotationExample {
    
    // 1. @Override示例
    @Override
    public String toString() {
        return "BuiltinAnnotationExample";
    }
    
    // 2. @Deprecated示例
    @Deprecated
    public void oldMethod() {
        System.out.println("这是一个过时的方法");
    }
    
    // 3. @SuppressWarnings示例
    @SuppressWarnings("unchecked")
    public void suppressWarningMethod() {
        List list = new ArrayList();
        list.add("示例");
    }
    
    public static void main(String[] args) {
        BuiltinAnnotationExample example = new BuiltinAnnotationExample();
        
        // 测试@Override
        System.out.println(example.toString());
        
        // 测试@Deprecated
        example.oldMethod();  // IDE会显示删除线
        
        // 测试@SuppressWarnings
        example.suppressWarningMethod();
    }
} 