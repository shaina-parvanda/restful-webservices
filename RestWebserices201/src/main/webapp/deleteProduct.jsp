<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background ="background.jpg">
<h1 align="center"><b>Welcome to Online Shopping</b></h1>
<h2>Product Details</h2>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="insertProduct.jsp">Add new Product</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="retrieveProductsForward.jsp">View Products</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="deleteProductForward.jsp">Delete Product</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="updateProduct.jsp">Update Product</a>
<br>
<br>
<br>
<br>
<form>
	<c:choose>
	<c:when test ="${showList}">
		<div align="center">
			<table border="1" cellpadding="5" id="t01">
				<tr>
				<th><b>Product Id</b></th>
				<th><b>Product Name</b></th>
				<th><b>Category</b></th>
					<th><b>Price</b></th>
					<th><b>Remarks</b></th>
					<th><b>Stock Number</b></th>
					
				</tr>
				<c:forEach var="product" items="${productList}">
					<tr>
						<td><c:out value="${product.productId}" /></td>
						<td><c:out value="${product.productName}" /></td>
						<td><c:out value="${product.productCategory}" /></td>
						<td><c:out value="${product.price}" /></td>
						<td><c:out value="${product.remarks}"/></td>
						<td><c:out value="${product.stockNumber}"/></td>
						<td><a
							href="DeleteProduct?action=delete&productId=<c:out value='${product.productId}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
			</c:when>
	 <c:otherwise>
	 ${message}
	</c:otherwise>
	</c:choose>
</form>


</body>
</html>