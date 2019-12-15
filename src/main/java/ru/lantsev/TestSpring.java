package ru.lantsev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestSpring {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/springtest?serverTimezone=Europe/Minsk&useSSL=false";
        String username = "root";
        String password = "root";
        System.out.println("Connecting...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
