# Java数据库编程

## 1. JDBC基础
### 1.1 JDBC架构
- **JDBC API组成**
  - java.sql包
  - javax.sql包
  - JDBC驱动管理器
  - JDBC驱动程序接口

- **核心接口**
  ```java
  // 驱动管理
  DriverManager.getConnection(url, username, password);
  
  // 连接接口
  Connection conn = DriverManager.getConnection(url, props);
  
  // 语句接口
  Statement stmt = conn.createStatement();
  PreparedStatement pstmt = conn.prepareStatement(sql);
  ```

### 1.2 驱动程序类型
1. **Type-1：JDBC-ODBC桥接驱动**
   - 依赖本地ODBC驱动
   - 性能较低
   - 不推荐使用

2. **Type-2：本地API驱动**
   - 部分Java实现
   - 依赖本地库
   - 性能较好

3. **Type-3：网络协议驱动**
   - 纯Java实现
   - 通过中间件
   - 支持跨平台

4. **Type-4：纯Java驱动**
   - 完全Java实现
   - 直接与数据库通信
   - 最常用类型

### 1.3 连接管理
- **建立连接**
  ```java
  String url = "jdbc:mysql://localhost:3306/dbname";
  String username = "root";
  String password = "password";
  
  try (Connection conn = DriverManager.getConnection(url, username, password)) {
      // 使用连接
  }
  ```

- **连接属性设置**
  ```java
  Properties props = new Properties();
  props.setProperty("user", username);
  props.setProperty("password", password);
  props.setProperty("useSSL", "true");
  Connection conn = DriverManager.getConnection(url, props);
  ```

### 1.4 事务处理
- **事务控制**
  ```java
  conn.setAutoCommit(false);
  try {
      // 执行SQL操作
      conn.commit();
  } catch (SQLException e) {
      conn.rollback();
  }
  ```

- **事务隔离级别**
  ```java
  conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
  ```

## 2. 连接池
### 2.1 连接池原理
- **核心概念**
  - 连接复用
  - 连接管理
  - 性能优化
  - 资源控制

- **工作流程**
  1. 初始化连接池
  2. 获取连接
  3. 使用连接
  4. 归还连接

### 2.2 常用连接池
1. **HikariCP**
   ```java
   HikariConfig config = new HikariConfig();
   config.setJdbcUrl(url);
   config.setUsername(username);
   config.setPassword(password);
   
   HikariDataSource ds = new HikariDataSource(config);
   ```

2. **Druid**
   ```java
   DruidDataSource ds = new DruidDataSource();
   ds.setUrl(url);
   ds.setUsername(username);
   ds.setPassword(password);
   ds.setInitialSize(5);
   ds.setMaxActive(20);
   ```

3. **C3P0**
   ```java
   ComboPooledDataSource ds = new ComboPooledDataSource();
   ds.setJdbcUrl(url);
   ds.setUser(username);
   ds.setPassword(password);
   ds.setMaxPoolSize(20);
   ```

### 2.3 连接池配置
- **基本配置**
  ```properties
  # 基本连接信息
  jdbc.url=jdbc:mysql://localhost:3306/dbname
  jdbc.username=root
  jdbc.password=password
  
  # 连接池配置
  pool.initialSize=5
  pool.maxActive=20
  pool.minIdle=5
  pool.maxWait=60000
  ```

- **高级配置**
  ```properties
  # 性能配置
  pool.testOnBorrow=true
  pool.testOnReturn=false
  pool.testWhileIdle=true
  
  # 监控配置
  pool.timeBetweenEvictionRunsMillis=60000
  pool.minEvictableIdleTimeMillis=300000
  ```

## 3. 数据库操作
### 3.1 预处理语句
- **基本使用**
  ```java
  String sql = "INSERT INTO users (name, age) VALUES (?, ?)";
  try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, "张三");
      pstmt.setInt(2, 25);
      pstmt.executeUpdate();
  }
  ```

- **批量操作**
  ```java
  pstmt.addBatch();
  pstmt.executeBatch();
  ```

### 3.2 结果集处理
- **遍历结果集**
  ```java
  String sql = "SELECT * FROM users";
  try (Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
          String name = rs.getString("name");
          int age = rs.getInt("age");
      }
  }
  ```

- **结果集元数据**
  ```java
  ResultSetMetaData metaData = rs.getMetaData();
  int columnCount = metaData.getColumnCount();
  String columnName = metaData.getColumnName(1);
  ```

### 3.3 元数据获取
- **数据库元数据**
  ```java
  DatabaseMetaData dbMetaData = conn.getMetaData();
  
  // 获取表信息
  ResultSet tables = dbMetaData.getTables(null, null, "%", null);
  
  // 获取列信息
  ResultSet columns = dbMetaData.getColumns(null, null, "tableName", "%");
  ```

## 4. 最佳实践
### 4.1 异常处理
```java
try (Connection conn = dataSource.getConnection()) {
    // 数据库操作
} catch (SQLException e) {
    logger.error("数据库操作失败", e);
    throw new DatabaseException("数据库操作失败", e);
}
```

### 4.2 性能优化
1. 使用连接池
2. 批量操作
3. 预编译语句
4. 合理的事务范围

### 4.3 安全考虑
1. 参数化查询防SQL注入
2. 最小权限原则
3. 敏感数据加密
4. 连接信息安全

## 5. 常见问题
1. 连接泄漏
2. 连接超时
3. 并发访问
4. 性能瓶颈

## 6. 调试技巧
1. SQL日志记录
2. 连接池监控
3. 性能分析
4. 事务追踪