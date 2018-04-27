package com.niit.Services;
import java.util.List;

import com.niit.Model.Category;
import com.niit.Model.Product;

public interface ProductService 
{
	List<Product> getAllProducts();
	Product getProduct(int id);
	void deleteProduct(int id);
	void saveProduct(Product product);
	void updateProduct(Product product);
	List<Category> getAllCategories();
}
