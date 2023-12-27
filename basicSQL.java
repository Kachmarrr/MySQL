package org.example;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection;

        final String URL = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false";
        final String USERNAME = "root";
        final String PASSWORD = "kachmarsql.ann170936";

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()){
                System.out.printf("connection is good!");
            }

            connection.close();

            if (connection.isClosed()){
                System.out.printf("connection is closed!");
            }
        } catch (SQLException e) {
            System.out.printf("не вдалось загрузити драйвер");
        }
    }
}
