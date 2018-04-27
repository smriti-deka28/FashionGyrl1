package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity //mapped with Product relational table
@Table(name="product_s180396")
public class Product 
{
	public Product()
	{
		System.out.println("Bean Created for Product");
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // generates id automatically when  inserting  new  product
	private int id;
	
	@NotEmpty(message="*Product name cannot be blank") //for validation, for string the annotation is notempty
	private String productname;
	
	@NotEmpty (message="*Product description cannot be blank")//for validation, for string the annotation is notempty
	private String productdescription;
	
	//@Min(value=1, message="*Minimum quantity must be 1") //for validation, for int value, the annotation is min(where the min value is to be given
	private int quantity;
	
	@Min(value=1, message="*Minimum quantity must be 1")//for validation, for int value, the annotation is min(where the min value is to be given
	private double price;
	
	@ManyToOne
	//Foreign Key category_id
	@JoinColumn(name="cid") //foreign key column
	private Category category; //mapped by value is 'category' which is mapped in Category.java
	//category is a integer value which is used to relate between two tables
	
	@Transient //this property will not get inerted in the database
	private MultipartFile image;
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public int getId() 
	{
		System.out.println("Get id");
		return id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setId(int id) 
	{
		System.out.println("Set id");
		this.id = id;
	}
	public String getProductname() 
	{
		System.out.println("Get productname");
		return productname;
	}
	public void setProductname(String productname) 
	{
		System.out.println("Set productname");
		this.productname = productname;
	}
	public String getProductdescription() 
	{
		System.out.println("Get productdescription");
		return productdescription;
	}
	public void setProductdescription(String productdescription) 
	{
		System.out.println("Set productdescription");
		this.productdescription = productdescription;
	}
	public int getQuantity() 
	{
		System.out.println("Get quantity");
		return quantity;
	}
	public void setQuantity(int quantity) 
	{
		System.out.println("Set quantity");
		this.quantity = quantity;
	}
	public double getPrice() 
	{
		System.out.println("Get price");
		return price;
	}
	public void setPrice(double price) 
	{
		System.out.println("Set price");
		this.price = price;
	}
	
	public String toString()
	{
		return (this.id+"\t"+this.productname+"\t"+this.productdescription+"\t"+this.price+"\t"+this.quantity+"\t");
	}
}
