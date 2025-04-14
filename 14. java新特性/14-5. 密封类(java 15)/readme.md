# 密封类（Java 15+）

## 核心功能
密封类（Sealed Classes）是Java 15引入的一种特殊类，允许开发者指定哪些类可以继承或实现密封类，从而控制继承结构。

## 1.1 密封类的定义
- **基本语法**: 使用`sealed`关键字定义密封类，并使用`permits`关键字指定允许继承的子类。
  ```java
  public sealed class Shape permits Circle, Rectangle {
      // 类的内容
  }
  ```

- **子类的定义**:
  - **`final`**: 子类不能被进一步继承。
  - **`sealed`**: 子类可以继续限制其子类。
  - **`non-sealed`**: 子类可以被自由继承。

## 1.2 密封类的优点
- **控制继承结构**: 精确控制哪些类可以继承密封类，增强代码的安全性和可维护性。
- **模式匹配**: 与模式匹配结合使用，简化代码逻辑。

## 1.3 使用场景
- **状态模式**: 限制状态的数量和类型。
- **策略模式**: 控制策略的实现类。
- **其他需要精确控制继承关系的场景**。

## 1.4 示例代码
- **定义密封类**:
  ```java
  public sealed class Shape permits Circle, Rectangle {}
  ```

- **定义子类**:
  ```java
  public final class Circle extends Shape {}
  public non-sealed class Rectangle extends Shape {}
  ```
