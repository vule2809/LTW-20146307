<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>THÊM HÃNG XE</title>
</head>
<body>
	<form action="add" method="post">
			<label>Nhap category name:</label>
			<input type="text" name="cateName"><br>
			<label>Nhap link icon:</label>
			<input type="text" name="image"><br>
			
			<input type="submit" value="Add">
	
	</form>

</body>
</html>