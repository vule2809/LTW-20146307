package DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection_20146307 {
    private static String DB_URL = "jdbc:mysql://localhost:3306/bookstore";
    private static String USER_NAME = "root";
    private static String PASSWORD = "28092002";
    private static Connection conn;
    
    public static void main(String args[]) {
    	try {
			getConnection();
		} 
    	catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static Connection getConnection() throws IOException{
        conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = (Connection) DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connect successfully");
        } catch (Exception ex){
            System.out.println("Connect falure");
            Logger.getLogger(DBConnection_20146307.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return conn;
    }
    public static void freeConnection(){
        try{
            conn.close();
        } catch (SQLException ex){
            Logger.getLogger(DBConnection_20146307.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}