package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.ProductModels;

public class ProductDAOimpl implements IProductDAO {

	@Override
	public List<ProductModels> findALL() {
		String sql = "select * from product";
		List<ProductModels> list = new ArrayList<ProductModels>();
		try {
			new DBconnection();
			Connection conn = DBconnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModels model = new ProductModels();
				model.setProductID(rs.getInt(1));
				model.setProductName(rs.getString(2));
				model.setBrand(rs.getString(3));
				model.setYear(rs.getInt(4));
				model.setColor(rs.getString(5));
				model.setPrice(rs.getInt(6));
				model.setDescription(rs.getString(7));
				list.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insert(ProductModels model) {
		String sql = "Insert into product (ProductName, Brand, Year, Color, Price, Desciption) values (?,?,?,?,?,?)";
		try {
			new DBconnection();
			Connection conn = DBconnection.getConnection(); // kết nối CSDL
			PreparedStatement ps = conn.prepareStatement(sql); // ném câu lệnh sql bằng phát biểu preparestatement
			// gắn gias trị cho tham sô
			ps.setString(1, model.getProductName());
			ps.setString(2, model.getBrand());
			ps.setInt(3, model.getYear());
			ps.setString(4, model.getColor());
			ps.setInt(5, model.getPrice());
			ps.setString(6, model.getDescription());
			ps.executeUpdate(); // thực thi câu Query
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ProductModels findOne(int id) {
		// xữ lý dữ liệu lấy ra 1 đối tượng Category
		String sql = "select * from product where ProductID=?";
		ProductModels model = new ProductModels();
		try {
			new DBconnection();
			Connection conn = DBconnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				model.setProductID(rs.getInt("productID"));
				model.setProductName(rs.getString("productName"));
				model.setBrand(rs.getString("brand"));
				model.setYear(rs.getInt("year"));
				model.setColor(rs.getString("color"));
				model.setPrice(rs.getInt("price"));
				model.setDescription(rs.getString("description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@Override
	public void update(ProductModels model) {
		String sql = "update product set ProductName=?, Brand=?, Year=?, Color=?, Price=?, Description=? where ProductID=?";
		try {
			new DBconnection();
			Connection conn = DBconnection.getConnection(); // kết nối CSDL
			PreparedStatement ps = conn.prepareStatement(sql); // ném câu lệnh sql bằng phát biểu preparestatement
			// gắn gias trị cho tham sô
			ps.setString(1, model.getProductName());
			ps.setString(2, model.getBrand());
			ps.setInt(3, model.getYear());
			ps.setString(4, model.getColor());
			ps.setInt(5, model.getPrice());
			ps.setString(6, model.getDescription());
			ps.executeUpdate(); // thực thi câu Query
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from product where ProductID=?";
		try {
			new DBconnection();
			Connection conn = DBconnection.getConnection(); // kết nối CSDL
			PreparedStatement ps = conn.prepareStatement(sql); // ném câu lệnh sql bằng phát biểu preparestatement
			ps.setInt(1, id); // gắn gias trị cho tham sô
			ps.executeUpdate(); // thực thi câu sql
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
