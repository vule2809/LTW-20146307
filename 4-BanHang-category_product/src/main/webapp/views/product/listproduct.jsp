<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="width: 100%">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Desc</td>
			<td>Price</td>
			<td>Imagelink</td>
			<td>CategoryID</td>
			<td>SellerID</td>
			<td>Amount</td>
			<td>Stoke</td>
			<td>Action</td>
		</tr>
		<c:forEach var="item" items="${listpro}">
			<tr>
				<td>${item.productID}</td>
				<td>${item.productName}</td>
				<td>${item.desc}</td>
				<td>${item.price}</td>
				<td>${item.imageLink}</td>
				<td>${item.categoryID}</td>
				<td>${item.sellerID}</td>
				<td>${item.amount}</td>
				<td>${item.stoke}</td>
				<td>
					<a href='<c:url value="/product/update?id=${item.productID}" /> '>Update</a>||
					<a href='<c:url value="/product/delete?id=${item.productID}" /> '>Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>