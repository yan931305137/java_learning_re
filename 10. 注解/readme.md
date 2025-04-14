# Java 注解（Annotations）

## 一、注解基础

### 1. 什么是注解
* 注解是代码的元数据
* 不直接影响代码的执行
* 可以被编译器和运行时环境使用
* 用于提供信息给工具和框架

### 2. 注解的用途
* 编译器信息
* 编译时和部署时处理
* 运行时处理

## 二、内置注解

### 1. 编译相关注解
* `@Override`
  - 标记方法重写父类方法
  - 编译时检查是否正确重写

* `@Deprecated`
  - 标记过时的元素
  - 使用时会产生编译警告

* `@SuppressWarnings`
  - 抑制编译器警告
  - 可以指定抑制的警告类型

### 2. 文档相关注解
* `@Documented`
  - 标记注解应该被包含在JavaDoc中

### 3. 继承相关注解
* `@Inherited`
  - 标记注解可以被继承
  - 子类会继承父类的注解

## 三、元注解

### 1. @Target
指定注解可以应用的位置
```java
@Target(ElementType.METHOD)          // 只能应用于方法
@Target({ElementType.TYPE,          // 可以应用于类、接口
         ElementType.METHOD})        // 和方法
```

可用的ElementType值：
* `TYPE`: 类、接口、枚举
* `FIELD`: 字段
* `METHOD`: 方法
* `PARAMETER`: 参数
* `CONSTRUCTOR`: 构造器
* `LOCAL_VARIABLE`: 局部变量
* `ANNOTATION_TYPE`: 注解类型
* `PACKAGE`: 包
* `TYPE_PARAMETER`: 类型参数（Java 8）
* `TYPE_USE`: 类型使用（Java 8）

### 2. @Retention
指定注解的保留策略
```java
@Retention(RetentionPolicy.RUNTIME) // 运行时可用
```

保留策略选项：
* `SOURCE`: 源代码级别，编译时丢弃
* `CLASS`: 编译到class文件，运行时不可用
* `RUNTIME`: 运行时可通过反射访问

### 3. @Documented
表示注解应该包含在JavaDoc中

### 4. @Inherited
允许子类继承父类的注解

### 5. @Repeatable（Java 8+）
允许在同一个元素上多次使用相同的注解

## 四、自定义注解

### 1. 定义注解
```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "";     // 注解元素
    int count() default 0;
    String[] tags() default {};
}
```

### 2. 注解元素的类型
* 基本类型
* String
* Class
* 枚举
* 注解
* 以上类型的数组

### 3. 使用注解
```java
@MyAnnotation(value = "test", count = 1, tags = {"tag1", "tag2"})
public void someMethod() {
    // 方法实现
}
```

## 五、注解处理器

### 1. 运行时注解处理
```java
public class AnnotationProcessor {
    public static void process(Class<?> clazz) {
        // 获取类上的注解
        Annotation[] annotations = clazz.getAnnotations();
        
        // 获取方法上的注解
        for (Method method : clazz.getDeclaredMethods()) {
            MyAnnotation annotation = 
                method.getAnnotation(MyAnnotation.class);
            if (annotation != null) {
                // 处理注解
            }
        }
    }
}
```

### 2. 编译时注解处理
* 实现 `javax.annotation.processing.Processor` 接口
* 使用 `@SupportedAnnotationTypes` 指定支持的注解
* 使用 `@SupportedSourceVersion` 指定支持的源代码版本

## 六、常见应用场景

### 1. 配置信息
```java
@Configuration
@ComponentScan("com.example")
public class AppConfig {
    // 配置类
}
```

### 2. 依赖注入
```java
@Autowired
private UserService userService;
```

### 3. 单元测试
```java
@Test
@DisplayName("测试用例")
public void testMethod() {
    // 测试代码
}
```

### 4. REST API
```java
@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        // 处理逻辑
    }
}
```

## 七、最佳实践

### 1. 设计原则
* 明确注解的用途
* 适当使用默认值
* 提供充分的文档
* 考虑向后兼容性

### 2. 性能考虑
* 运行时注解会影响性能
* 合理使用保留策略
* 避免过度使用注解

### 3. 注意事项
* 注解不应该改变程序的语义
* 注意注解的继承关系
* 处理注解时要考虑空值情况
* 避免循环依赖

## 八、调试技巧

1. 反射工具
   * 查看运行时注解信息
   * 验证注解是否正确应用

2. 编译器参数
   * `-processor`: 指定注解处理器
   * `-processorpath`: 指定处理器路径

3. IDE支持
   * 注解高亮显示
   * 快速修复建议
   * 注解处理器调试 