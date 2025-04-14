package url;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * URLConnection高级特性示例
 */
public class URLConnectionExample {
    
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.example.com/data");
            URLConnection conn = url.openConnection();
            
            // 设置连接参数
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            
            // 设置请求属性
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            
            // 建立连接
            conn.connect();
            
            // 获取响应头信息
            System.out.println("=== 响应头信息 ===");
            for (Map.Entry<String, java.util.List<String>> header : conn.getHeaderFields().entrySet()) {
                System.out.println(header.getKey() + ": " + header.getValue());
            }
            
            // 获取内容类型和编码
            String contentType = conn.getContentType();
            String contentEncoding = conn.getContentEncoding();
            int contentLength = conn.getContentLength();
            
            System.out.println("\n=== 响应信息 ===");
            System.out.println("Content-Type: " + contentType);
            System.out.println("Content-Encoding: " + contentEncoding);
            System.out.println("Content-Length: " + contentLength);
            
            // 读取响应内容
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                
                System.out.println("\n=== 响应内容 ===");
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 