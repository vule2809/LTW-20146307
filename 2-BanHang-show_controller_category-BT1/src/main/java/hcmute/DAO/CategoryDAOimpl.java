package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.CategoryModels;

public class CategoryDAOimpl implements ICategoryDAO {

	@Override
	public List<CategoryModels> findALL() {
		// xữ lý dữ liệu hiển thị tất cả category

		List<CategoryModels> listcate = new ArrayList<CategoryModels>();
		String sql = "Select * from category";

		try {
			new DBconnection();
			Connection conn = DBconnection.getConnection(); // kết nối CSDL
			PreparedStatement ps = conn.prepareStatement(sql); // ném câu lệnh sql bằng phát biểu preparestatement
			ResultSet rs = ps.executeQuery(); // thực thi câu Quẻy và trả về Réultset
			while (rs.next()) { // duyệt từng dòng trong Resultset, trả về danh sách đối tượng

				CategoryModels category = new CategoryModels();
				category.setCateID(rs.getInt("categoryID"));
				category.setCateName(rs.getString("categoryname"));
				category.setImage(rs.getString("icon"));
				listcate.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listcate;
	}

	@Override
	public void insert(CategoryModels model) {
		// xữ lý thêm category
		String sql = "Insert into category (CategoryName, icon) values (?,?)";
		try {
			new DBconnection();
			Connection conn = DBconnection.getConnection(); // kết nối CSDL
			PreparedStatement ps = conn.prepareStatement(sql); // ném câu lệnh sql bằng phát biểu preparestatement
			// gắn gias trị cho tham sô
			ps.setString(1, model.getCateName());
			ps.setString(2, model.getImage());
			ps.executeUpdate(); // thực thi câu Query
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CategoryModels findOne(int id) {
		// xữ lý dữ liệu lấy ra 1 đối tượng Category
		String sql = "select * from category where CategoryID=?";
		CategoryModels model = new CategoryModels();
		try {
			new DBconnection();
			Connection conn = DBconnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				model.setCateID(rs.getInt("CategoryID"));
				model.setCateName(rs.getString("CategoryName"));
				model.setImage(rs.getString("icon"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@Override
	public void update(CategoryModels model) {
		String sql = "update category set CategoryName=?, icon=? where CategoryID=?";
		try {
			new DBconnection();
			Connection conn = DBconnection.getConnection(); // kết nối CSDL
			PreparedStatement ps = conn.prepareStatement(sql); // ném câu lệnh sql bằng phát biểu preparestatement
			// gắn gias trị cho tham sô
			ps.setString(1, model.getCateName());
			ps.setString(2, model.getImage());
			ps.setInt(3, model.getCateID());
			ps.executeUpdate(); // thực thi câu Query
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from category where CategoryID=?";
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
