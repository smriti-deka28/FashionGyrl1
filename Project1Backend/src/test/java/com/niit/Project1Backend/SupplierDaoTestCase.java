package com.niit.Project1Backend;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.Dao.SupplierDao;
import com.niit.Model.Supplier;

public class SupplierDaoTestCase
{
	static SupplierDao supplierDao;
	
	@BeforeClass
	public static void setup()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDao=(SupplierDao)context.getBean("supplierDao");
	}
	
	@Test
	public void addSupplierTestCase()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("BlueInfoSystem");
		supplier.setSupplierAddr("Hyderabad");
		
		assertTrue("Problem in Adding Supplier",supplierDao.addSupplier(supplier));
	}
	@Ignore
	@Test
	public void listSupplierDetailTest()
	{
		List<Supplier> listSupplier=supplierDao.listCategories();
		assertNotNull("Problem in Listing",listSupplier);
		for(Supplier supplier:listSupplier)
		{
			System.out.println("Supplier Name:"+supplier.getSupplierName());
			System.out.println("Supplier Address:"+supplier.getSupplierAddr());
		}
	}

}
