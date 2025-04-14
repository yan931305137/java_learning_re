package code;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * 文件下载示例
 */
public class FileDownloadExample {
    
    public static void main(String[] args) {
        String fileUrl = "https://example.com/files/sample.pdf";
        String saveDir = "downloads/";
        
        downloadFile(fileUrl, saveDir);
    }
    
    public static void downloadFile(String fileUrl, String saveDir) {
        try {
            URL url = new URL(fileUrl);
            URLConnection conn = url.openConnection();
            
            // 获取文件名
            String fileName = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
            
            // 创建保存目录
            File directory = new File(saveDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            
            // 获取文件大小
            int fileSize = conn.getContentLength();
            
            // 创建输入流
            try (InputStream in = new BufferedInputStream(conn.getInputStream());
                 FileOutputStream fos = new FileOutputStream(saveDir + fileName)) {
                
                byte[] buffer = new byte[1024];
                int bytesRead;
                int totalRead = 0;
                
                System.out.println("开始下载文件: " + fileName);
                System.out.println("文件大小: " + fileSize + " bytes");
                
                while ((bytesRead = in.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                    totalRead += bytesRead;
                    
                    // 显示下载进度
                    if (fileSize > 0) {
                        int percent = (int) ((totalRead * 100) / fileSize);
                        System.out.print("\r下载进度: " + percent + "%");
                    }
                }
                
                System.out.println("\n文件下载完成！");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 