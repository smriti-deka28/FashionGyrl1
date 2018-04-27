<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product</title>
</head>
<body>
<div class="container">
<h3 align="center">Update Product</h3>

<!-- update already existing product -->
<!-- this form will load with all the getter methods and then invoke all the setter methods -->

<c:url value="/admin/updateproduct" var="url"></c:url>
<!-- should have same url as in @requestmapping annotation -->

<form:form action='${url}' modelAttribute="product" role="form" enctype="multipart/form-data">
	<!-- DAO hibernate session memory, Session product will have some values, 
	but when session.update(product) is invoked, new data is inserted in the table and the table is updated -->
	<!-- if id is not present, it will throw an exception -->
	<!--p.setId(0)-->
	<form:hidden path="id"/>
	
	<div class="form-group">
	<form:label path="productname"> Enter Product Name</form:label>
	<!-- product.setProductname('Pen') -->
	<form:input path="productname" class="form-control" style="width:750px"/>
	<form:errors path="productname" cssStyle="color:red">not correct</form:errors>
	</div>

	<div class="form-group">
	<form:label path="productdescription">Enter Product Description</form:label>
	<!-- product.setProductDescription('...'), it should be written in HTML tag, but in Spring form we don't have to write these tags manually -->
	<form:textarea path="productdescription" class="form-control" style="width:750px"/> <!--  to enter more lines -->
	<form:errors path="productdescription" cssStyle="color:red"></form:errors>
	</div>
	
	<div class="form-group">
	<form:label path="quantity">Enter Quantity</form:label>
	<!-- product.setQuantity(12), again we have to convert into an integer in HTML tags, which is not needed  here -->
	<form:input path="quantity" class="form-control" style="width:750px"/>
	<form:errors path="quantity" cssStyle="color:red"></form:errors>
	</div>

	<div class="form-group">
	<form:label path="price">Enter Price</form:label>
	<!-- product.setPrice(....) -->
	<form:input path="price" class="form-control" style="width:750px"/>
	<form:errors path="price" cssStyle="color:red"></form:errors>
	</div>
	
	<div class="form-group">
	<form:label path="category">Select Category</form:label>
	<!-- form:label gives the font in bold -->
	<form:select path="category.id">
	<c:forEach items="${categories}" var="c">
	<form:option value="${c.id}">${c.categoryname}</form:option>
	</c:forEach>
	</form:select>
	</div>
	
	
	<div class="form-group">
	<form:label path="image">Upload image</form:label>
	<form:input type="file" path="image"/> <!-- type gives the choose file option -->
	</div>
	
	<input type="submit" value="Edit Product">
	
</form:form>
</div>
</body>
</html>