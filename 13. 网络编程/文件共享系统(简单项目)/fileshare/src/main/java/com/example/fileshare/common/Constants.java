package com.example.fileshare.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constants {
    private static final Properties properties = new Properties();
    
    static {
        try (InputStream input = Constants.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("无法加载配置文件", e);
        }
    }
    
    // 服务器配置
    public static final int HTTP_PORT = Integer.parseInt(
        properties.getProperty("server.http.port", "8080"));
    public static final int WEBSOCKET_PORT = Integer.parseInt(
        properties.getProperty("server.websocket.port", "8081"));
    public static final String UPLOAD_DIR = 
        properties.getProperty("server.upload.dir", "uploads/");
    
    // 数据库配置
    public static final String DB_URL = properties.getProperty("db.url");
    public static final String DB_USERNAME = properties.getProperty("db.username");
    public static final String DB_PASSWORD = properties.getProperty("db.password");
    public static final String DB_DRIVER = properties.getProperty("db.driver");
    
    // 文件配置
    public static final long MAX_FILE_SIZE = Long.parseLong(
        properties.getProperty("file.max.size", "10485760"));
    public static final String[] ALLOWED_FILE_TYPES = 
        properties.getProperty("file.allowed.types", "").split(",");
} 