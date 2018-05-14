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
<h2>Enter Product Details</h2>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="buy.jsp">Buy a Product</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="retrieveProductsOnRange.jsp">Products according to Range</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="retrieveProductsOnCategory.jsp">Products according to Category</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<br>
<br>
<br>
<br>
<form method="GET" action="BuyProduct">
<table>
	<tr><td>Product Id:</td><td> <input type="text" name="ProductId" required></td></tr>
	<tr><td>Quantity:</td><td><input type="text" name="Quantity" required></td></tr>
	<tr></tr>
	<tr><td><input type="submit" value="Submit"></td></tr>
</table>
${message}
	</form>
</body>
</html>