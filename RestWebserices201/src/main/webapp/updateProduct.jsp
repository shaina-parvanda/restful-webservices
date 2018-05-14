<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background ="background.jpg">
<h1 align="center"><b>Welcome to Online Shopping</b></h1>
<h2>Enter Product Details To Be Updated</h2>
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
<form method="GET" action="UpdateProduct">
<table>
	<tr><td>Enter Product Id u want To Update For:</td><td> <input type="text" name="ProductId" required></td></tr>
	<tr><td>Product Name:</td><td><input type="text" name="ProductName" required></td></tr>
	<tr><td>Category:</td><td><input type="text" name="Category" required></td></tr>
	<tr><td>Price:</td><td><input type="text" name="Price" required></td></tr>
	<tr><td>Quantity:</td><td><input type="text" name="Quantity" required></td></tr>
	<tr><td>Remarks:</td><td><input type="text" name="Remarks" required></td></tr>
	<tr><td><input type="submit" value="Submit"></td></tr>
</table>
${message}
	</form>

</body>
</html>