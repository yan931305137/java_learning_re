# Java 反射机制

## 1. 反射基础
### 1.1 什么是反射
- 反射是Java的一个重要特性，允许程序在运行时检查和修改程序的结构和行为
- 通过反射，可以在运行时获取类的信息，创建对象，调用方法，访问字段等
- 反射打破了Java的封装性，使得我们可以访问私有成员

### 1.2 反射的优缺点
优点：
- 提高了程序的灵活性和扩展性
- 支持动态加载类和使用类
- 是很多框架实现的基础（如Spring）

缺点：
- 性能开销较大
- 可能破坏封装性
- 可能导致安全问题

## 2. Class类
### 2.1 获取Class对象的方式
```java
// 方式1：通过类名.class
Class<?> clazz1 = String.class;

// 方式2：通过对象.getClass()
String str = "Hello";
Class<?> clazz2 = str.getClass();

// 方式3：通过Class.forName()
Class<?> clazz3 = Class.forName("java.lang.String");
```

### 2.2 Class类的常用方法
- `getName()`: 获取类的完整名称
- `getSimpleName()`: 获取类的简单名称
- `getModifiers()`: 获取类的修饰符
- `getSuperclass()`: 获取父类
- `getInterfaces()`: 获取实现的接口
- `getPackage()`: 获取类的包信息

## 3. 获取类信息
### 3.1 构造器相关
- `getConstructors()`: 获取所有公共构造器
- `getDeclaredConstructors()`: 获取所有构造器
- `getConstructor(Class<?>... parameterTypes)`: 获取特定参数类型的公共构造器

### 3.2 方法相关
- `getMethods()`: 获取所有公共方法
- `getDeclaredMethods()`: 获取所有方法
- `getMethod(String name, Class<?>... parameterTypes)`: 获取特定名称和参数的公共方法

### 3.3 字段相关
- `getFields()`: 获取所有公共字段
- `getDeclaredFields()`: 获取所有字段
- `getField(String name)`: 获取特定名称的公共字段

### 3.4 注解相关
- `getAnnotations()`: 获取所有注解
- `getDeclaredAnnotations()`: 获取直接标注的注解
- `getAnnotation(Class<A> annotationClass)`: 获取特定类型的注解

## 4. 动态创建和操作对象
### 4.1 创建对象
```java
// 使用Constructor创建对象
Constructor<?> constructor = clazz.getConstructor();
Object obj = constructor.newInstance();

// 使用Class直接创建对象（调用无参构造器）
Object obj2 = clazz.newInstance();
```

### 4.2 调用方法
```java
Method method = clazz.getMethod("methodName", String.class);
method.invoke(obj, "parameter");
```

### 4.3 访问字段
```java
Field field = clazz.getDeclaredField("fieldName");
field.setAccessible(true); // 访问私有字段
field.set(obj, value);
```

## 5. 动态代理
### 5.1 JDK动态代理
- 基于接口的代理
- 使用`Proxy.newProxyInstance()`创建代理对象
- 需要实现`InvocationHandler`接口

### 5.2 CGLIB动态代理
- 基于继承的代理
- 可以代理没有实现接口的类
- 不能代理final类和方法

## 6. MethodHandle
### 6.1 基本概念
- Java 7引入的新特性
- 类似于反射，但性能更好
- 提供更细粒度的类型检查

### 6.2 主要组件
- `MethodHandles.Lookup`: 查找方法句柄
- `MethodType`: 描述方法类型
- `MethodHandle`: 方法句柄本身

## 7. 最佳实践
### 7.1 性能优化
- 缓存Class对象和反射对象
- 适当使用setAccessible()
- 考虑使用MethodHandle替代反射

### 7.2 安全考虑
- 在可控环境下使用反射
- 注意访问权限控制
- 防止反射攻击

### 7.3 常见应用场景
- 框架开发
- 插件系统
- 单元测试
- 序列化/反序列化

## 8. 常见问题和解决方案
### 8.1 常见异常
- `ClassNotFoundException`
- `NoSuchMethodException`
- `IllegalAccessException`
- `InvocationTargetException`

### 8.2 调试技巧
- 使用日志记录反射操作
- 检查访问权限
- 验证参数类型匹配

## 9. 补充说明
### 9.1 反射与泛型
- 获取泛型信息
- 类型擦除的影响
- 使用`TypeToken`处理泛型

### 9.2 反射与模块化
- Java 9模块系统的影响
- 开放模块的反射访问
- 处理模块化环境下的反射限制 