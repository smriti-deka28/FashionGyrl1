package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CartItem
{
	//cartItem:User
	//id:user_email, ManyToOne
	//cartItemId:Product_id, ManyToOne
	//cartitemid  productid(like)
	//	100			1
	//	101			1
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartitemid;
	private int quantity;
	private double totalPrice;
	@ManyToOne
	private User user;//mapped by is used in User class
	//user_email will be in the CartItem table
	//User table will not be modified
	//For the column, the mapped by tag must be 
	//added in the other side to get the column in .this entity
	// if mapped by is used in both sides, then  a third table will be created
	@ManyToOne
	private Product product;
	public int getCartitemid() {
		return cartitemid;
	}
	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	

}
