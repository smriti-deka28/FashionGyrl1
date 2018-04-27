package com.niit.Dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.CartItem;
import com.niit.Model.CustomerOrder;
import com.niit.Model.User;
@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao
{
	@Autowired
	private SessionFactory sessionFactory;

	public void saveOrUpdateCartItem(CartItem cartItem) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		//insert a new product,update quantity and totalprice for already existing cartItem
	}

	public void removeCartItem(int cartItemId)
	{
		Session session=sessionFactory.getCurrentSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
		session.delete(cartItem);

	}

	public User getUser(String email)
	{
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, email);
		List<CartItem> cartItems=user.getCartItems();
		return user;

	}

	public CustomerOrder createOrder(User user) 
	{
		Session session=sessionFactory.getCurrentSession();
		CustomerOrder customerOrder=new CustomerOrder();
		customerOrder.setPurchaseDate(new Date());
		
		List<CartItem> cartItems=user.getCartItems();
		double grandTotal=0;
		for (CartItem cartItem:cartItems)//for each cartitem in list of cartitem
		{
			grandTotal=grandTotal+cartItem.getTotalPrice();
		}
		customerOrder.setGrandTotal(grandTotal);
		customerOrder.setUser(user);
		session.save(customerOrder);
		return customerOrder;
	}

	
}
