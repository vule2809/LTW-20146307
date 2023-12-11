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
	<c:if test="${message!=null}"> <span>${massage}</span> </c:if>
	<c:if test="${error!=null}"> <span>${error}</span> </c:if>
	<table border="1" style="width: 700px">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Icon</td>
			<td>Action</td>
		</tr>
		<tr>
			<c:forEach var="item" items="${list}">
				<td>${item.cateID}</td>
				<td>${item.cateName}</td>
				<td>${item.image}</td>
				<td>
				<a href='<c:url value="/category/update?id=${item.cateID}" /> '>Update</a> || 
				<a href='<c:url value="/category/delete?id=${item.cateID}" /> '>Delete</a>
				</td>
		</tr>
			</c:forEach>
		
	</table>
	<form action="add" >
		<input type="submit" value="Add">
	</form>
</body>
</html>