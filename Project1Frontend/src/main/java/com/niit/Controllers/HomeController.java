package com.niit.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController
{
	public HomeController()
	{
		System.out.println("Home Controller bean is created");
	}
	//this is a handler method
	//it can handle the request "http://localhost:8080/Project1Frontend/home"
	//->DispatcherServlet->"home"
	// /WEB-INF/Views/home
	@RequestMapping(value="/home")
	public String getHomepage() 
	{
		return "home";
	}
	
	@RequestMapping("/login")
	public String loginPage(@RequestParam(required=false) String error,@RequestParam(required=false) String logout,Model model){
		if(error!=null)
		model.addAttribute("error","Invalid Username/Password");
		if(logout!=null)
			model.addAttribute("msg","Loggedout successfully");
		return "login";
	}


}
