package hcmute.services;

import java.util.List;

import hcmute.models.ProductModels;

public interface IProductService {

	List<ProductModels> findALL();

	void insert(ProductModels model);

	ProductModels findOne(int id);

	void update(ProductModels model);

	void delete(int id);

}
