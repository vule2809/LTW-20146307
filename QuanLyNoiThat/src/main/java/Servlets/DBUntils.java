package Servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUntils {
	public static void insertUserAccount(Connection conn, UserAccount user) throws SQLException {
		String sql = "Insert into USER_ACCOUNT(Username, Gender, Password) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, user.getUserName());
		pstm.setString(2, user.getGender());
		pstm.setString(3, user.getPassword());
		pstm.executeUpdate();
	}

	public static UserAccount findUser(Connection conn, //
			String userName, String password) throws SQLException {
		String sql = "Select a.Username, a.Password, a.Gender from USER_ACCOUNT a " //
				+ " where a.Username = ? and a.Password= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.ID, a.Name, a.Type , a.Price, a.Image from PRODUCT a "; //
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String id = rs.getString("ID");
			String name = rs.getString("Name");
			String type = rs.getString("Type");
			int price = rs.getInt("Price");
			String image = rs.getString("Image");			Product product = new Product();
			product.setId(id);
			product.setName(name);
			product.setType(type);
			product.setPrice(price);
			product.setImage(image);
			list.add(product);

		}
		return list;
	}

	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into Product(ID, Name, Type, Price, Image) values (?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, product.getId());
		pstm.setString(2, product.getName());
		pstm.setString(3, product.getType());
		pstm.setInt(4, product.getPrice());
		pstm.setString(5, product.getImage());

		pstm.executeUpdate();
	}

	public static void updateProduct(Connection conn, Product product) throws SQLException {
		String sql = "Update Product set Name =?, Price=?, Type=?, Image=? where id=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, product.getName());
		pstm.setInt(2, product.getPrice());
		pstm.setString(3, product.getType());
		pstm.setString(4, product.getImage());
		pstm.setString(5, product.getId());
		pstm.executeUpdate();
	}

	public static Product findProduct(Connection conn, String ID) throws SQLException {
		String sql = "Select a.Id, a.Name, a.Price, a.Type, a.Image from Product a where a.id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, ID);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String name = rs.getString("Name");
			int price = rs.getInt("Price");
			String image = rs.getString("Image");
			String type = rs.getString("Type");
			Product product = new Product(ID, name, type, price, image);
			return product;
		}
		return null;
	}

	public static void deleteProduct(Connection conn, String id) throws SQLException {
		String sql = "Delete From Product where id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		pstm.executeUpdate();
	}
	
	// NHANVIEN --------------------------------------------
	public static List<NhanVien> queryNhanVien(Connection conn) throws SQLException {
		String sql = "Select a.ID, a.Name, a.Age , a.Address, a.Experience from nhanvien a "; //
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<NhanVien> list = new ArrayList<NhanVien>();
		while (rs.next()) {
			String id = rs.getString("ID");
			String name = rs.getString("Name");
			String age = rs.getString("Age");
			String address = rs.getString("Address");
			String experience = rs.getString("Experience");
			
			NhanVien nhanvien = new NhanVien();
			nhanvien.setId(id);
			nhanvien.setName(name);
			nhanvien.setAge(age);
			nhanvien.setAddress(address);
			nhanvien.setExperience(experience);
			list.add(nhanvien);

		}
		return list;
	}
	public static void insertNhanVien(Connection conn, NhanVien nv) throws SQLException {
		String sql = "Insert into NhanVien(ID, Name, Age, Address, Experience) values (?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, nv.getId());
		pstm.setString(2, nv.getName());
		pstm.setString(3, nv.getAge());
		pstm.setString(4, nv.getAddress());
		pstm.setString(5, nv.getExperience());

		pstm.executeUpdate();
	}
	
	public static void updateNhanVien(Connection conn, NhanVien nv) throws SQLException {
		String sql = "Update NhanVien set Name =?, Age=?, Address=?, Experience=? where id=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, nv.getName());
		pstm.setString(2, nv.getAge());
		pstm.setString(3, nv.getAddress());
		pstm.setString(4, nv.getExperience());
		pstm.setString(5, nv.getId());
		pstm.executeUpdate();
	}
	public static NhanVien findNhanVien(Connection conn, String id) throws SQLException {
		String sql = "Select a.Id, a.Name, a.Age , a.Address, a.Experience from NhanVien  a where a.id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String name = rs.getString("Name");
			String age = rs.getString("Age");

			String address = rs.getString("Address");
			String experience = rs.getString("Experience");
			NhanVien nv = new NhanVien(id, name, age, address, experience);
			return nv;
		}
		return null;
	}
	public static void deleteNhanVien(Connection conn, String id) throws SQLException {
		String sql = "Delete From NhanVien where id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		pstm.executeUpdate();
	}

}