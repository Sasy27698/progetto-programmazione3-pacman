package com.project;

import java.sql.*;

public class DB {
    private Connection connection;
    private static DB istance;
    public static final String JDBC_DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL ="jdbc:sqlite:C:\\Users\\mario\\Desktop\\Game\\MyDB.sqlite";
    private DB(){
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL);
        }catch (SQLException e)
        {
            System.out.println("CONNECTION ERROR!");
        }catch (ClassNotFoundException c)
        {
            System.out.println("DB ERROR!");
        }
    }
    public static DB getIstances()
    {
        if(istance == null)
            istance = new DB();
        return istance;
    }
    public Connection getConnection() {
        try {
            if (connection.isClosed()) {
                this.connection = DriverManager.getConnection(DB_URL);
                return connection;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
