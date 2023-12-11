package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection_20146307;
import Models.BookModel_20146307;

public class BookDAOImpl_20146307 implements IBookDAO_20146307 {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<BookModel_20146307> findAll() {
		String sql = "select * from books";
		List<BookModel_20146307> list = new ArrayList<BookModel_20146307>();
		try {
			new DBConnection_20146307();
			Connection conn = DBConnection_20146307.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BookModel_20146307 model = new BookModel_20146307();
				model.setBookid(rs.getInt("bookid"));
				model.setTitle(rs.getString("title"));
				model.setDescription(rs.getString("description"));
				model.setPrice(rs.getBigDecimal("price"));
				model.setCoverImage(rs.getString("cover_image"));
				model.setIsbn(rs.getInt("isbn"));
				model.setPublishDate(rs.getDate("publish_date"));
				model.setPublisher(rs.getString("publisher"));
				model.setQuantity(rs.getInt("quantity"));
				list.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insert(BookModel_20146307 bookModel_20146422) {
		String sql = "Insert into books(isbn, title, publisher, price, description, publish_date, cover_image, quantity) "
				+ "values (?,?,?,?,?,?,?,?)";
		try {
			new DBConnection_20146307();
			conn = DBConnection_20146307.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookModel_20146422.getIsbn());
			ps.setString(2, bookModel_20146422.getTitle());
			ps.setString(3, bookModel_20146422.getPublisher());
			ps.setBigDecimal(4, bookModel_20146422.getPrice());
			ps.setString(5, bookModel_20146422.getDescription());
			ps.setDate(6, new java.sql.Date(bookModel_20146422.getPublishDate().getTime()));
			ps.setString(7, bookModel_20146422.getCoverImage());
			ps.setInt(8, bookModel_20146422.getQuantity());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String title) {
		String sql = "delete from books where title = ?";
		try {
			new DBConnection_20146307();
			conn = DBConnection_20146307.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
