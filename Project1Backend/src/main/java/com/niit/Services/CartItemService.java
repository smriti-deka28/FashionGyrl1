package com.niit.Services;

import com.niit.Model.CartItem;
import com.niit.Model.CustomerOrder;
import com.niit.Model.User;

public interface CartItemService
{
	void saveOrUpdateCartItem(CartItem cartItem);
	void removeCartItem(int cartItemId);
	User getUser(String email);
	CustomerOrder createOrder(User user);


}
