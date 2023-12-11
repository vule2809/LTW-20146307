<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: center">
	<table border="1" style="width: 50%; text-align: center" align="center" >
		<thead>
			<th>Name</th>
		</thead>
		<tbody>
			<c:forEach var="i" items="${listpvd}">
				<tr>
					<td>
					<!-- <img src="https://cdn.icon-icons.com/icons2/17/PNG/256/acer_2065.png" border="0" alt="Logo">  -->
					<!-- <img src='<c:url value="${i.icon}"/>' border="0" alt="Logo"> -->
					<img src="${pageContext.request.contextPath}/image/provider_img/${i.icon}" border="0" alt="Logo" style="width: 400px; height: 300px;">
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>