# Java 控制语句（Control Statements）

Java 提供了丰富的控制语句来控制程序的流程，主要分为：条件语句、循环语句和跳转语句。

* * *

## 一、条件语句（Conditional Statements）

### 1. `if-else` 语句

    if (条件) {
        // 条件为 true 时执行
    } else {
        // 条件为 false 时执行
    }

#### 多重判断

    if (a > b) {
        // ...
    } else if (a == b) {
        // ...
    } else {
        // ...
    }

### 2. `switch-case` 语句

    switch (表达式) {
        case 值1:
            // 代码块
            break;
        case 值2:
            // 代码块
            break;
        default:
            // 默认代码块
    }

> 注意：`break` 用于终止 `switch`，否则会继续向下执行（称为“贯穿”）。

* * *

## 二、循环语句（Loop Statements）

### 1. `for` 循环

    for (int i = 0; i < 10; i++) {
        System.out.println(i);
    }

### 2. `while` 循环

    int i = 0;
    while (i < 10) {
        System.out.println(i);
        i++;
    }

### 3. `do-while` 循环

    int i = 0;
    do {
        System.out.println(i);
        i++;
    } while (i < 10);

> `do-while` 无论条件是否为 `true`，都会先执行一次循环体。

* * *

## 三、跳转语句（Jump Statements）

### 1. `break`

用于终止当前循环或 `switch` 块：

    for (int i = 0; i < 10; i++) {
        if (i == 5) break;
    }

### 2. `continue`

跳过本次循环，进入下一次循环：

    for (int i = 0; i < 10; i++) {
        if (i % 2 == 0) continue;
        System.out.println(i); // 输出奇数
    }

### 3. `return`

用于方法返回：

    public int sum(int a, int b) {
        return a + b;
    }

* * *

## 四、补充内容

### 1. 增强型 `for` 循环（foreach）

    int[] nums = {1, 2, 3, 4};
    for (int num : nums) {
        System.out.println(num);
    }

适用于遍历数组、集合等结构。

### 2. 标签（Label）的使用

在嵌套循环中跳出指定层级循环：

    outer:
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (j == 1) break outer;
        }
    }

> 使用标签可以更灵活地控制多层嵌套结构。

### 3. `switch` 表达式（Java 14+）

    int day = 2;
    String result = switch (day) {
        case 1 -> "Monday";
        case 2 -> "Tuesday";
        default -> "Other day";
    };

> 更加简洁，支持返回值。

* * *

## ✅ 小结口诀

    判断选择用 if，多个条件 switch 力。
    循环执行有三种，for、while 与 do-while。
    break 停止很果断，continue 跳过向前看。
    return 返回要牢记，增强 for-each 更简洁。
    标签控制层层跳，switch 新式更优雅。