package code;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsyncFileReadWriteExample {
    public static void main(String[] args) {
        Path path = Path.of("async.txt");

        try (AsynchronousFileChannel asyncChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            Future<Integer> result = asyncChannel.read(buffer, 0);

            while (!result.isDone()) {
                System.out.println("异步读取中...");
            }

            buffer.flip();
            System.out.println("读取内容: " + new String(buffer.array(), 0, buffer.limit()));

            buffer.clear();
            buffer.put("异步写入内容".getBytes());
            buffer.flip();
            asyncChannel.write(buffer, 0);

            System.out.println("异步写入完成");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 