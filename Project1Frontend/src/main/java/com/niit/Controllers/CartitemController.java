package com.niit.Controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.Model.CartItem;
import com.niit.Model.Customer;
import com.niit.Model.CustomerOrder;
import com.niit.Model.Product;
import com.niit.Model.ShippingAddress;
import com.niit.Model.User;
import com.niit.Services.CartItemService;
import com.niit.Services.ProductService;

@Controller
public class CartitemController 
{
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/cart/addtocart/{id}")
	public String addToCart(@PathVariable int id, @AuthenticationPrincipal Principal principal,
			@RequestParam int requestedQuantity)
	{
		String email=principal.getName(); //returns emailid of the logged in user
		User user=cartItemService.getUser(email);
		Product product=productService.getProduct(id);
		List<CartItem> cartItems=user.getCartItems();
		//if the selected product already exists in the cartitem table, only update the quantity
		//New cartitem object need not be created
		for(CartItem cartItem:cartItems)//for(Type localvariable:collection)
		{
			if(cartItem.getProduct().getId()==id)
			{
				cartItem.setQuantity(requestedQuantity);
				cartItem.setTotalPrice(requestedQuantity*product.getPrice());
			}
		}
		
		CartItem cartItem=new CartItem();
		cartItem.setQuantity(requestedQuantity);
		cartItem.setTotalPrice(requestedQuantity*product.getPrice());
		cartItem.setUser(user);// FK user_email
		cartItem.setProduct(product);//FK column product_id
		cartItemService.saveOrUpdateCartItem(cartItem);
		return "redirect:/cart/purchasedetails";
		
		}
		
	@RequestMapping(value="/cart/purchasedetails")
		public String getPurchaseDetails(@AuthenticationPrincipal Principal principal, Model model)
		{
			String email=principal.getName();
			User user=cartItemService.getUser(email);
			List<CartItem> cartItems=user.getCartItems();//list of CartItem/products
			model.addAttribute("cartItems",cartItems);
			return "cart";
		}
		
	@RequestMapping(value="/cart/deletecartitem/{cartItemId}")
	public String removeCartItem(@PathVariable int cartItemId)
	{
		cartItemService.removeCartItem(cartItemId);
		return "redirect:/cart/purchasedetails";
	}
		
	@RequestMapping(value="/cart/clearcart")
    public String clearCart(@AuthenticationPrincipal Principal principal){
		User user=cartItemService.getUser(principal.getName());
		List<CartItem> cartItems=user.getCartItems();
		for(CartItem cartItem:cartItems)
			cartItemService.removeCartItem(cartItem.getCartitemid());
		return "redirect:/cart/purchasedetails";
    }
		
		@RequestMapping(value="/cart/checkout")
		public String checkout(@AuthenticationPrincipal Principal principal, Model model)
		{
			User user=cartItemService.getUser(principal.getName());
			Customer customer=user.getCustomer();
			ShippingAddress shippingaddress=customer.getShippingaddress();
			model.addAttribute("shippingaddress",shippingaddress);
			return "shippingaddress";
		}
		
		@RequestMapping(value="/cart/createorder")
		//from shippingaddressform.jsp to createOrder method
		public String createOrder(@AuthenticationPrincipal Principal principal ,
				                  @ModelAttribute ShippingAddress shippingaddress,
				                  Model model, HttpSession session)
		{
			User user=cartItemService.getUser(principal.getName());
			Customer customer=user.getCustomer();
			customer.setShippingaddress(shippingaddress);//updated shippingaddress if it is required
			user.setCustomer(customer);
			List<CartItem> cartItems=user.getCartItems();
			for(CartItem cartItem:cartItems)
			{
				Product product=cartItem.getProduct();
				if((product.getQuantity()-cartItem.getQuantity())<0)
				{
					cartItemService.removeCartItem(cartItem.getCartitemid());
					model.addAttribute("productNA",product);
					return "productNA";
				}
			}
			
			CustomerOrder customerOrder=cartItemService.createOrder(user);
			for(CartItem cartItem:cartItems)
			{
				Product product=cartItem.getProduct();
				product.setQuantity(product.getQuantity()-cartItem.getQuantity());
				productService.updateProduct(product);
				cartItemService.removeCartItem(cartItem.getCartitemid());
			}
			model.addAttribute("order",customerOrder);
			session.setAttribute("cartSize",0);
			return "orderdetails";
		}
		
	

}
