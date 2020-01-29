package com.sqlsamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class App {

    public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=shootra;user=sa;password=Goru@1996";

        try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                System.out.println("Done.");
                
                String sql = new StringBuilder().append("INSERT INTO student(ID,FirstName,LastName,Age)").append("VALUES(?,?,?,?)").toString();
                try(PreparedStatement statement =connection.prepareStatement(sql))
                {
                	statement.setInt(1, 106);
                	statement.setString(2, "Ravindra");
                	statement.setString(3, "Nath Tagor");
                	statement.setInt(4, 56);
                	int rowsAffected = statement.executeUpdate();
                	System.out.println(rowsAffected + " row(s) inserted");
                }    
            }
        } catch (Exception e) {
            System.out.println("########################### : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
