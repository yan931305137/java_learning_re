## Java Socket 编程

## 2. URL 处理

Java 提供了 `java.net.URL` 类用于处理统一资源定位符，支持从远程服务器读取内容、发送请求等功能。

### 2.1 URL 类

- **URL 的组成部分**：包括协议（protocol）、主机（host）、端口（port）、路径（file）、查询参数（query）等。

```java
URL url = new URL("https://www.example.com:443/path/resource?query=value");
System.out.println(url.getProtocol()); // https
System.out.println(url.getHost());     // www.example.com
System.out.println(url.getPort());     // 443
System.out.println(url.getPath());     // /path/resource
System.out.println(url.getQuery());    // query=value
```

- **URL 的创建和解析**：通过构造方法和 getter 方法进行创建与解析。

- **URLConnection 类**：用于读取或写入 URL 对应的资源流。

```java
URLConnection conn = url.openConnection();
InputStream in = conn.getInputStream();
```

---

### 2.2 HTTP 请求

- **GET 请求**：直接使用 URL 打开连接并读取数据。

```java
URL url = new URL("https://api.example.com/data");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("GET");
InputStream in = conn.getInputStream();
```

- **POST 请求**：需要设置 `doOutput(true)` 并通过输出流发送数据。

```java
URL url = new URL("https://api.example.com/post");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("POST");
conn.setDoOutput(true);
OutputStream out = conn.getOutputStream();
out.write("name=value".getBytes());
out.flush();
out.close();
```

- **请求头设置**：使用 `setRequestProperty` 设置。

```java
conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
```

- **响应处理**：读取响应码与内容。

```java
int responseCode = conn.getResponseCode();
InputStream response = conn.getInputStream();
```

---

### 2.3 数据处理

- **字符编码**：通过 `InputStreamReader` 指定编码格式。

```java
BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
```

- **内容类型**：通过 `getContentType()` 获取 MIME 类型。

```java
String type = conn.getContentType();
```

- **数据流处理**：通过缓冲流读取响应内容。

```java
String line;
while ((line = reader.readLine()) != null) {
    System.out.println(line);
}
```

- **文件下载**：将输入流写入文件。

```java
FileOutputStream fos = new FileOutputStream("file.txt");
byte[] buffer = new byte[1024];
int len;
while ((len = in.read(buffer)) != -1) {
    fos.write(buffer, 0, len);
}
fos.close();
in.close();
```

---

