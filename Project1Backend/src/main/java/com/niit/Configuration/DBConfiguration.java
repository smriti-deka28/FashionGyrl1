package com.niit.Configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Dao.SupplierDao;
import com.niit.Dao.SupplierDaoImpl;
import com.niit.Model.Authorities;
import com.niit.Model.BillingAddress;
import com.niit.Model.Cart;
import com.niit.Model.CartItem;
import com.niit.Model.Category;
import com.niit.Model.Customer;
import com.niit.Model.CustomerOrder;
import com.niit.Model.Product;
import com.niit.Model.ShippingAddress;
import com.niit.Model.Supplier;
import com.niit.Model.User;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

@Configuration
@EnableTransactionManagement
public class DBConfiguration 
{
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		System.out.println("DataSourceManagement bean created");
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/smriti");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	    return dataSource;
	}
	/*
	 * <bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBuilder">
	 * <property name="dataSource" ref="dataSource">
	 */
	@Bean 		//SessionFactory - factory of session objects
	public SessionFactory sessionFactory()
	{
		System.out.println("SessionFactory Bean created");
		LocalSessionFactoryBuilder lsf=new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update"); //hibernate.hbm2ddlauto creates new tables when entities are mapped when seesionfactory is instantiated 
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		
		//An array of Class objects of all the entities
		//Map all entities to relational table
		
		Class classes[]=new Class[]{Product.class,Category.class,Supplier.class,Customer.class,User.class,Cart.class,Authorities.class, BillingAddress.class,ShippingAddress.class,CartItem.class,CustomerOrder.class};//entity names
		
		//localsesionfactorybuilder -> sessionfactory -> map all entities with relation table
	   
		return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}
	@Bean
	public HibernateTransactionManager hibTransManagement()
	{
		return new HibernateTransactionManager(sessionFactory());
	}
	
	@Bean(name="supplierDao")
	public SupplierDao getSupplierDao()
	{
		System.out.println("---Supplier Bean Created---");
		return new SupplierDaoImpl();
	}
}
		