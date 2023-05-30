package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public  Connection conn() {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/stock_management_db";
        try {
            Class.forName("org.postgresql.Driver");
            String username = "postgres";
            String password = "123";
            connection = DriverManager.getConnection(url, username, password);
           // System.out.println("Connection success");
            return connection;
        } catch (Throwable e) {
            System.out.println("Connection error!"+e.getMessage());
        }
        return null;
    }

}
