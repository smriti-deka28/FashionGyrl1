package com.niit.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.Authorities;
import com.niit.Model.Cart;
import com.niit.Model.Customer;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao 
{
	@Autowired
	private SessionFactory sessionFactory;

	public void registerCustomer(Customer customer)
	{
		//all objects are transient
		Session session=sessionFactory.getCurrentSession();
		//create authorities
		//create cart
		//set enable true
		customer.getUser().setEnabled(true);
		
		Authorities authorities=new Authorities();
		authorities.setRole("ROLE_USER");
		authorities.setUser(customer.getUser()); //FK user_email in authorities table
		customer.getUser().setAuthorities(authorities);
		
		Cart cart=new Cart();
		customer.setCart(cart);
		cart.setCustomer(customer);
		//here objects are detached: present in heap memory and database but are not mapped
		session.save(customer);
		//this will input values in all the tables , which are cascaded
		//here it is persistent
		//on exit, objects are detached
		
	}
	
}
