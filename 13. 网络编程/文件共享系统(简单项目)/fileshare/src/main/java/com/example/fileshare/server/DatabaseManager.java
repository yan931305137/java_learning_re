package com.example.fileshare.server;

import com.example.fileshare.common.FileInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/fileshare";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // 初始化数据库
    public void initDatabase() {
        try (Connection conn = getConnection()) {
            // 创建文件信息表
            String createTableSQL = """
                CREATE TABLE IF NOT EXISTS files (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    filename VARCHAR(255) NOT NULL,
                    file_path VARCHAR(500) NOT NULL,
                    upload_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    download_count INT DEFAULT 0
                )
            """;
            
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // 添加文件记录
    public void addFile(String filename, String filePath) {
        String sql = "INSERT INTO files (filename, file_path) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, filename);
            pstmt.setString(2, filePath);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // 更新下载次数
    public void incrementDownloadCount(int fileId) {
        String sql = "UPDATE files SET download_count = download_count + 1 WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, fileId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // 获取所有文件信息
    public List<FileInfo> getAllFiles() {
        List<FileInfo> files = new ArrayList<>();
        String sql = "SELECT * FROM files ORDER BY upload_time DESC";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                FileInfo file = new FileInfo(
                    rs.getInt("id"),
                    rs.getString("filename"),
                    rs.getString("file_path"),
                    rs.getTimestamp("upload_time"),
                    rs.getInt("download_count")
                );
                files.add(file);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return files;
    }
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
} 