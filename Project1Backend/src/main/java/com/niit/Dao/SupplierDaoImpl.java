package com.niit.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.Product;
import com.niit.Model.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	
	public boolean addSupplier(Supplier supplier) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(supplier);
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
	}

	public boolean updateSupplier(Supplier supplier) 
	{
		
		return false;
	}

	
	public boolean deleteSupplier(Supplier supplier) 
	{
		
		return false;
	}

	
	public Supplier getSupplier(int supplierId) 
	{
		
		return null;
	}


	public List<Supplier> listCategories() 
	{
		
		return null;
	}
}
