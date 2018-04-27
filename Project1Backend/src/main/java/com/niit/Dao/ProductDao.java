package com.niit.Dao;

import java.util.List;
import com.niit.Model.Category;
import com.niit.Model.Product;

public interface ProductDao 
{
		List<Product> getAllProducts();
		Product getProduct(int id);
		void deleteProduct(int id);
		void saveOrUpdateProduct(Product product);
		List<Category> getAllCategories();
}
