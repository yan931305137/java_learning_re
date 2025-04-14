package com.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionPoolExample {
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(10);

        try (HikariDataSource dataSource = new HikariDataSource(config);
             Connection conn = dataSource.getConnection()) {
            System.out.println("使用连接池连接数据库");

            // 查询数据
            String selectSQL = "SELECT * FROM users";
            try (PreparedStatement pstmt = conn.prepareStatement(selectSQL);
                 ResultSet rs = pstmt.executeQuery()) {
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