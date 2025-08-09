/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseConnection;

import java.sql.*;
/**
 *
 * @author iesha
 */
public class Database {
    Connection conn;
    public Connection getConnection()
    {
        try {
             String url = "jdbc:mysql://localhost:3306/billing_software";
        String userName = "root";
        String password = "sandy2244";
        conn = DriverManager.getConnection(url,userName,password);
        System.out.println("Connection successful to database");
            
        } catch (Exception e) {
            System.out.println(e);
        }
     return conn;
    }
}
