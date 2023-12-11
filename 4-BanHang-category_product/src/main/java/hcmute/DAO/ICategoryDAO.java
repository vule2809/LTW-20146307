package hcmute.DAO;

import java.util.List;

import hcmute.models.CategoryModels;

public interface ICategoryDAO {
	// định nghĩa các phương thức
	List<CategoryModels> findALL();

	void insert(CategoryModels model);
	
	CategoryModels findOne(int id);
	
	void update (CategoryModels model);
	
	void delete (int id);

}
