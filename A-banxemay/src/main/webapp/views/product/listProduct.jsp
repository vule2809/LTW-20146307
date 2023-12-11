<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
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
			<td>Brand</td>
			<td>Year</td>
			<td>Color</td>
			<td>Price</td>
			<td>Description</td>
			<td>Action</td>
		</tr>
		<c:forEach var="item" items="${listpro}">
			<tr>
				<td>${item.productID}</td>
				<td>${item.productName}</td>
				<td>${item.brand}</td>
				<td>${item.year}</td>
				<td>${item.color}</td>
				<td>${item.price}</td>
				<td>${item.description}</td>
				<td><a
					href='<c:url value="/product/update?id=${item.productID}" /> '>Update</a>||
					<a href='<c:url value="/product/delete?id=${item.productID}" /> '>Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action="add">
		<input type="submit" value="Add">
	</form>
</body>
</html>