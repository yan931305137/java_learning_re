# Java 输入输出

## 一、控制台输入输出

### 1. 标准输出
* `System.out.println()`: 输出并换行
* `System.out.print()`: 输出不换行
* `System.out.printf()`: 格式化输出
```java
System.out.println("Hello World");
System.out.printf("名字：%s，年龄：%d", "张三", 20);
```

### 2. 标准输入
* `Scanner`类
* `System.in.read()`
* `BufferedReader`配合`InputStreamReader`
```java
Scanner scanner = new Scanner(System.in);
String input = scanner.nextLine();

BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
String line = reader.readLine();
```

## 二、文件操作

### 1. File类
* 文件和目录操作
* 文件属性获取
* 文件创建和删除
```java
File file = new File("example.txt");
boolean exists = file.exists();
long length = file.length();
boolean isDirectory = file.isDirectory();
```

### 2. Files类（Java 7+）
* 文件读写
* 目录遍历
* 文件属性操作
* 文件复制和移动
```java
Path path = Paths.get("example.txt");
List<String> lines = Files.readAllLines(path);
Files.write(path, lines);
```

## 三、IO流体系

### 1. 字节流
* `InputStream`: 字节输入流基类
  * `FileInputStream`: 文件输入流
  * `BufferedInputStream`: 缓冲输入流
  * `DataInputStream`: 数据输入流
  * `ObjectInputStream`: 对象输入流

* `OutputStream`: 字节输出流基类
  * `FileOutputStream`: 文件输出流
  * `BufferedOutputStream`: 缓冲输出流
  * `DataOutputStream`: 数据输出流
  * `ObjectOutputStream`: 对象输出流

### 2. 字符流
* `Reader`: 字符输入流基类
  * `FileReader`: 文件读取
  * `BufferedReader`: 缓冲读取
  * `InputStreamReader`: 字节转字符

* `Writer`: 字符输出流基类
  * `FileWriter`: 文件写入
  * `BufferedWriter`: 缓冲写入
  * `OutputStreamWriter`: 字符转字节

## 四、NIO（New I/O）

### 1. 核心组件
* `Channel`: 通道
  * `FileChannel`: 文件通道
  * `SocketChannel`: Socket通道
  * `ServerSocketChannel`: 服务器Socket通道
  
* `Buffer`: 缓冲区
  * `ByteBuffer`
  * `CharBuffer`
  * `IntBuffer`
  * `LongBuffer`
  
* `Selector`: 选择器
  * 多路复用
  * 非阻塞IO

### 2. Path和Files
* 路径操作
* 文件操作
* 目录遍历
* 文件监控

## 五、序列化

### 1. 对象序列化
* `Serializable`接口
* `ObjectOutputStream`写入
* `ObjectInputStream`读取
```java
class Person implements Serializable {
    private String name;
    private int age;
}
```

### 2. 序列化控制
* `transient`关键字
* `serialVersionUID`
* 自定义序列化

## 六、高级特性

### 1. 异步IO（Java 7 NIO.2）
* 异步文件通道
* 异步Socket通道
* 完成处理器

### 2. 内存映射文件
* `MappedByteBuffer`
* 大文件处理
* 高性能IO

## 七、最佳实践

### 1. 资源管理
* 使用try-with-resources
* 正确关闭流
* 使用缓冲流提高性能
```java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        // 处理每一行
    }
}
```

### 2. 性能优化
* 使用缓冲区
* 适当的缓冲区大小
* 避免频繁小数据IO
* 考虑使用NIO
* 大文件使用内存映射

### 3. 异常处理
* 合理处理IO异常
* 资源释放保证
* 日志记录

### 4. 字符编码
* 明确指定字符编码
* 使用StandardCharsets
* 避免平台依赖
```java
try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(new FileInputStream("file.txt"), StandardCharsets.UTF_8))) {
    // 读取文件
}
```

### 5. 文件操作建议
* 使用相对路径
* 检查文件存在
* 权限验证
* 临时文件处理
* 文件锁定机制

## 八、常见问题

1. 内存泄漏
   * 未关闭流
   * 资源未释放
   * 大文件处理不当

2. 性能问题
   * 未使用缓冲
   * 缓冲区大小不合适
   * 频繁打开关闭流

3. 编码问题
   * 字符集不匹配
   * 平台差异
   * BOM标记处理

4. 并发访问
   * 文件锁
   * 线程安全
   * 并发控制 