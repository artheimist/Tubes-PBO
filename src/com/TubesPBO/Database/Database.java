package com.TubesPBO.Database;


import java.sql.*;
import java.util.UUID;

public class Database {

    public static Connection CONN = connect();

    private static Connection connect() {
        Connection conn=null;
        String myUrl = "jdbc:sqlite:res/Database/Winner.db";
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(myUrl);
            System.out.println("connected");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return conn;
    }
    public static void saveWinner(String name){

        try {
            String id=UUID.randomUUID().toString();
            Statement st = CONN.createStatement();

            st.executeUpdate("INSERT INTO winner (id,nama) VALUES ('"  + id+"', '" + name + "');");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

}
