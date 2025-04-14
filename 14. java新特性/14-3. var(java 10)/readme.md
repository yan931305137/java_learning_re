# var 关键字（Java 10）

## 核心功能
`var`关键字是Java 10引入的一项功能，用于简化局部变量的声明，自动推断变量的类型。

## 1.1 `var`的定义
- **基本语法**: 使用`var`关键字声明局部变量，编译器会根据初始化表达式自动推断变量的类型。
  ```java
  var message = "Hello, World!";
  var number = 42;
  ```

## 1.2 `var`的优点
- **简化代码**: 减少样板代码，使代码更简洁。
- **提高可读性**: 通过推断类型，减少显式类型声明的冗余。
- **灵活性**: 适用于各种类型的局部变量声明。

## 1.3 使用场景
- **局部变量声明**: 在方法内部声明局部变量时使用。
- **循环变量**: 在增强型`for`循环中使用。
- **`try-with-resources`**: 在`try-with-resources`语句中声明资源。

## 1.4 示例代码
- **基本使用**:
  ```java
  var list = List.of("apple", "banana", "cherry");
  for (var fruit : list) {
      System.out.println(fruit);
  }
  ```

- **`try-with-resources`**:
  ```java
  try (var inputStream = new FileInputStream("file.txt")) {
      // 处理输入流
  } catch (IOException e) {
      e.printStackTrace();
  }
  ```
