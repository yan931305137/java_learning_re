# Java 数组

## 一、数组基础

### 1. 数组的定义
* 数组是一种用于存储同一类型数据的容器
* 数组的长度是固定的
* 数组元素在内存中连续存储

### 2. 数组的声明
```java
// 方式1：声明时不分配空间
int[] numbers;
String[] names;

// 方式2：声明同时分配空间
int[] numbers = new int[5];
String[] names = new String[10];

// 方式3：声明并初始化
int[] numbers = {1, 2, 3, 4, 5};
String[] names = {"Tom", "Jerry", "Spike"};
```

### 3. 数组的访问
* 通过索引访问数组元素（索引从0开始）
* 使用数组名.length获取数组长度
```java
int[] numbers = {1, 2, 3, 4, 5};
System.out.println(numbers[0]);     // 访问第一个元素
System.out.println(numbers.length); // 获取数组长度
```

## 二、多维数组

### 1. 二维数组
* 可以看作是数组的数组
* 常用于表格数据存储
```java
// 声明和初始化
int[][] matrix = new int[3][4];
int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};

// 访问元素
matrix[0][0] = 1;  // 第一行第一列
```

### 2. 不规则数组
* 每行的列数可以不同
```java
int[][] irregular = new int[3][];
irregular[0] = new int[4];
irregular[1] = new int[2];
irregular[2] = new int[3];
```

## 三、数组操作

### 1. 数组遍历
```java
// 方式1：for循环
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

// 方式2：增强for循环（foreach）
for (int element : arr) {
    System.out.println(element);
}
```

### 2. 数组工具类Arrays
* `Arrays.toString()` - 将数组转换为字符串
* `Arrays.sort()` - 数组排序
* `Arrays.binarySearch()` - 二分查找
* `Arrays.copyOf()` - 数组复制
* `Arrays.fill()` - 填充数组
* `Arrays.equals()` - 比较数组
* `Arrays.deepToString()` - 多维数组转字符串
* `Arrays.deepEquals()` - 比较多维数组

### 3. 数组复制
```java
// 方式1：System.arraycopy()
System.arraycopy(src, srcPos, dest, destPos, length);

// 方式2：Arrays.copyOf()
int[] newArray = Arrays.copyOf(oldArray, newLength);

// 方式3：clone()方法
int[] newArray = oldArray.clone();
```

## 四、常见操作示例

### 1. 数组排序
```java
// 升序排序
Arrays.sort(arr);

// 降序排序（对象数组）
Arrays.sort(arr, Collections.reverseOrder());

// 部分排序
Arrays.sort(arr, fromIndex, toIndex);
```

### 2. 数组查找
```java
// 二分查找（要求数组已排序）
int index = Arrays.binarySearch(arr, key);

// 顺序查找
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) return i;
}
```

### 3. 数组填充
```java
// 全部填充
Arrays.fill(arr, value);

// 部分填充
Arrays.fill(arr, fromIndex, toIndex, value);
```

## 五、注意事项

1. 数组越界
* 访问数组时索引不能超出范围
* ArrayIndexOutOfBoundsException异常

2. 空指针
* 使用数组前要确保已经分配空间
* NullPointerException异常

3. 性能考虑
* 数组长度固定，不能动态调整
* 插入和删除操作需要移动元素
* 建议预估大小，避免频繁复制

## 六、最佳实践

1. 初始化
* 明确知道元素时使用{}初始化
* 不确定元素时使用new分配空间

2. 遍历
* 简单遍历用foreach
* 需要索引时用普通for循环
* 多维数组建议使用嵌套for循环

3. 工具类使用
* 优先使用Arrays工具类提供的方法
* 注意Arrays.sort()的排序规则
* 大数组排序考虑并行排序Arrays.parallelSort()

4. 边界检查
* 访问数组前检查索引范围
* 使用数组前判断是否为null 