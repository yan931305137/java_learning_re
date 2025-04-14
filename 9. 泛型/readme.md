# Java 泛型

## 一、泛型基础

### 1. 什么是泛型
* 泛型是Java 5引入的特性
* 在编译时提供类型检查
* 消除类型转换
* 允许类和方法操作不同类型
```java
List<String> list = new ArrayList<>();  // 使用泛型
List rawList = new ArrayList();         // 不使用泛型（原始类型）
```

### 2. 泛型命名约定
* `T` - Type（类型）
* `E` - Element（元素）
* `K` - Key（键）
* `V` - Value（值）
* `N` - Number（数值类型）
* `?` - 通配符

## 二、泛型类

### 1. 定义泛型类
```java
public class Box<T> {
    private T content;
    
    public void set(T content) {
        this.content = content;
    }
    
    public T get() {
        return content;
    }
}
```

### 2. 使用泛型类
```java
Box<String> stringBox = new Box<>();
stringBox.set("Hello");
String str = stringBox.get();

Box<Integer> intBox = new Box<>();
intBox.set(123);
int num = intBox.get();
```

## 三、泛型方法

### 1. 定义泛型方法
```java
public class Util {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    public static <T, U> Pair<T, U> makePair(T first, U second) {
        return new Pair<>(first, second);
    }
}
```

### 2. 调用泛型方法
```java
String[] strings = {"Hello", "World"};
Util.printArray(strings);

Integer[] numbers = {1, 2, 3};
Util.printArray(numbers);

Pair<String, Integer> pair = Util.makePair("Age", 25);
```

## 四、泛型通配符

### 1. 无界通配符（?）
* 表示任意类型
* 主要用于读取数据
```java
public void printList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}
```

### 2. 上界通配符（? extends Type）
* 表示Type或其子类型
* 用于读取数据
```java
public double sumOfList(List<? extends Number> list) {
    double sum = 0.0;
    for (Number num : list) {
        sum += num.doubleValue();
    }
    return sum;
}
```

### 3. 下界通配符（? super Type）
* 表示Type或其父类型
* 用于写入数据
```java
public void addNumbers(List<? super Integer> list) {
    list.add(1);
    list.add(2);
    list.add(3);
}
```

## 五、类型擦除

### 1. 概念
* Java泛型是通过类型擦除实现的
* 编译时检查类型，运行时移除泛型信息
* 保证与旧版本Java的兼容性

### 2. 擦除规则
* 无限制类型参数被替换为Object
* 有界类型参数被替换为第一个边界
* 保留用于类型检查的信息

### 3. 示例
```java
// 源代码
public class Box<T> {
    private T content;
}

// 类型擦除后
public class Box {
    private Object content;
}
```

## 六、泛型约束

### 1. 泛型边界
```java
// 单个边界
public class NumberBox<T extends Number> { }

// 多个边界
public class DataProcessor<T extends Number & Comparable<T>> { }
```

### 2. 泛型数组限制
* 不能创建泛型数组
* 不能创建参数化类型的数组
```java
// 不允许
T[] array = new T[10];  // 编译错误

// 允许
T[] array = (T[]) new Object[10];  // 需要类型转换
```

## 七、最佳实践

### 1. 设计原则
* 优先使用泛型而不是原始类型
* 明确指定类型参数
* 适当使用通配符
* 注意类型擦除的影响

### 2. 常见错误
* 泛型类型不匹配
* 原始类型使用
* 泛型数组创建
* 类型擦除引起的问题

### 3. 性能考虑
* 泛型不会导致运行时开销
* 装箱和拆箱可能影响性能
* 合理使用基本类型

## 八、实际应用场景

### 1. 集合框架
```java
List<String> list = new ArrayList<>();
Map<String, Integer> map = new HashMap<>();
```

### 2. 自定义数据结构
```java
public class Stack<E> {
    private List<E> elements = new ArrayList<>();
    
    public void push(E element) {
        elements.add(element);
    }
    
    public E pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }
}
```

### 3. 通用工具类
```java
public class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() { return key; }
    public V getValue() { return value; }
}
```

## 九、注意事项

1. 类型安全
   * 编译时类型检查
   * 避免运行时类型错误
   * 注意类型擦除的影响

2. 兼容性
   * 与旧代码的互操作性
   * 处理原始类型
   * 泛型类型的继承关系

3. 限制
   * 不能用基本类型作为类型参数
   * 不能创建泛型数组
   * 不能创建泛型异常类 