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
<h2>Search Products According To Range</h2>
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
<form method="GET" action="RetrieveProductsAccordingToRange">
<table>
	<tr><td>Minimum Range:</td><td> <input type="text" name="MinRange" required></td></tr>
	<tr><td>Maximum Range:</td><td> <input type="text" name="MaxRange" required></td></tr>
	<tr><td><input type="submit" value="Submit"></td></tr>
</table>
</form>
	<form method="GET" action="RetrieveProductsAccordingToRange">
	<c:choose>
	<c:when test ="${showList}">
		<div align="center">
			<table border="1" cellpadding="5" id="t01">
				<tr>
					<th><b>Product Name</b></th>
					<th><b>Price</b></th>
					<th><b>Category</b></th>
					<th><b>Remarks</b></th>
				</tr>
				<c:forEach var="product" items="${productList}">
					<tr>
						<td><c:out value="${product.productName}" /></td>
						<td><c:out value="${product.price}" /></td>
						<td><c:out value="${product.productCategory}" /></td>
						<td><c:out value="${product.remarks}"/></td>
					</tr>
				</c:forEach>
			</table>
		</div>
			</c:when>
		<c:when test ="${error}">
			${errorMessage}
		</c:when>
	 <c:otherwise>
	</c:otherwise>
	</c:choose>
	</form>

</body>
</html>