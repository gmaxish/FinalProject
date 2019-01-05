package com.MGrigorovich;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDB {
    private final static String URL = "jdbc:mysql://localhost:3306/NailsClients?autoReconnect=true&useSSL=false";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "1Nkvizitor&";
    private Connection con;

    public static void main(String[] args)  throws SQLException {

        //   public void connect () {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            {
                // statement.executeUpdate("DROP TABLE clients");

                // statement.executeUpdate("create table ");
              //  statement.executeUpdate("INSERT INTO clients(TELEGRAM_NICKNAME) VALUE ('message.setText(update.getMessage().getFrom().getLastName()))'");
            }
             System.out.println("Есть коннект");
        }
    }

    }


