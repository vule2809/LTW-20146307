package hcmute.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBconnection {

	private static String DB_URL = "jdbc:mysql://localhost:3306/banxemay";
	private static String USER_NAME = "root";
	private static String PASSWORD = "28092002";
	private static Connection con;

	public static Connection getConnection() throws IOException {
		con = null;

		try {
			// driver register
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = (Connection) DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (SQLException ex) {
			Logger.getLogger(DBconnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		return (con);
	}

	public static void freeConnection() {

		try {
			con.close();
		} catch (SQLException ex) {
			Logger.getLogger(DBconnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	}

	public static void main(String[] args) {

		// try {
		// Connection c = getConnection();
		// if (c == null) {
		// System.out.println("something wrong");
		// } else {
		// System.out.println("ok");
		// }
		// } catch (Exception e) { e.printStackTrace();
		// }

		// truy vấn bảng
		try {
			Connection conn = getConnection();
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery("select * from product");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getInt(4) +" "+ rs.getString(5) +" "+ rs.getInt(6) +" "+ rs.getString(7));
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
