package vn.iotstar.Service;

import java.util.List;

import vn.iotstar.DAO.CategoryDAOimpl;
import vn.iotstar.DAO.ICategoryDAO;
import vn.iotstar.Entity.category;

public class CategoryBLLimpl implements ICategoryBLL {
	ICategoryDAO categoryDAO = new CategoryDAOimpl();
	
	@Override
	public void insert(category category) {
		categoryDAO.insert(category);
	}
	@Override
	public void update(category category) {
		categoryDAO.update(category);
	}
	@Override
	public void delete(int cateid) throws Exception {
		categoryDAO.delete(cateid);
	}
	@Override
	public category findById(int categoryId) {
		return categoryDAO.findById(categoryId);
	}
	@Override
	public List<category> findAll() {
		return categoryDAO.findAll();
	}
	@Override
	public List<category> findByCategoryname(String catname) {
		return categoryDAO.findByCategoryname(catname);
	}
	@Override
	public List<category> findAll(int page, int pagesize) {
		return categoryDAO.findAll(page, pagesize);
	}
	@Override
	public int count() {
		return categoryDAO.count();
	}
}
