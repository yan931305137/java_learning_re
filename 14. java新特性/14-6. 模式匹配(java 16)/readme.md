# 模式匹配（Java 16+）

## 核心功能
模式匹配（Pattern Matching）是Java 16引入的一项功能，旨在简化类型检查和转换，使代码更简洁、易懂。

## 1.1 模式匹配的定义
- **基本语法**: 使用`instanceof`操作符进行类型检查时，直接在条件中进行类型转换。
  ```java
  if (obj instanceof String s) {
      System.out.println("String value: " + s);
  }
  ```

## 1.2 模式匹配的优点
- **简化代码**: 减少冗余的类型转换代码。
- **提高可读性**: 使类型检查和转换的意图更加明确。
- **减少错误**: 避免手动类型转换时可能出现的错误。

## 1.3 使用场景
- **类型检查和转换**: 在需要对对象进行类型检查和转换的场景中使用。
- **条件语句**: 在`if`、`switch`等条件语句中使用，简化逻辑。

## 1.4 示例代码
- **使用模式匹配进行类型检查**:
  ```java
  Object obj = "Hello, World!";
  if (obj instanceof String s) {
      System.out.println("String length: " + s.length());
  }
  ```

- **在条件语句中使用模式匹配**:
  ```java
  Object obj = 123;
  if (obj instanceof Integer i && i > 100) {
      System.out.println("Integer value is greater than 100: " + i);
  }
  ```

