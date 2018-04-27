package com.niit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Dao.CartItemDao;
import com.niit.Model.CartItem;
import com.niit.Model.CustomerOrder;
import com.niit.Model.User;
@Service
public class CartItemServiceImpl implements CartItemService
{
	@Autowired
	private CartItemDao cartItemDao;
	public void saveOrUpdateCartItem(CartItem cartItem)
	{
		cartItemDao.saveOrUpdateCartItem(cartItem);
	}

	public void removeCartItem(int cartItemId) 
	{
		cartItemDao.removeCartItem(cartItemId);

	}

	public User getUser(String email) 
	{
		
		return cartItemDao.getUser(email);
	}

	public CustomerOrder createOrder(User user)
	{
		return cartItemDao.createOrder(user);
	}

}
