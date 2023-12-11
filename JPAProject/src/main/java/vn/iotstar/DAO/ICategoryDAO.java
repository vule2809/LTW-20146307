package vn.iotstar.DAO;

import java.util.List;

import vn.iotstar.Entity.category;

public interface ICategoryDAO {
	void insert(category category);
	void update(category category);
	void delete(int cateid) throws Exception;
	category findById(int categoryId);
	List<category> findAll();
	List<category> findByCategoryname(String catname);
	List<category> findAll(int page, int pagesize);
	int count();
}
