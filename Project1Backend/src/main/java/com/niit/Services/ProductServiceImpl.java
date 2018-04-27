package com.niit.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.niit.Dao.ProductDao;
import com.niit.Model.Category;
import com.niit.Model.Product;

//presentation layer
//gets information from ProductController 
@Service
public class ProductServiceImpl implements ProductService 
{
	@Autowired
	private ProductDao productDao;
	public ProductServiceImpl()
	{
		System.out.println("ProductServiceImpl Bean is created ");
	}
	
	public List<Product> getAllProducts() 
	{
		return productDao.getAllProducts();
	}
	public Product getProduct(int id) 
	{
		//call dao
		return productDao.getProduct(id);
	}
	public void deleteProduct(int id)
	{
		productDao.deleteProduct(id);
		// id will be given by Controller, which will be fetched from jsp page
	}

	public void saveProduct(Product product)
	{
		productDao.saveOrUpdateProduct(product);
			
	}

	public void updateProduct(Product product) 
	{
		productDao.saveOrUpdateProduct(product);
		
	}
	//if id present, it will edit data, if id=0, it will insert new data

	public List<Category> getAllCategories() 
	{
		
		return productDao.getAllCategories();
	}

}
