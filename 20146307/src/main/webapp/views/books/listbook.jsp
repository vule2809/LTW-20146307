<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
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
	<table border="1" style="width:1000px;text-align:center">
		<thead>
			<tr>
				<th>book id</th>
				<th>isbn</th>
				<th>title</th>
				<th>publisher</th>
				<th>price</th>
				<th>description</th>
				<th>publish_day</th>
				<th>cover_image</th>
				<th>quantity</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" items="${list}">
				<tr>
					<td>${i.bookid}</td>
					<td>${i.isbn}</td>
					<td>${i.title}</td>
					<td>${i.publisher}</td>
					<td>${i.price}</td>
					<td>${i.description}</td>
					<td>${i.publishDate}</td>
					<td>${i.coverImage}</td>
					<td>${i.quantity}</td>
					<td>
					<a href='<c:url value="update?id=${i.bookid}"/>'>Update</a> or
					<a href='<c:url value="delete?title=${i.title }"/>'>Delete</a> or
					<a href='<c:url value="add"/>'>Add</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	
</body>

</html>