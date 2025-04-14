package nio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

/**
 * NIO示例
 */
public class NIOExample {
    public static void main(String[] args) {
        try {
            // 1. Channel和Buffer示例
            System.out.println("=== Channel和Buffer示例 ===");
            Path path = Paths.get("nio_test.txt");
            
            // 写入数据
            String data = "Hello, NIO!";
            ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());
            
            try (FileChannel channel = FileChannel.open(path, 
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
                channel.write(buffer);
                System.out.println("数据已写入");
            }
            
            // 读取数据
            buffer.clear();
            try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {
                channel.read(buffer);
                buffer.flip();
                byte[] bytes = new byte[buffer.remaining()];
                buffer.get(bytes);
                System.out.println("读取的数据：" + new String(bytes));
            }

            // 2. 文件监控示例
            System.out.println("\n=== 文件监控示例 ===");
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path dir = Paths.get(".");
            dir.register(watchService, 
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);
            
            System.out.println("开始监控当前目录（按Ctrl+C退出）...");
            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.printf("事件类型：%s，文件：%s%n",
                        event.kind(), event.context());
                }
                key.reset();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 