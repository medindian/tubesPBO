package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {
    
    public static Connection connection = null;

    public databaseConnection() {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "kel5";
        String pass = "kel5";
        
        try{
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("connection success!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }   
    
}
