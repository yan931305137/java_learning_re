# Java 异常处理

## 一、异常体系结构

### 1. Throwable类层次
* `Throwable`（所有异常和错误的父类）
  * `Error`（严重错误，不应捕获）
    * `OutOfMemoryError`
    * `StackOverflowError`
    * `NoClassDefFoundError`
  * `Exception`（异常，应当处理）
    * `RuntimeException`（运行时异常）
      * `NullPointerException`
      * `ArrayIndexOutOfBoundsException`
      * `ClassCastException`
      * `ArithmeticException`
    * 其他异常（检查时异常）
      * `IOException`
      * `SQLException`
      * `ClassNotFoundException`

### 2. 异常分类
1. **检查时异常**（Checked Exception）
   * 必须显式处理或声明抛出
   * 在编译时检查
   * 例如：IOException, SQLException

2. **运行时异常**（Runtime Exception）
   * 可以不显式处理
   * 在运行时检查
   * 例如：NullPointerException, ArrayIndexOutOfBoundsException

3. **错误**（Error）
   * 表示严重问题
   * 程序通常无法处理
   * 例如：OutOfMemoryError, StackOverflowError

## 二、异常处理语法

### 1. try-catch-finally
```java
try {
    // 可能抛出异常的代码
} catch (Exception1 e1) {
    // 处理Exception1
} catch (Exception2 e2) {
    // 处理Exception2
} finally {
    // 总是执行的代码
}
```

### 2. try-with-resources（Java 7+）
```java
try (Resource res1 = new Resource();
     Resource res2 = new Resource()) {
    // 使用资源
} catch (Exception e) {
    // 处理异常
}
// 资源自动关闭
```

### 3. 多重catch块
```java
try {
    // 可能抛出多个异常的代码
} catch (FileNotFoundException | SQLException e) {
    // 处理多个异常
}
```

### 4. throw和throws
```java
public void method() throws Exception {
    if (condition) {
        throw new Exception("错误信息");
    }
}
```

## 三、自定义异常

### 1. 创建自定义异常
```java
public class CustomException extends Exception {
    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

### 2. 使用自定义异常
```java
public void validate(int age) throws CustomException {
    if (age < 0) {
        throw new CustomException("年龄不能为负数");
    }
}
```

## 四、异常处理最佳实践

### 1. 基本原则
* 只捕获可以处理的异常
* 尽早抛出异常，尽晚捕获异常
* 细化异常类型，避免捕获Exception
* 正确使用finally块
* 合理使用try-with-resources

### 2. 注意事项
1. **避免空catch块**
```java
try {
    // 代码
} catch (Exception e) {
    // 至少要记录日志
    logger.error("发生错误", e);
}
```

2. **合理使用异常层次**
```java
try {
    // 数据库操作
} catch (SQLException e) {
    throw new DatabaseException("数据库错误", e);
}
```

3. **资源管理**
```java
// 推荐：使用try-with-resources
try (FileInputStream fis = new FileInputStream("file.txt")) {
    // 使用文件
}

// 不推荐：手动关闭资源
FileInputStream fis = null;
try {
    fis = new FileInputStream("file.txt");
    // 使用文件
} finally {
    if (fis != null) {
        fis.close();
    }
}
```

### 3. 性能考虑
* 异常处理影响性能
* 不要用异常控制程序流程
* 避免过度细化异常捕获
* 合理使用异常缓存机制

## 五、调试技巧

1. **异常堆栈分析**
   * 查看异常类型和消息
   * 分析堆栈跟踪
   * 定位异常源头

2. **日志记录**
   * 使用日志框架记录异常
   * 包含上下文信息
   * 合理设置日志级别

3. **断点调试**
   * 在可能出现异常的地方设置断点
   * 观察变量值变化
   * 跟踪程序执行流程 