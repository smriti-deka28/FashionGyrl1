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

<div class="container">
<h3 align="center">Add Product</h3>

<!-- using spring form tag, create a form to get input for product -->
<!-- this form will load with all the getter methods and then invoke all the setter methods -->

<c:url value="/admin/saveproduct" var="url"></c:url>
<!-- should have same url as in @requestmapping annotation, in ProductController-->
<form:form action='${url}' modelAttribute="product" role="form" enctype="multipart/form-data">
	<!-- product=new Product() -->
	<!-- product will be the representation of all the properties below, in the Controller class, or the handler method -->
	<!-- hidden field id for product id, the product Id will be inserted automatically, 
	giving a default id as the id, just next to the last updated value-->  
	<!--p.setId(0)-->
	<form:hidden path="id"/>
	
	<div class="form-group">
	<form:label path="productname"> Enter Product Name</form:label>
	<!-- product.setProductname('Pen') -->
	<form:input path="productname" class="form-control" style="width:750px"/>
	<form:errors path="productname" cssStyle="color:red"></form:errors><!-- default message is "may not be empty" -->
	<!-- User defined message can be added in Product.java -->
	<!-- path should be the name of the property -->
	
	</div>

	<div class="form-group">
	<form:label path="productdescription">Enter Product Description</form:label>
	<!-- product.setProductDescription('...'), it should be written in HTML tag, but in Spring form we don't have to write these tags manually -->
	<form:textarea path="productdescription" class="form-control" style="width:750px"/> <!--textarea= to enter more lines-->
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
	<!-- product.setCategory().setId(100) -->
	<!-- category is the property name in the Product.java -->
	<!-- FK(cid) in Product table, category.setId(100)-->
	<!-- this category list is static now -->
	<form:label path="category">Select Category</form:label>
	<!-- form:label gives the font in bold -->
	<form:select path="category.id">
	<c:forEach items="${categories}" var="c">
	<form:option value="${c.id}"> ${c.categoryname}</form:option>
	</c:forEach>
	</form:select>
	</div>
	
	<div class="form-group">
	<form:label path="image">Upload image</form:label>
	<form:input type="file" path="image"/> <!-- type gives the choose file option -->
	</div>

	<input type="submit" value="Add Product">
	
</form:form>
</div>
</body>
</html>