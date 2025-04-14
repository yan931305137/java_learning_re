## 6. WebSocket

### 6.1 基础概念
- **WebSocket协议**: WebSocket是一种全双工通信协议，允许客户端和服务器之间进行实时数据交换。
- **握手过程**: WebSocket连接通过HTTP协议进行初始握手，然后升级为WebSocket协议。
- **消息格式**: WebSocket消息可以是文本或二进制格式，支持分片传输。
- **连接状态**: WebSocket连接有多种状态，包括连接中、已连接、关闭中和已关闭。

### 6.2 服务端开发
- **创建WebSocket服务器**: 使用Java EE的`@ServerEndpoint`注解或Spring WebSocket支持创建WebSocket服务器。
- **会话管理**: 管理客户端会话，跟踪连接的客户端。
- **消息处理**: 处理来自客户端的消息，并发送响应。
- **错误处理**: 处理连接错误和消息传输错误。

### 6.3 客户端开发
- **建立连接**: 使用Java 11+的`HttpClient`或第三方库（如Tyrus）建立WebSocket连接。
- **发送消息**: 使用`WebSocket.sendText()`或`WebSocket.sendBinary()`发送消息。
- **接收消息**: 实现`WebSocket.Listener`接口的`onText()`或`onBinary()`方法接收消息。
- **心跳检测**: 定期发送心跳消息以保持连接活跃，检测连接状态。

### 6.4 示例代码
- **服务端示例**: 使用Java EE或Spring创建简单的WebSocket服务器。
- **客户端示例**: 使用Java 11+的`HttpClient`创建WebSocket客户端，发送和接收消息。

### 6.5 最佳实践
- **连接管理**: 监控和管理WebSocket连接，处理断开和重连。
- **安全性**: 使用WSS（WebSocket Secure）协议加密通信，防止中间人攻击。
- **性能优化**: 使用分片传输大消息，减少内存占用。
- **错误处理**: 实现全面的错误处理机制，确保连接的稳定性。
