package file;

import java.io.File;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

/**
 * 文件操作示例
 */
public class FileOperationExample {
    public static void main(String[] args) {
        try {
            // 1. File类操作
            System.out.println("=== File类操作 ===");
            File file = new File("test.txt");
            
            // 创建文件
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("文件已创建");
            }
            
            // 文件信息
            System.out.println("文件名：" + file.getName());
            System.out.println("绝对路径：" + file.getAbsolutePath());
            System.out.println("文件大小：" + file.length());

            // 2. Files类操作（Java 7+）
            System.out.println("\n=== Files类操作 ===");
            Path path = Paths.get("test2.txt");
            
            // 写入文件
            List<String> lines = Arrays.asList("第一行", "第二行", "第三行");
            Files.write(path, lines);
            System.out.println("文件已写入");
            
            // 读取文件
            List<String> readLines = Files.readAllLines(path);
            System.out.println("文件内容：");
            readLines.forEach(System.out::println);
            
            // 复制文件
            Path copyPath = Paths.get("test2_copy.txt");
            Files.copy(path, copyPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("文件已复制");
            
            // 移动文件
            Path movePath = Paths.get("moved_test2.txt");
            Files.move(copyPath, movePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("文件已移动");
            
            // 删除文件
            Files.delete(path);
            Files.delete(movePath);
            System.out.println("文件已删除");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 