# Java 常用类库

## 一、String类

### 1. 字符串基础
* 字符串是不可变的（immutable）
* 字符串常量池
* 字符串的创建方式
```java
String str1 = "Hello";              // 字面量创建
String str2 = new String("Hello");  // 构造方法创建
```

### 2. 常用方法
* `length()`: 获取字符串长度
* `charAt()`: 获取指定位置的字符
* `substring()`: 截取子字符串
* `indexOf()`: 查找字符或子串位置
* `replace()`: 替换字符或子串
* `trim()`: 去除首尾空格
* `split()`: 分割字符串
* `toLowerCase()`: 转小写
* `toUpperCase()`: 转大写
* `equals()`: 比较字符串内容
* `equalsIgnoreCase()`: 忽略大小写比较

## 二、StringBuilder和StringBuffer

### 1. 特点比较
* `StringBuilder`: 非线程安全，性能较好
* `StringBuffer`: 线程安全，性能较差
* 都是可变的字符序列

### 2. 常用方法
* `append()`: 追加内容
* `insert()`: 插入内容
* `delete()`: 删除内容
* `reverse()`: 反转
* `toString()`: 转换为String

## 三、包装类

### 1. 基本类型对应的包装类
* `byte` → `Byte`
* `short` → `Short`
* `int` → `Integer`
* `long` → `Long`
* `float` → `Float`
* `double` → `Double`
* `char` → `Character`
* `boolean` → `Boolean`

### 2. 常用功能
* 类型转换
* 字符串解析
* 值比较
* 常量定义
```java
Integer.parseInt("123");    // 字符串转整数
Integer.toString(123);      // 整数转字符串
Integer.MAX_VALUE;          // 最大值常量
Integer.MIN_VALUE;          // 最小值常量
```

## 四、Math类

### 1. 数学运算
* `abs()`: 绝对值
* `max()`, `min()`: 最大值、最小值
* `ceil()`: 向上取整
* `floor()`: 向下取整
* `round()`: 四舍五入
* `random()`: 随机数
* `pow()`: 幂运算
* `sqrt()`: 平方根

### 2. 常量
* `Math.PI`: 圆周率
* `Math.E`: 自然对数的底

## 五、日期和时间API

### 1. 传统日期类（不推荐）
* `Date`
* `Calendar`
* `SimpleDateFormat`

### 2. 现代日期时间API（Java 8+）
* `LocalDate`: 日期
* `LocalTime`: 时间
* `LocalDateTime`: 日期时间
* `ZonedDateTime`: 带时区的日期时间
* `Period`: 日期间隔
* `Duration`: 时间间隔
* `DateTimeFormatter`: 格式化

```java
LocalDate today = LocalDate.now();
LocalTime now = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();
```

## 六、集合框架

### 1. List接口
* `ArrayList`: 动态数组实现
* `LinkedList`: 双向链表实现
* `Vector`: 线程安全的动态数组（不推荐）

### 2. Set接口
* `HashSet`: 基于哈希表
* `TreeSet`: 基于红黑树，有序
* `LinkedHashSet`: 维护插入顺序

### 3. Map接口
* `HashMap`: 基于哈希表
* `TreeMap`: 基于红黑树，有序
* `LinkedHashMap`: 维护插入顺序
* `Hashtable`: 线程安全（不推荐）

### 4. Queue接口
* `LinkedList`: 双向队列
* `PriorityQueue`: 优先队列
* `ArrayDeque`: 数组双向队列

## 七、正则表达式

### 1. Pattern类和Matcher类
```java
Pattern pattern = Pattern.compile("regex");
Matcher matcher = pattern.matcher("text");
```

### 2. 常用方法
* `matches()`: 完全匹配
* `find()`: 查找下一个匹配
* `group()`: 获取匹配内容
* `replaceAll()`: 替换所有匹配

## 八、Optional类（Java 8+）

### 1. 创建Optional对象
* `Optional.empty()`: 空Optional
* `Optional.of()`: 非空值
* `Optional.ofNullable()`: 可能为空的值

### 2. 常用方法
* `isPresent()`: 判断是否存在值
* `ifPresent()`: 如果存在则执行
* `orElse()`: 不存在则返回默认值
* `orElseGet()`: 不存在则计算默认值
* `map()`: 转换值
* `flatMap()`: 转换为Optional

## 九、最佳实践

### 1. 字符串处理
* 频繁修改字符串时使用StringBuilder
* 多线程环境考虑使用StringBuffer
* 注意字符串常量池的使用

### 2. 集合使用
* 选择合适的集合类型
* 注意线程安全
* 合理使用泛型
* 遵循集合框架的规范

### 3. 日期时间处理
* 优先使用新的日期时间API
* 注意时区处理
* 使用合适的格式化方式

### 4. 正则表达式
* 预编译正则表达式
* 注意性能影响
* 合理使用分组

### 5. Optional使用
* 避免直接调用get()
* 合理使用orElse()和orElseGet()
* 使用map()和flatMap()进行转换 