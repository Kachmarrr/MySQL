package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main{

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "kachmarsql.ann170936";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть ім'я:");
        String name1 = scanner.nextLine();

        System.out.println("Введіть вік:");
        Integer age1 = scanner.nextInt();

        scanner.nextLine(); // Очищення буфера введення перед читанням email

        System.out.println("Введіть email:");
        String email1 = scanner.nextLine();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO users (name, age, email) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name1);
            preparedStatement.setInt(2, age1);
            preparedStatement.setString(3, email1);

            int rows = preparedStatement.executeUpdate();
            System.out.printf("Додано %d рядків%n", rows);

            // Виведення всіх записів на екран
            displayData(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayData(Connection connection) {
        String sql = "SELECT * FROM users";

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            // Виведення всіх записів на екран
            while (results.next()) {
                Integer id = results.getInt("id");
                String name = results.getString("name");
                Integer age = results.getInt("age");
                String email = results.getString("email");

                System.out.printf("%d\t%s\t%d\t%s%n", id, name, age, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
