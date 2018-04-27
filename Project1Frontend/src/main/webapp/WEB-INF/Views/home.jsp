<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<div class="container-fluid">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide home-image" src='<c:url value="/Resources/Images/colored-paper-shopping-bags-online-shop-text-white-background-44092868.jpg"></c:url>' alt="First Slide" position="absolute" height="50%" width="90%">
			</div>
		<div class="item">
			<img class="second-slide home-image" src='<c:url value="/Resources/Images/different-elements-for-online-shopping_1085-848.jpg"></c:url>' alt="Second Slide" height="50%" width="90%">
			</div>
			<div class="item">
				<img class="third-slide home-image" src='<c:url value="/Resources/Images/fond-en-ligne-de-vecteur-d-achats-ic-nes-et-sym-plats-de-commerce-électronique-54562089.jpg"></c:url>' alt="Third Slide" height="50%" width="90%">
			</div>
			<div class="item">
					<img class="forth-slide home-image" src='<c:url value="/Resources/Images/boutique-en-ligne-illustration-vecteur-ecommerce-illusustration_1085-847.jpg"></c:url>' alt="Fourth Slide" height="50%" width="90%">
				</div>
			</div>
		<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- /.Carousel -->
</div>
</body>
</html>