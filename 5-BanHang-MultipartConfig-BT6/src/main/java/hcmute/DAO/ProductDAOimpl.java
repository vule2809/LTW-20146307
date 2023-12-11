package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.CategoryModels;
import hcmute.models.ProductModels;

public class ProductDAOimpl implements IProductDAO {

	ICategoryDAO cateDao = new CategoryDAOimpl();

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
				model.setDesc(rs.getString(3));
				model.setPrice(rs.getInt(4));
				model.setImageLink(rs.getString(5));
				model.setcategoryID(6);
				model.setSellerID(rs.getInt(7));
				model.setAmount(rs.getInt(8));
				model.setStoke(rs.getInt(9));
				list.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProductModels> findProductByCategory(int cateid) {
		String sql = "select * from product where CategoryID=?";
		List<ProductModels> list = new ArrayList<ProductModels>();
		try {
			new DBconnection();
			Connection conn = DBconnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cateid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModels model1 = cateDao.findOne(rs.getInt("CategoryID"));
				ProductModels model = new ProductModels();
				model.setProductID(rs.getInt("ProductID"));
				model.setProductName(rs.getString("ProductName"));
				model.setDesc(rs.getString("Description"));
				model.setPrice(rs.getInt("Price"));
				model.setImageLink(rs.getString("imageLink"));
				model.setcategoryID(model1.getCateID());
				model.setSellerID(rs.getInt("SellerID"));
				model.setAmount(rs.getInt("Amount"));
				model.setStoke(rs.getInt("Stoke"));
				list.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insert(ProductModels model) {
		String sql = "insert into product(ProductName,Description,Price,imageLink,CategoryID,stoke) values(?,?,?,?,?,?)";
		try {
			Connection conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, model.getProductName());
			ps.setString(2, model.getDesc());
			ps.setInt(3, model.getPrice());
			ps.setString(4, model.getImageLink());
			ps.setInt(5, model.getCategory().getCateID());
			ps.setInt(6, model.getStoke());

			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ProductModels model) {
		String sql = "update product set ProductName=?, Description=?, Price=?, imageLink=?, CategoryID=?, stoke=? where ProductID=?";
		try {
			Connection conn = new DBconnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, model.getProductName());
			ps.setString(2, model.getDesc());
			ps.setInt(3, model.getPrice());
			ps.setString(4, model.getImageLink());
			ps.setInt(5, model.getCategory().getCateID());
			ps.setInt(6, model.getStoke());
			ps.setInt(7, model.getProductID());

			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ProductModels findOne(int id) {
		String sql = "select * from product where ProductID=?";
		ProductModels model = new ProductModels();
		try {
			new DBconnection();
			Connection conn = DBconnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModels model1 = cateDao.findOne(rs.getInt("CategoryID"));				
				model.setProductID(rs.getInt("ProductID"));
				model.setProductName(rs.getString("ProductName"));
				model.setDesc(rs.getString("Description"));
				model.setPrice(rs.getInt("Price"));
				model.setImageLink(rs.getString("imageLink"));
				model.setcategoryID(model1.getCateID());
				model.setSellerID(rs.getInt("SellerID"));
				model.setAmount(rs.getInt("Amount"));
				model.setStoke(rs.getInt("Stoke"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	public static void main(String[] args) {
		IProductDAO proDao = new ProductDAOimpl();
		List<ProductModels> list = proDao.findProductByCategory(3);
		System.out.println(list);
	}
}
