package proxy;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 接口
interface UserService {
    void addUser(String name);
    void deleteUser(String name);
}

// 实现类
class UserServiceImpl implements UserService {
    @Override
    public void addUser(String name) {
        System.out.println("添加用户：" + name);
    }
    
    @Override
    public void deleteUser(String name) {
        System.out.println("删除用户：" + name);
    }
}

// 动态代理处理器
class LogHandler implements InvocationHandler {
    private Object target;
    
    public LogHandler(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行：" + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("执行结束：" + method.getName());
        return result;
    }
}

public class DynamicProxyExample {
    public static void main(String[] args) {
        // 创建目标对象
        UserService target = new UserServiceImpl();
        
        // 创建代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new LogHandler(target)
        );
        
        // 通过代理对象调用方法
        proxy.addUser("张三");
        proxy.deleteUser("李四");
    }
} 