package hcmute.services;

import java.util.List;

import hcmute.DAO.IProductDAO;
import hcmute.DAO.ProductDAOimpl;
import hcmute.models.ProductModels;

public class ProductServiceImpl implements IProductService {

	IProductDAO proDao = new ProductDAOimpl();

	@Override
	public List<ProductModels> findALL() {

		return proDao.findALL();
	}

	@Override
	public List<ProductModels> findProductByCategory(int cateid) {

		return proDao.findProductByCategory(cateid);
	}

	@Override
	public void insert(ProductModels model) {
		proDao.insert(model);
	}

	@Override
	public void update(ProductModels model) {
		ProductModels newPro = proDao.findOne(model.getProductID());
		newPro.setProductName(model.getProductName());
		newPro.setDesc(model.getDesc());
		newPro.setPrice(model.getPrice());
		newPro.setImageLink(model.getImageLink());
		newPro.setCategory(model.getCategory());
		newPro.setStoke(model.getStoke());

		proDao.update(newPro);
	}

	@Override
	public ProductModels findOne(int id) {

		return proDao.findOne(id);
	}
}
