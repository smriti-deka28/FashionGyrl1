<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewreport" content="width=device-width,initial-scale=1">

<link rel="stylesheet" href="http://localhost:8080/Project1Frontend/Resources/Css/navbar.css">
<link rel="stylesheet" href="http://localhost:8080/Project1Frontend/Resources/Css/table.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<!-- JQuery -->
    <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
    <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet"> 
  
</head>
<title>Project</title>
</head>
<body style="background:#DBAED0">
<nav class="navbar navbar-inverse" id="nav_bar">
	<div class="container-fluid">
	<button type="button" class="navbar-toggle collapsed"
	data-toggle="collapse" data-target="#collapse-example" aria-expanded="false">
		<span class="sr-only">Toggle navigation</span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
	</button>
		<div class="navbar-header">
		<!-- mapping resources/** -> /Resources/Images/download.jpg
		/WEB-INF/Resources/Images/download.jpg  -->
		<a class="navbar-brand" href="">
		<img src='<c:url value="/Resources/Images/icon-800x800.PNG"></c:url>' alt="NIIT"  width="100px" height="60px"></a>
		</div>
			<div class="collapse navbar-collapse" id="collapse-example">
				<ul class="nav navbar-nav" id="links">
					<li><a href='<c:url value="/home"></c:url>'>Home</a></li>
					<!-- value is for DispatcherServlet
				DispatcherServlet using the value it has to find the handler method which can handle the request
				http://localhost:8080/project1frontend/all/getproducts -> DispatcherServlet -> /all/getproducts
				-> ProductController.getAllProducts() -> Service -> Dao -> Select * from ProductController 
				returns ModelAndView [model is List<Product>,view is productlist]
				/WEB-INF/views/productlist.jsp
				 -->
					<li>
					<a href='<c:url value="/all/getproducts"></c:url>'>Browse All Products</a>
					</li>
					 <security:authorize access="hasRole('ROLE_ADMIN')">
					<li>
					<a href='<c:url value="/admin/getproductform"></c:url>'>Add Product</a>
					</li>
					</security:authorize>
					
					<li class="dropdown">
						<a href="" class="dropdown-toggle" data-toggle="dropdown">Select by Category
						<b class="caret"></b></a>
						<ul class="dropdown-menu">
						<!-- Request Parameter, parameter name is in searchCondition -->
							<li>
								<a href='<c:url value="/all/searchbycategory?searchCondition=Bottom Wear"></c:url>'>Bottom Wear</a>
								<a href='<c:url value="/all/searchbycategory?searchCondition=Dress"></c:url>'>Dress</a>
								<a href='<c:url value="/all/searchbycategory?searchCondition=Hoodies"></c:url>'>Hoodies</a>
								<a href='<c:url value="/all/searchbycategory?searchCondition=Salwar"></c:url>'>Salwar</a>
								<a href='<c:url value="/all/searchbycategory?searchCondition=Saree"></c:url>'>Saree</a>
								<a href='<c:url value="/all/searchbycategory?searchCondition=Tops"></c:url>'>Tops</a>
								<a href='<c:url value="/all/searchbycategory?searchCondition=All"></c:url>'>All</a>
						    </li>
						</ul>
					</li>
					</li>
			<c:if test="${pageContext.request.userPrincipal.name==null }">
			<li><a href='<c:url value="/all/registrationform"></c:url>'>Sign Up</a></li>
			<li><a href='<c:url value="/login"></c:url>'>Sign In</a></li>
			</c:if>
			
			<li>
			<a href="<c:url value='/cart/purchasedetails'></c:url>">
			<span class="glyphicon glyphicon-shopping-cart"></span>
			</a>
			</li>
			
			<c:if test="${pageContext.request.userPrincipal.name!=null }">
			<li><a href="">Welcome ${pageContext.request.userPrincipal.name}</a></li>
			<!-- to display welcome message in the header -->
			
			<li>
			<a href='<c:url value="/j_spring_security_logout"></c:url>' class="pull-right">Logout</a>
			</li>
			
			</c:if>
			</ul>
				
			</div>
	</div>
</nav>
</body>
</html>