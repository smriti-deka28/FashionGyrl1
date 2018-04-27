<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
<!-- when document is ready, it will get executed-->
	$(document).ready(function() {
		var searchCondition = '${searchCondition}';
		$('.table').DataTable({
			"lengthMenu" : [ [ 5, 10, -1 ], [ 5, 10, "All" ] ],
			"oSearch" : {
				"sSearch" : searchCondition
			}
		})
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h4>
			<b>List Of Products</b>
		</h4>
		<!-- for iteration similar to for() in java -->
		<!-- productAttr is a model attribute, to which we have assigned List<Product>  -->
		<table class="table table-hover" border="1">
			<thead id="thead">
				<tr>
					<th>Images</th>
					<th>Product Name</th>
					<th>Category</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productsAttr}" var="p">
					<!-- items is collection of items, jstl task -->
					<tr>
						<td>
						<img src='<c:url value="/Resources/Images/${p.id}.jpg"></c:url>' alt="Image NA" height="50px" width="50px">
						</td>
						
						<!-- p.getProductName, invokes getter method -->
						<td>${p.productname}</td>
						
						<!-- p.getCategory().getCategoryname() -->
						<!-- if only category is called, then only has code is displayed -->
						<td>${p.category.categoryname}</td>
						
						<!-- p.getPrice -->
						<td>${p.price}</td>
						<!-- 
					 http://...../all/getproducts/1[
					 http://...../all/getproducts/2
					  http://...../all/getproducts/3
					   -->
						<!-- when glyphicon info sign is clicked, request will be
					    handled but the RequestMapping value 'all/getproduct/1 -->
						<td>
						<a href='<c:url value="/all/getproducts/${p.id }"></c:url>'> 
						<span class="glyphicon glyphicon-info-sign"></span>
						</a> 
				
						<security:authorize access="hasRole('ROLE_ADMIN')">
						<!-- to delete a product from admin log in -->
						<a href='<c:url value="/admin/deleteproduct/${p.id }"></c:url>'>
						<span class="glyphicon glyphicon-trash"></span>
						</a> 
						
						<!-- it will direct to ProductController page method deleteProduct()<->ProductService -> DaoImpl -->
						<!-- to update a already existing product -->
 					    <a href='<c:url value="/admin/updateproductform/${p.id }"></c:url>'>
						<span class="glyphicon glyphicon-pencil"></span>
						</a>
						</security:authorize>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>