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

	public static void main(String[] args) {
		IProductDAO proDao = new ProductDAOimpl();
		List<ProductModels> list = proDao.findProductByCategory(3);
		System.out.println(list); 
	}

}
