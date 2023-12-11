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

	<c:if test="${message != null}">
		<span>${message}</span>
	</c:if>
	<c:if test="${error != null}">
		<span>${error}</span>
	</c:if>
	<table border="1" style="width:100%">
		<thead>
			<tr>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.coverImage}</td>
					<td>
					<a>Tiêu đề: ${item.title}</a> <br>
					<a>Mã ISBN: ${item.isbn}</a> <br>
					<a>Tác giả: ${item.publisher}</a> <br>
					<a>Publisher: ${item.publisher}</a> <br>
					<a>Publisher_date: ${item.publishDate}</a> <br>
					<a>Quantity: ${item.quantity}</a> <br>
					<a href="" style="text-decoration:none; color:blue">Review:(${item.quantity}) </a> <br>
					</td>
					
				</tr>
			</c:forEach>
		</tbody>

	</table>
<br>
<a href="http://localhost:8080/20146422/admin/books">
	<input type="submit" value="Go to admin page" style="width:150px;position:relative;left:480px;border-width:1px" 
		onmouseover="this.style.backgroundColor = 'red';" onmouseout="this.style.backgroundColor = '#f8f9fa';">
	<br>
	</a>
</body>
</html>