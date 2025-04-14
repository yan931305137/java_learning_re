# Java 变量和数据类型

## 一、基本数据类型（Primitive Types）

Java 中共有 8 种基本数据类型：

| 类型  | 大小  | 默认值 | 描述  |
| --- | --- | --- | --- |
| `byte` | 1字节 | 0   | -128 到 127 |
| `short` | 2字节 | 0   | -32,768 到 32,767 |
| `int` | 4字节 | 0   | 常用整数类型 |
| `long` | 8字节 | 0L  | 更大范围整数 |
| `float` | 4字节 | 0.0f | 单精度小数 |
| `double` | 8字节 | 0.0d | 双精度小数（默认） |
| `char` | 2字节 | '\u0000' | 单个字符，单引号包裹 |
| `boolean` | 1字节 | false | true / false |

* * *

## 二、引用数据类型（Reference Types）

* `String`：字符串
* 数组：如 `int[]`, `String[]`
* 类：如 `Scanner`, 自定义类等
* 接口、枚举等也属于引用类型

* * *

## 三、标识符命名规则

* 不能以数字开头
* 不能使用 Java 保留字
* 区分大小写
* 一般使用驼峰命名法（如 `studentName`）

* * *

## 四、关键字和保留字

* Java 中有大量保留关键字，如：`class`, `public`, `static`, `void`, `int`, `return` 等
* 一些关键字（如 `goto`, `const`）虽然未使用，但不能作为变量名

* * *

## 五、补充内容

### 1. 自动装箱和拆箱（Autoboxing & Unboxing）

* **自动装箱**：基本类型 → 包装类
* **自动拆箱**：包装类 → 基本类型

    Integer a = 10;  // 自动装箱
    int b = a;       // 自动拆箱

### 2. 类型转换（Type Casting）

#### ✅ 隐式转换（自动转换）：

    int a = 10;
    double d = a; // int → double

#### ❗ 显式转换（强制转换）：

    double d = 3.14;
    int a = (int) d; // double → int，结果为 3

### 3. 常量（final）

使用 `final` 关键字修饰变量，表示常量：

    final int MAX_COUNT = 100;

* * *

## 六、包装类（Wrapper Classes）

Java 为每个基本类型提供了对应的包装类：

| 基本类型 | 包装类 |
| --- | --- |
| `int` | `Integer` |
| `double` | `Double` |
| `boolean` | `Boolean` |
| `char` | `Character` |
| `byte` | `Byte` |
| `short` | `Short` |
| `long` | `Long` |
| `float` | `Float` |

* * *

## ✅ 小结口诀

    基本类型八兄弟，引用类型类数组；
    标识符讲规则，关键字要记熟；
    装箱拆箱要掌握，强转隐转不能丢；
    final 常量值不变，包装类中用泛型。