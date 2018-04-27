package com.niit.Dao;

import java.util.List;
import com.niit.Model.Supplier;

public interface SupplierDao 
{
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public Supplier getSupplier(int supplierId);
	public List<Supplier> listCategories();

}
