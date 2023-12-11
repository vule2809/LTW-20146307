<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="post">
		<br>
		<label style="width:20px; position:relative; left:50px">ID:</label>
		<input type="text" name="author_id" value="${author.author_id}" readonly="readonly" style="width:320px;margin:0 1%;position:relative; left:50px">
		<br>
		<br>
		<label style="width:70px; position:relative; left:50px">Nhập tên: </label>
		<input type="text" name="author_name" value="${author.author_name}" style="width:270px;margin:0 1%;position:relative; left:50px">
		<br>
		<br>
		<label style="width:200px; position:relative; left:50px">Nhập ngày tháng năm: </label>
		<input type="text" name="date_of_birth" value="${author.date_of_birth}" style="width:180px;margin:0 1%;position:relative; left:10px">
		<label>  </label>
		<label>(yyyy-mm-dd)</label>
		<br>
		<br>
		<input type="submit" value="Update author" style="position:relative; left:200px; border-width:1px"
		onmouseover="this.style.backgroundColor = 'red';" onmouseout="this.style.backgroundColor = '#f8f9fa';">
	</form>
	<br>
</body>

</html>