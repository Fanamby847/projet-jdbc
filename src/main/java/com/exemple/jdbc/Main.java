package com.exemple.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class Main {
    public void main(String[] args) {
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("database.properties")) {

            Properties prop = new Properties();
            prop.load(input);

            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String pass = prop.getProperty("db.password");

            System.out.println("Connexion à MySQL...");
            Connection con =0 DriverManager.getConnection(url, user, pass);

            System.out.println("✔ Connexion réussie !");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
