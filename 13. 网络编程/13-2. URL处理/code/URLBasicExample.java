package code;

import java.net.URL;
import java.net.MalformedURLException;

/**
 * URL基本操作示例
 */
public class URLBasicExample {
    public static void main(String[] args) {
        try {
            // 创建URL对象
            URL url = new URL("https://api.example.com:8080/path/data?id=123#section");
            
            // 获取URL的各个部分
            System.out.println("协议: " + url.getProtocol());
            System.out.println("主机名: " + url.getHost());
            System.out.println("端口号: " + url.getPort());
            System.out.println("路径: " + url.getPath());
            System.out.println("查询参数: " + url.getQuery());
            System.out.println("片段标识符: " + url.getRef());
            
            // 相对URL
            URL baseUrl = new URL("http://example.com/base/");
            URL relativeUrl = new URL(baseUrl, "relative/path");
            System.out.println("完整URL: " + relativeUrl.toString());
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
} 