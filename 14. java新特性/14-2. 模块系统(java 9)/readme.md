# 2. 模块系统（Java 9+）

## 核心功能
Java 模块系统为大型应用提供了模块化支持，增强了代码的可维护性和可扩展性。

## 2.1 模块的基本概念
- **模块**: 是一组相关包和资源的集合，具有明确的接口和依赖关系。
- **模块描述符**: 使用`module-info.java`文件定义模块的名称、依赖和导出包。
  ```java
  module com.example.module {
      requires java.base;
      exports com.example.package;
  }
  ```

## 2.2 模块的优点
- **封装性**: 模块化系统允许开发者隐藏实现细节，只导出需要公开的API。
- **强制性依赖**: 明确声明模块依赖，避免类路径冲突。
- **性能优化**: 通过减少类加载和内存占用提高性能。

## 2.3 创建模块
- **定义模块描述符**: 在模块的根目录下创建`module-info.java`文件。
- **编译模块**: 使用`javac`编译模块，指定模块路径。
  ```bash
  javac -d out --module-source-path src $(find src -name "*.java")
  ```

## 2.4 运行模块
- **运行模块化应用**: 使用`java`命令运行模块，指定模块路径。
  ```bash
  java --module-path out -m com.example.module/com.example.package.code.Main
  ```

## 2.5 模块化应用的最佳实践
- **合理划分模块**: 根据功能和依赖关系划分模块，避免模块间的循环依赖。
- **使用服务加载器**: 利用服务加载器机制实现模块间的松耦合。
- **测试模块**: 使用模块化测试框架，确保模块的功能和接口正确。

