<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include  file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href='<c:url value="/Resources/Css/registration.css"></c:url>'>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js">
</script>
<script type="text/javascript">

function fillShippingAddress(form)
{
	if(form.shippingsame.checked==true)
	{
		form["shippingaddress.apartmentnumber"].value=form["billingaddress.apartmentnumber"].value;
		form["shippingaddress.streetname"].value=form["billingaddress.streetname"].value;
		form["shippingaddress.city"].value=form["billingaddress.city"].value;
		form["shippingaddress.state"].value=form["billingaddress.state"].value;
		form["shippingaddress.country"].value=form["billingaddress.country"].value;
		form["shippingaddress.zipcode"].value=form["billingaddress.zipcode"].value;
	}
	if(form.shippingsame.checked==false)
	{
		form["shippingaddress.apartmentnumber"].value=""
		form["shippingaddress.streetname"].value=""
		form["shippingaddress.city"].value=""
		form["shippingaddress.state"].value=""
		form["shippingaddress.country"].value=""
		form["shippingaddress.zipcode"].value=""
	}
}

$(document).ready(function(){
	$('#form').validate({
		rules:{
			firstname:{required:true},
			phonenumber:{required:true,number:true,minlength:10,maxlength:10},
			"user.email":{required:true,email:true},
			"user.password":{required:true,minlength:5,maxlength:10},
			"billingaddress.apartmentnumber":{required:true},
			"billingaddress.streetname":{required:true},
			"billingaddress.city":{required:true},
			"billingaddress.state":{required:true},
			"billingaddress.country":{required:true},
			"billingaddress.zipcode":{required:true,number:true,minlength:6,maxlength:6},
	
		},
		messages:{
			firstname:{required:"Firstname is mandatory"},
			phonenumber:{required:"Phone Number is required"},
			"user.email":{required:"Email address required",email:"Please enter a valid email address"},
			"billingaddress.zipcode":{required:"Please enter a proper zipcode"}
			
		}
	})
})
</script>
</head>
<body>
<div class="container">
<c:url var="url" value="/all/registercustomer"></c:url>
<form:form modelAttribute="customer" action="${url }" id="form">
<p align="center"><b>Customer Details</b><br></p>
<form:label path="id"></form:label>
<form:hidden path="id"/>
	 
	 <form:label path="firstname">Enter First Name</form:label>
	 <form:input path="firstname" id="firstname"/>
	 <br>
	 
	 <form:label path="lastname">Enter Last Name</form:label>
	 <form:input path="lastname" id="lastname"/>
	 <br>
	 
	 <form:label path="phonenumber">Enter Phone Number</form:label>
	 <form:input path="phonenumber" id="phonenumber"/>
	 <br>
	 <p align="center"><b>Login Credentials</b><br></p>
	 <!-- modelAttribute="customer" -->
	 <form:label path="user.email">Enter EmailId</form:label>
	 <form:input path="user.email" id="user.email"/>
	 <br>
	 
	 <form:label path="user.password">Enter Password</form:label>
	 <form:input path="user.password" type="password" id="user.password"/>
	 <br>
	 <p align="center">
	 <b>Billing Address</b>
	 <br>
	 </p>
	 <form:label path="billingaddress.apartmentnumber">Enter Apartment Number</form:label>
	 <form:input path="billingaddress.apartmentnumber" id="billingaddress.apartmentnumber" />
	 <br>
	 
	 <form:label path="billingaddress.streetname">Enter Street Name</form:label>
	 <form:input path="billingaddress.streetname" id="billingaddress.streetname"/>
	 <br>
	 
	 <form:label path="billingaddress.city">Enter City</form:label>
	 <form:input path="billingaddress.city" id="billingaddress.city"/>
	 <br>
	 
	 <form:label path="billingaddress.state">Enter State</form:label>
	 <form:input path="billingaddress.state" id="billingaddress.state"/>
	 <br>
	 
	 <form:label path="billingaddress.country">Enter Country</form:label>
	 <form:input path="billingaddress.country" id="billingaddress.country"/>
	 <br>
	 
	 <form:label path="billingaddress.zipcode">Enter Zipcode</form:label>
	 <form:input path="billingaddress.zipcode" id="billingaddress.zipcode"/>
	 <br>
	 
	 <p align="center">
	 <b>Shipping Address</b>
	 <br>
	 </p>
	 <label>Check this if Shipping Address is same as Billing Address</label>
	 <input type="checkbox" onclick="fillShippingAddress(this.form)" id="shippingsame">
	 <br>
	 <form:label path="shippingaddress.apartmentnumber">Enter Apartment Number</form:label>
	 <form:input path="shippingaddress.apartmentnumber" id="shippingaddress.apartmentnumber"/>
	 <br>
	 
	 <form:label path="shippingaddress.streetname">Enter Street Name</form:label>
	 <form:input path="shippingaddress.streetname" id="shippingaddress.streetname"/>
	 <br>
	 
	 <form:label path="shippingaddress.city">Enter City</form:label>
	 <form:input path="shippingaddress.city" id="shippingaddress.city"/>
	 <br>
	 
	 <form:label path="shippingaddress.state">Enter State</form:label>
	 <form:input path="shippingaddress.state" id="shippingaddress.state"/>
	 <br>
	 
	 <form:label path="shippingaddress.country">Enter Country</form:label>
	 <form:input path="shippingaddress.country" id="shippingaddress.country"/>
	 <br>
	 
	 <form:label path="shippingaddress.zipcode">Enter Zipcode</form:label>
	 <form:input path="shippingaddress.zipcode" id="shippingaddress.zipcode"/>
	 <br>
	 
	 <button type="submit"><b>REGISTER</b></button>
	 </form:form>
	 </div>
</body>
</html>