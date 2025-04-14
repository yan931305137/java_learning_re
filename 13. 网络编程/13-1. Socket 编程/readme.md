## Java Socket 编程

---

## 1. Socket 编程

Socket（套接字）是网络通信中用于实现通信连接的基本工具，Java 提供了丰富的类来支持基于 TCP 和 UDP 的网络编程。

---

### 1.1 基础概念

- **Socket（套接字）的概念**：
  Socket 是应用程序用于网络通信的端点，是网络编程的核心。它封装了 TCP/IP 协议，使得我们可以像操作文件一样读写网络数据。

- **TCP/IP 协议基础**：
  TCP/IP 是一种通信协议集，包括传输控制协议（TCP）和网际协议（IP）。TCP 是面向连接的协议，提供可靠数据传输；UDP 是无连接的协议，适用于快速传输但不保证可靠性的场景。

- **网络通信模型**：
  网络通信模型常见的是客户端-服务器（C/S）模型。客户端发起连接请求，服务器监听特定端口并接受连接，之后进行数据交换。

---

### 1.2 TCP 编程

Java 提供了 `ServerSocket` 和 `Socket` 类来进行 TCP 通信。

- **ServerSocket 类**：用于服务器端监听客户端连接请求。

```java
ServerSocket serverSocket = new ServerSocket(8888);
Socket socket = serverSocket.accept();  // 接受客户端连接
```

- **Socket 类**：用于客户端连接服务器，或在服务器端与客户端通信。

```java
Socket socket = new Socket("localhost", 8888);  // 连接服务器
```

- **建立连接流程**：
  1. 服务端创建 `ServerSocket` 并调用 `accept()` 监听端口；
  2. 客户端创建 `Socket` 连接指定 IP 和端口；
  3. 建立连接后双方通过输入输出流进行通信。

- **数据传输**：

```java
// 客户端发送数据
OutputStream out = socket.getOutputStream();
out.write("Hello Server".getBytes());

// 服务端接收数据
InputStream in = socket.getInputStream();
byte[] buffer = new byte[1024];
int len = in.read(buffer);
System.out.println(new String(buffer, 0, len));
```

- **连接关闭**：

```java
in.close();
out.close();
socket.close();
serverSocket.close();
```

---

### 1.3 UDP 编程

UDP 是无连接协议，使用 `DatagramSocket` 和 `DatagramPacket` 类进行通信。

- **DatagramSocket 类**：用于发送和接收数据报。

- **DatagramPacket 类**：表示要发送或接收的数据包。

- **发送端示例**：

```java
DatagramSocket socket = new DatagramSocket();
String msg = "Hello UDP";
byte[] data = msg.getBytes();
InetAddress address = InetAddress.getByName("localhost");
DatagramPacket packet = new DatagramPacket(data, data.length, address, 9999);
socket.send(packet);
socket.close();
```

- **接收端示例**：

```java
DatagramSocket socket = new DatagramSocket(9999);
byte[] buffer = new byte[1024];
DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
socket.receive(packet);
String msg = new String(packet.getData(), 0, packet.getLength());
System.out.println("接收到: " + msg);
socket.close();
```

- **广播和多播**：
  - 广播：使用 `255.255.255.255` 发送到所有主机。
  - 多播：使用 `MulticastSocket` 加入多播组（组地址通常在 224.0.0.0~239.255.255.255）。

```java
MulticastSocket socket = new MulticastSocket(8888);
InetAddress group = InetAddress.getByName("224.0.0.1");
socket.joinGroup(group);
```

---
