package code;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * HTTP请求示例
 */
public class HttpRequestExample {
    
    public static void main(String[] args) {
        // GET请求示例
        sendGetRequest();
        
        // POST请求示例
        sendPostRequest();
    }
    
    private static void sendGetRequest() {
        try {
            URL url = new URL("https://api.example.com/data");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            // 设置请求方法
            conn.setRequestMethod("GET");
            
            // 设置请求头
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept", "application/json");
            
            // 获取响应码
            int responseCode = conn.getResponseCode();
            System.out.println("GET Response Code: " + responseCode);
            
            // 读取响应
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    
                    while ((line = in.readLine()) != null) {
                        response.append(line);
                    }
                    
                    System.out.println("响应内容：" + response.toString());
                }
            }
            
            conn.disconnect();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void sendPostRequest() {
        try {
            URL url = new URL("https://api.example.com/create");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            // 设置请求方法和头信息
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            
            // 准备请求数据
            String jsonInputString = "{\"name\": \"test\", \"value\": 123}";
            
            // 发送请求数据
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
            
            // 获取响应
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                
                System.out.println("POST响应：" + response.toString());
            }
            
            conn.disconnect();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 