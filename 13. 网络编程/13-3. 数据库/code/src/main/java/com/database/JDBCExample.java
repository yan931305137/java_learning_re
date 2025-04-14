package com.database;

import java.sql.*;

public class JDBCExample {
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("数据库连接成功");

            // 创建表
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(50), "
                    + "age INT)";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
            }

            // 插入数据
            String insertSQL = "INSERT INTO users (name, age) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setString(1, "张三");
                pstmt.setInt(2, 25);
                pstmt.executeUpdate();
            }

            // 查询数据
            String selectSQL = "SELECT * FROM users";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSQL)) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") +
                            ", Name: " + rs.getString("name") +
                            ", Age: " + rs.getInt("age"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
} 