package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//there will be one cart for each customer, customer can purchase any 
//number of items, grandtotal will get updated
@Entity
public class Cart
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private double grandtotal;
	@OneToOne
	private Customer customer;//FK customer_id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
