package main;

import util.DBConnection;
import java.sql.Connection;

public class DBConnectionTest {

    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Database connection successful!");
            }
        } catch (Exception e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }
}
