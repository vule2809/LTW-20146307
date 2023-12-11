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
	public void insert(ProductModels model) {
		proDao.insert(model);
	}

	@Override
	public ProductModels findOne(int id) {
		return proDao.findOne(id);
	}

	@Override
	public void update(ProductModels model) {
		ProductModels oldcate = proDao.findOne(model.getProductID());
		oldcate.setProductID(model.getProductID());
		oldcate.setProductName(model.getProductName());
		oldcate.setBrand(model.getBrand());
		oldcate.setYear(model.getYear());
		oldcate.setColor(model.getColor());
		oldcate.setPrice(model.getPrice());
		oldcate.setDescription(model.getDescription());
		proDao.update(model);
	}

	@Override
	public void delete(int id) {
		proDao.delete(id);
	}

}
