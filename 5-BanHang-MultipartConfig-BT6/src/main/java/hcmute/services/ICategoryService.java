package hcmute.services;

import java.util.List;

import hcmute.models.CategoryModels;

public interface ICategoryService {
	// định nghĩa các phương thức

	List<CategoryModels> findALL();

	void insert(CategoryModels model);

	CategoryModels findOne(int id);

	void update(CategoryModels model);
	
	void delete(int id);

}
