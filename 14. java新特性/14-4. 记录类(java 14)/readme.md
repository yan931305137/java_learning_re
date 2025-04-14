# 记录类（Java 14+）

## 核心功能
记录类（Record）是Java 14引入的一种特殊类，旨在简化数据对象的定义。记录类自动生成构造方法、`equals()`、`hashCode()` 和 `toString()` 等方法，减少了样板代码。

## 1.1 记录类的定义
- **基本语法**: 使用`record`关键字定义记录类。
  ```java
  public record Point(int x, int y) {}
  ```

- **自动生成的方法**:
  - **构造方法**: 根据定义的字段自动生成。
  - **`equals()`**: 比较两个记录类对象的字段值。
  - **`hashCode()`**: 根据字段值生成哈希码。
  - **`toString()`**: 返回记录类对象的字符串表示。

## 1.2 记录类的优点
- **简洁性**: 减少样板代码，专注于数据的定义。
- **不可变性**: 记录类的字段默认是`final`，确保对象的不可变性。
- **模式匹配**: 支持在`switch`语句中使用模式匹配。

## 1.3 使用场景
- **数据传输对象（DTO）**: 用于封装数据传输的对象。
- **值对象**: 表示不可变的值对象。
- **轻量级数据结构**: 用于简单的数据存储和操作。

## 1.4 示例代码
- **定义记录类**:
  ```java
  public record Person(String name, int age) {}
  ```

- **使用记录类**:
  ```java
  Person person = new Person("Alice", 30);
  System.out.println(person.name()); // 输出: Alice
  System.out.println(person); // 输出: Person[name=Alice, age=30]
  ```
