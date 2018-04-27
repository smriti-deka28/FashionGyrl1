<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class= "container">
<div class="panel panel-info" style="width:450px">
<div class="panel-heading"><b><h3>Product Details</h3></b></div>
<div class="panel-body">
<c:url value="/cart/addtocart/${product.id }" var="url"></c:url>
			<form action="${url }" >
<table>
<tr>
<td>
<!-- product.getProductName() -->
<b>Product Name</b>:${product.productname}<br>
<b>Category Name</b>:${product.category.categoryname}<br>
<b>Product Description</b>:${product.productdescription}<br>
<b>Price</b>:${product.price }<br>
<b>Quantity</b>:${product.quantity}<br>
</td>
<td>
<img src='<c:url value="/Resources/Images/${product.id }.jpg"></c:url>' height="200px" width="200px">
</td>
</table>
<c:if test="${product.quantity==0 }">
				<button class="btn btn-warning" disabled>Out Of Stock</button>
				</c:if>
				
				<c:if test="${product.quantity!=0 }">
				<security:authorize access="hasRole('ROLE_USER')">
				<!-- if you submit, insert into cartitem values (?,quantity,totalprice,product,user) -->
				Enter quantity:<input type="number" value="1" name="requestedQuantity" min="1" max="${product.quantity }"><br>
			  <button type="submit" class="btn btn-info button btn-lg"><span class="glyphicon glyphicon-shopping-cart" ></span>Add to cart</button>
			  </security:authorize>
			 </c:if>
			 </form>
</div>
</div>
</div>
<!-- goes back to the /all/products page from Product description page -->
<a href='<c:url value="/all/getproducts"></c:url>'><b>Back</b></a>

</body>
</html>