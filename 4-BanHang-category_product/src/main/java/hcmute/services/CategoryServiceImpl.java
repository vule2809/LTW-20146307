package hcmute.services;

import java.util.List;

import hcmute.DAO.CategoryDAOimpl;
import hcmute.DAO.ICategoryDAO;
import hcmute.models.CategoryModels;

public class CategoryServiceImpl implements ICategoryService {
	// gọi các phương thức của DAO
	ICategoryDAO cateDao = new CategoryDAOimpl();

	@Override
	public List<CategoryModels> findALL() {
		// xữ lý logic

		// gọi và truyền cho DAO
		return cateDao.findALL();
	}

	@Override
	public void insert(CategoryModels model) {
		// xữ lý logic
		// gọi và truyền cho DAO
		cateDao.insert(model);
	}

	@Override
	public CategoryModels findOne(int id) {
		return cateDao.findOne(id);
	}

	@Override
	public void update(CategoryModels model) {
		CategoryModels oldcate = cateDao.findOne(model.getCateID());
		oldcate.setCateID(model.getCateID());
		oldcate.setCateName(model.getCateName());
		oldcate.setImage(model.getImage());
		cateDao.update(model);
	}

	@Override
	public void delete(int id) {
		cateDao.delete(id);		
	}
}
