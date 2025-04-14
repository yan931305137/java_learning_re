# 1. Lambda 表达式（Java 8）

## 核心功能
Lambda表达式使得Java支持函数式编程，简化了匿名内部类的使用，使得代码更简洁。

## 1.1 Lambda表达式语法
- **基本语法**: `(参数列表) -> {函数体}`
  ```java
  (int a, int b) -> a + b
  ```

- **无参数**: `() -> {函数体}`
  ```java
  () -> System.out.println("Hello, Lambda!")
  ```

- **单个参数**: `参数 -> {函数体}`
  ```java
  x -> x * x
  ```

- **多条语句**: 使用大括号包裹
  ```java
  (int a, int b) -> {
      int sum = a + b;
      return sum;
  }
  ```

## 1.2 函数式接口
- **定义**: 仅包含一个抽象方法的接口。
- **常用接口**: `Runnable`, `Callable`, `Comparator`, `Function`, `Consumer`, `Supplier`, `Predicate`。

## 1.3 使用场景
- **集合遍历**: 使用`forEach`方法
  ```java
  List<String> list = Arrays.asList("a", "b", "c");
  list.forEach(item -> System.out.println(item));
  ```

- **线程创建**: 使用`Runnable`
  ```java
  new Thread(() -> System.out.println("Thread running")).start();
  ```

- **事件处理**: 简化事件监听器
  ```java
  button.addActionListener(e -> System.out.println("Button clicked"));
  ```

## 1.4 方法引用
- **静态方法引用**: `ClassName::methodName`
  ```java
  Arrays.sort(array, Integer::compare);
  ```

- **实例方法引用**: `instance::methodName`
  ```java
  list.forEach(System.out::println);
  ```

- **构造器引用**: `ClassName::new`
  ```java
  Supplier<List<String>> listSupplier = ArrayList::new;
  ```

## 1.5 Stream API
- **结合使用**: Lambda表达式与Stream API结合使用，简化集合操作。
  ```java
  List<String> filtered = list.stream()
      .filter(s -> s.startsWith("a"))
      .collect(Collectors.toList());
  ```

