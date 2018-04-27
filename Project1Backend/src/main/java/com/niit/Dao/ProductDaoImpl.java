package com.niit.Dao;
//contains all the CRUD operation methods
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.Category;
import com.niit.Model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao 
{
	public ProductDaoImpl()
	{
		System.out.println("Bean Created for ProductDaoImpl");
	}
	@Autowired
	private SessionFactory sessionFactory;
	public List<Product> getAllProducts() 
	{
		Session session=sessionFactory.getCurrentSession();
		String hqlString="from Product";//Product is name of the entity
		
		//HQL - from Product
		//SQL - select * from product_s180396
		Query query=session.createQuery(hqlString);
		List<Product> products=query.list();
		return products;
	}
	//linked with interface ProductDao
	public Product getProduct(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		//API-session.get(EntityClassObject.PK)
		//select * from TableTOWhich entity is mapped where PK=?
		Product product=(Product) session.get(Product.class, id); //Product class is entity
		//it is a read operation, get finds the entity to be mapped
		//id=1,2,3...
		//Select * from Product_S180396 where id=?
		return product;
	}
	//linked with interface ProductDao
	public void deleteProduct(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product) session.get(Product.class, id);
		//select * from Product_S180396 where id=?
		session.delete(product);
		//delete from Product_S180396 where id=?
		//delete method needs object to implement, and cannot delete from primary key
	}
	
	public void saveOrUpdateProduct(Product product) 
	{
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Id of the product\t" + product.getId());
		// before  inserting,  id will  be  zero
		session.saveOrUpdate(product); //insert into Product_S180396 values(?,..,...,...), id will be generated automatically
		//in the console, insert into product_s180396 (id, price, productdescription, productname, quantity) values (null, ?, ?, ?, ?)
		//data will be saved automatically for the new record
		//object relational table linked
		//saveProduct will insert data
		//updateProduct will edit exiting product data
		//saveOrUpdateProduct will insert or update data depending on the id. 
		//if id is present, it will update data.
		//if id is zero, it will insert new product data
		System.out.println("After inserting, Id of the product\t" + product.getId());
	
	}
	public List<Category> getAllCategories() 
	{
		Session session=sessionFactory.getCurrentSession();
		//select * from category_S180396
		Query query=session.createQuery("from Category");
		List<Category> categories=query.list();
		return categories;
	}
	
	
}
