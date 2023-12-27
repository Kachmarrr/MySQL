package org.example;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false";
    private static final String USERNAME = "USER";
    private static final String PASSWORD = "PASSWORD";

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery("SELECT  * FROM users ");

        while (results.next()) {
            Integer id = results.getInt(1);
            String name = results.getString(2);
            Integer age = results.getInt(3);
            String email = results.getString(4);

            System.out.println(results.getRow() + id + "\t"+ name + "\t" + age +"\t" + email);
        }
    }
}
