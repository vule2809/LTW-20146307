package hcmute.DAO;

import java.util.List;

import hcmute.models.ProductModels;

public interface IProductDAO {

	List<ProductModels> findALL();
	List<ProductModels> findProductByCategory(int cateid);
	
	void insert(ProductModels model);
	
	void update(ProductModels model);
	ProductModels findOne(int id);

}
