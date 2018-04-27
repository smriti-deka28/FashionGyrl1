package com.niit.Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Model.Category;
import com.niit.Model.Product;
import com.niit.Services.ProductService;

@Controller
public class ProductController
{
	@Autowired
	private ProductService productService;
	
		public ProductController()
		{
			System.out.println("ProductController Bean is created");
		}
		
	//linked with productlist.jsp page
	//http://localhost:8080/project1frontend/all/getproducts 
		@RequestMapping(value="/all/getproducts")
		public ModelAndView getAllProducts(){
			List<Product> products=productService.getAllProducts();
			//1st parameter - logical view name - productlist
			//2nd parameter - model attribute name - refer it in jsp page
			//3rd parameter - model [data] list of products
			// /WEB-INF/views/productlist.jsp
			return new ModelAndView("productlist","productsAttr",products);
		}
	
	//linked with productdetails.jsp page
	@RequestMapping(value="/all/getproducts/{id}") //id is dynamic. id is the path variable id=1, id=2, ..., id=100
	// /all/getproduct/1	/all/getproduct/2 .... 	/all/getproduct/100....
	//it is a handler method to display data present in the table
	public ModelAndView getProduct(@PathVariable int id)
	{
		//id=1, id=2,...
		//pass this id to Service->Service has to pass the id to Dao ->Select * from Product_S180396 where id=1
		System.out.println("Product Id is:"+id);
		Product product=productService.getProduct(id);
		System.out.println("Product is:"+product);
		return new ModelAndView("productdetails","product",product);
		//1st parameter productdetails-view name-jsp filename
		//2nd parameter product-model attribute-in jsp page to display the data
		//3rd parameter product-model-data[1 1000 Product description for toy car toy car 12]
		//product=[1 1000 Product description for toy car toy car 12]
		// redirects to  /all/getproducts ->ModelAndView getAllProducts() method
	}
	
	//to delete a product
	@RequestMapping(value="/admin/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id, HttpServletRequest request)
	{
		productService.deleteProduct(id);
		String rootdirectory=request.getServletContext().getRealPath("/"); //will return rootdirectory
		System.out.println("Root Directory"+rootdirectory);
		Path paths=Paths.get((rootdirectory+"/WEB-INF/Resources/Images/"+id+".jpg"));
		if(Files.exists(paths))
		{
			try {
				Files.delete(paths);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return "redirect:/all/getproducts";
		//redirects to ModelAndView getAllProducts() and it displays the products in the memory after deleting
		//{id} is dynamic, {} represents dynamic attributes
	}
	
	
	//handler method to get productform.jsp
	@RequestMapping(value="/admin/getproductform")
	public String getProductForm(Model model)// model is used to sent data to view in the return
	{
		//Two model attributes
		//product=new Product();
		//categories=List<Category>
		List<Category> categories=productService.getAllCategories();
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categories);
		return "productform";
		//product is the model attribute
		// the new product will be created here, because of the new object created by Product()	
	}
	
	//Using ORM framework, we directly map the columns in the table, and not write the codes manually
	@RequestMapping(value="/admin/saveproduct")
	//product is the value entered by the user in the product form
	//validate productname is notempty, productdescription is notempty, min quantity is 1, min price is 1
	public String saveProduct(@Valid @ModelAttribute(name="product")Product product,BindingResult result, Model model, HttpServletRequest request)
	{
		if(result.hasErrors()) //hasErrors return true if product details in not valid, it is of boolean type
		{
			model.addAttribute("categories",productService.getAllCategories());
			return "productform";
		}
		System.out.println("New Product Details" + product);
		//product calls the to string method in the Product.class and converts the object into a string
		productService.saveProduct(product);
		MultipartFile prodImage=product.getImage();//image uploaded in the productform.jsp
		if(prodImage!=null && !prodImage.isEmpty())
		{
			//how to get rootdirectory
			String rootdirectory=request.getServletContext().getRealPath("/"); //will return rootdirectory
			//creates a path for the image
			Path paths=Paths.get(rootdirectory+"/WEB-INF/Resources/Images/"+product.getId()+".jpg");
			//throws exception
			//it stores the image in the path assigned 
				try 
				{
					prodImage.transferTo(new File(paths.toString()));
				}
				catch (IllegalStateException e)
				{
					e.printStackTrace();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		return "redirect:/all/getproducts";
		//gets product object from productform.jsp via annotation @modelattribute
	}
	
	//to call updateproductform.jsp to update a product 
	//handler method
	//ModelAndView is the handler method
	@RequestMapping(value="/admin/updateproductform/{id}")
	public ModelAndView getUpdateProductForm(@PathVariable int id, Model model)
	{
		Product product=productService.getProduct(id);
		//getter method will give all the values which are already assigned	
		//product will give the update form with all the old values already in the table
		List<Category> categories=productService.getAllCategories();
		model.addAttribute("categories", categories); //categories is referred in productform.jsp
		return new ModelAndView("updateproductform","product",product);
	}
	
	@RequestMapping(value="/admin/updateproduct")
	public String updateProduct(@Valid@ModelAttribute(name="product")Product product, BindingResult result, Model model, HttpServletRequest request) //BindingResult is an interface, if there is any errors, the hasErrors result will return true
	{
		if(result.hasErrors()) //hasErrors return true if product details in not valid, it is of boolean type, if it is false, the normal flow will continue
		{
			model.addAttribute("categories",productService.getAllCategories());
			return "updateproductform";
		}
		System.out.println("New Product Details" + product);
		productService.updateProduct(product);
		MultipartFile prodImage=product.getImage();//image uploaded in the productform.jsp
		if(prodImage!=null && !prodImage.isEmpty())
		{
			//how to get rootdirectory
			String rootdirectory=request.getServletContext().getRealPath("/"); //will return rootdirectory
			//creates a path for the image
			Path paths=Paths.get(rootdirectory+"/WEB-INF/Resources/Images/"+product.getId()+".jpg");
			//throws exception
			//it stores the image in the path assigned 
				try 
				{
					prodImage.transferTo(new File(paths.toString()));
				}
				catch (IllegalStateException e)
				{
					e.printStackTrace();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		return "redirect:/all/getproducts";
		//gets product object from updateproductform.jsp via annotation @modelattribute
	}
	
	//handler method for Select Category in drop down list
	//relation between search and select category drop down list
	@RequestMapping(value="/all/searchbycategory")
	public String searchByCategory(@RequestParam String searchCondition, Model model)
	{
		if(searchCondition.equals("All"))
		{
			model.addAttribute("searchCondition","");
		}
		else
		model.addAttribute("searchCondition", searchCondition);
		List<Product> products=productService.getAllProducts();
		model.addAttribute("productsAttr", products);
		return "productlist";
		
	}
}

