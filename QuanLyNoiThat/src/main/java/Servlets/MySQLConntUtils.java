package Servlets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQLConntUtils {
 
 public static Connection getMySQLConnection() throws ClassNotFoundException, 
SQLException{
 String hostname="localhost";
 String dbName="qlnt";
 String username="root";
 String password="";
 return getMySQLConnection(hostname,dbName,username, password);
 }
 private static Connection getMySQLConnection(String hostname, String dbName, String 
username, String password) 
 throws ClassNotFoundException, SQLException {
System.out.println('3');
 Class.forName("com.mysql.jdbc.Driver");
 String connectionURL="jdbc:mysql://"+hostname+":3306/"+dbName;
 System.out.println(connectionURL);
 Connection conn=DriverManager.getConnection(connectionURL, username, password);
 System.out.println(conn);
 return conn;
 }
 
}