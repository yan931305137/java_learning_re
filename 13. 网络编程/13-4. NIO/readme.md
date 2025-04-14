## 4. NIO网络编程

### 4.1 NIO基础
- **Channel（通道）**: 用于数据的读写操作，类似于流，但可以进行非阻塞操作。
  - 常用的通道有`FileChannel`、`SocketChannel`、`ServerSocketChannel`等。
  
- **Buffer（缓冲区）**: 用于存储数据，NIO中的所有数据都是用缓冲区处理的。
  - 常用的缓冲区有`ByteBuffer`、`CharBuffer`、`IntBuffer`等。
  
- **Selector（选择器）**: 用于监听多个通道的事件（如连接请求、数据到达等），实现多路复用。
  - 通过`Selector`可以实现单线程管理多个通道，提高系统的伸缩性。
  
- **非阻塞IO**: 允许线程在等待通道准备好时执行其他操作，避免线程阻塞。

### 4.2 文件操作
- **FileChannel**: 用于文件的读写操作，支持随机访问文件。
  - 可以通过`FileChannel`实现文件的复制、截取、强制写入等操作。
  
- **内存映射文件**: 通过`MappedByteBuffer`将文件映射到内存中，支持大文件的高效读写。
  - 适用于需要频繁读写的场景。
  
- **文件锁定**: 通过`FileLock`实现对文件的部分或全部加锁，防止其他进程修改。
  - 支持共享锁和排他锁。
  
- **异步IO**: 使用`AsynchronousFileChannel`实现异步文件操作，提高IO操作的效率。

### 4.3 网络编程
- **ServerSocketChannel**: 用于监听TCP连接的通道，支持非阻塞模式。
  - 可以通过`ServerSocketChannel`创建非阻塞的服务器。
  
- **SocketChannel**: 用于TCP数据传输的通道，支持非阻塞模式。
  - 可以通过`SocketChannel`实现客户端与服务器之间的数据传输。
  
- **非阻塞模式**: 通过设置通道为非阻塞模式，允许线程在等待IO操作时执行其他任务。
  - 提高了系统的并发处理能力。
  
- **多路复用**: 通过`Selector`实现对多个通道的事件监听，减少线程的使用。
  - 适用于高并发的网络应用程序。

### 4.4 示例代码
- **文件复制示例**: 使用`FileChannel`实现文件的复制。
- **非阻塞服务器示例**: 使用`ServerSocketChannel`和`Selector`实现非阻塞服务器。
- **异步文件读写示例**: 使用`AsynchronousFileChannel`实现异步文件读写。

### 4.5 最佳实践
- 使用`Selector`实现多路复用，减少线程开销。
- 使用`ByteBuffer`进行数据的批量读写，提高效率。
- 在高并发场景下，优先考虑使用NIO的非阻塞模式。
- 合理使用内存映射文件，避免内存溢出。
