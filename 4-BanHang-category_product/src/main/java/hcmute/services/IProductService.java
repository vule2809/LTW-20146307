package hcmute.services;

import java.util.List;

import hcmute.models.ProductModels;

public interface IProductService {

	List<ProductModels> findALL();

	List<ProductModels> findProductByCategory(int cateid);

}
