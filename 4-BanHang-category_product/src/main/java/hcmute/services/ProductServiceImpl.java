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
}
