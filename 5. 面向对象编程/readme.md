# Java 面向对象编程

## 一、类和对象基础

### 1. 类的定义
* 类是对象的模板
* 类包含属性（成员变量）和方法
* 类的命名规范：首字母大写，驼峰命名法
```java
public class Student {
    // 属性
    private String name;
    private int age;
    
    // 方法
    public void study() {
        // 方法实现
    }
}
```

### 2. 对象的创建和使用
* 使用new关键字创建对象
* 通过对象访问属性和方法
```java
Student student = new Student();
student.setName("张三");
student.study();
```

## 二、方法

### 1. 方法定义
* 方法是类中定义的函数
* 方法包含访问修饰符、返回类型、方法名、参数列表
```java
public void methodName(Type param) {
    // 方法体
    return value; // 如果有返回值
}
```

### 2. 方法重载（Overloading）
* 同一个类中方法名相同，参数列表不同
* 与返回类型无关
```java
public void print(String text) { }
public void print(int number) { }
public void print(String text, int times) { }
```

### 3. 方法重写（Overriding）
* 子类重写父类的方法
* 方法签名必须相同
* 访问权限不能更严格
```java
@Override
public String toString() {
    return "自定义的字符串表示";
}
```

### 4. 构造方法
* 与类同名的特殊方法
* 用于初始化对象
* 可以重载
```java
public class Person {
    public Person() { } // 默认构造方法
    public Person(String name) { } // 带参构造方法
}
```

## 三、访问修饰符

1. `public`: 任何类都可以访问
2. `protected`: 同包内的类和子类可以访问
3. `default`(无修饰符): 同包内的类可以访问
4. `private`: 只有本类可以访问

## 四、面向对象三大特性

### 1. 封装
* 将数据和操作数据的方法绑定在一起
* 隐藏内部实现细节
* 通过访问修饰符控制访问权限
```java
public class Account {
    private double balance;
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
```

### 2. 继承
* 使用extends关键字实现继承
* Java只支持单继承
* 子类可以访问父类的非私有成员
```java
public class Student extends Person {
    private String studentId;
    // 子类特有的属性和方法
}
```

### 3. 多态
* 父类引用指向子类对象
* 运行时动态绑定
* 提高代码的灵活性和可扩展性
```java
Animal animal = new Dog(); // 父类引用指向子类对象
animal.makeSound(); // 调用的是Dog的方法
```

## 五、抽象类和接口

### 1. 抽象类
* 使用abstract关键字声明
* 可以包含抽象方法和具体方法
* 不能被实例化
```java
public abstract class Shape {
    abstract double getArea(); // 抽象方法
    public void display() { } // 具体方法
}
```

### 2. 接口
* 使用interface关键字声明
* 只包含抽象方法（Java 8后可以有默认方法）
* 实现多个接口
```java
public interface Drawable {
    void draw(); // 抽象方法
    default void print() { } // 默认方法（Java 8+）
}
```

## 六、补充内容

### 1. 内部类
* 成员内部类：定义在类内部的非静态类
* 局部内部类：定义在方法中的类
* 匿名内部类：没有名字的内部类
* 静态内部类：使用static修饰的内部类

### 2. this和super关键字
* `this`: 指向当前对象
* `this()`: 调用本类其他构造方法
* `super`: 指向父类对象
* `super()`: 调用父类构造方法

### 3. 静态成员（static）
* 属于类而不是对象
* 通过类名直接访问
* 静态方法中不能访问非静态成员
```java
public class Utility {
    public static final double PI = 3.14159;
    public static void printMessage() { }
}
```

### 4. final关键字
* 修饰类：类不能被继承
* 修饰方法：方法不能被重写
* 修饰变量：变量成为常量

### 5. 枚举类型（enum）
* 特殊的类，表示一组常量
* 可以添加方法和构造器
```java
public enum Season {
    SPRING, SUMMER, AUTUMN, WINTER;
}
```

## 七、最佳实践

1. 类的设计原则
   * 单一职责原则
   * 开闭原则
   * 里氏替换原则
   * 接口隔离原则
   * 依赖倒置原则

2. 编码建议
   * 合理使用访问修饰符
   * 正确重写equals和hashCode方法
   * 适当使用final关键字
   * 避免过深的继承层次
   * 优先使用组合而不是继承

3. 性能考虑
   * 合理使用静态成员
   * 注意内部类的使用
   * 避免创建不必要的对象
   * 及时释放不需要的引用 