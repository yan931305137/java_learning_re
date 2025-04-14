## 5. HTTP客户端（Java 11+）

### 5.1 HttpClient
- **创建和配置**: 使用`HttpClient.newBuilder()`创建客户端实例，支持配置代理、认证、版本等。
  ```java
  HttpClient client = HttpClient.newBuilder()
      .version(HttpClient.Version.HTTP_2)
      .followRedirects(HttpClient.Redirect.NORMAL)
      .build();
  ```

- **请求构建**: 使用`HttpRequest.newBuilder()`构建请求，支持GET、POST等多种方法。
  ```java
  HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create("https://example.com"))
      .GET()
      .build();
  ```

- **响应处理**: 使用`client.send()`同步发送请求，或`client.sendAsync()`异步发送请求。
  ```java
  HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
  System.out.println(response.body());
  ```

- **异步操作**: 使用`CompletableFuture`处理异步请求。
  ```java
  client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
      .thenApply(HttpResponse::body)
      .thenAccept(System.out::println);
  ```

### 5.2 高级特性
- **WebSocket支持**: 使用`WebSocket.Builder`创建WebSocket连接，支持消息发送和接收。
  ```java
  WebSocket webSocket = client.newWebSocketBuilder()
      .buildAsync(URI.create("wss://example.com/socket"), new WebSocket.Listener() {
          @Override
          public void onOpen(WebSocket webSocket) {
              System.out.println("WebSocket opened");
              webSocket.sendText("Hello", true);
          }
          // 其他回调方法
      }).join();
  ```

- **HTTP/2支持**: 默认支持HTTP/2协议，提升性能和并发能力。

- **请求过滤**: 使用`HttpRequest.Builder`添加请求过滤器，支持请求拦截和修改。

- **认证处理**: 支持基本认证和自定义认证机制。
  ```java
  HttpClient client = HttpClient.newBuilder()
      .authenticator(Authenticator.getDefault())
      .build();
  ```

### 5.3 性能优化
- **连接池管理**: 自动管理连接池，减少连接建立的开销。

- **超时设置**: 设置连接超时和请求超时，避免长时间阻塞。
  ```java
  HttpClient client = HttpClient.newBuilder()
      .connectTimeout(Duration.ofSeconds(10))
      .build();
  ```

- **并发请求**: 使用异步请求和`CompletableFuture`实现高并发请求处理。

- **资源释放**: 确保在请求完成后释放资源，避免内存泄漏。

