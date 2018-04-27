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
<div>
	<div>
		<a href="<c:url value='/cart/clearcart'></c:url>" class ="btn btn-danger" pull-left>
			<span class="glyphicon glyphicon-remove-sign"></span>
				Clear Cart
		</a>

		<a href="<c:url value='/cart/checkout'></c:url>" class="btn btn-success pull-right">
		<span class="glyphicon glyphicon-shopping-cart"></span>Check out
		</a>
		<table class="table table-striped">
			<thead id ="thead">
				<tr>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Total price</th>
					<th>Remove</th>
				</tr>
			</thead>
			
			<!-- double grandtotal=0 -->
			<c:set var="grandTotal" value="0"></c:set>
			
			<tbody id="tbody">
				<c:forEach items="${cartItems }" var="cartItem">
					<tr>
					<td>${cartItem.product.productname }</td>
					<td>${cartItem.quantity }</td>
					<td>${cartItem.totalPrice }</td>
					<td><a href='<c:url value="/cart/deletecartitem/${cartItem.cartitemid }"></c:url>' class="label label-danger">
					<span class="glyphicon glyphicon-remove" ></span>Remove
					</a></td>
					<td></td>
<!--  grandTotal = cartItem.totalPrice + grandTotal -->

					<c:set var="grandTotal" value="${grandTotal + cartItem.totalPrice }"></c:set>
					</tr>
					</c:forEach>
				</tbody>
			</table>
	Total Price : ${grandTotal }
</div>

</div>
</body>
</html>






</div>
</div>

</body>
</html>