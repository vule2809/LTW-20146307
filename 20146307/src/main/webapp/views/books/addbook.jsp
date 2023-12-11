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
	<form action="add" method="post">
		<br>
		<label style="width:150px;margin:0 1%; position:relative; left:30px">Nhập isbn: </label>
		<input type="text" name="isbn"  style="width:280px;margin:0 1%;position:relative;left:30px">
		<br>
		<br>
		<label style="width:150px;margin:0 1%; position:relative;left:30px">Nhập title: </label>
		<input type="text" name="title"  style="width:280px;margin:0 1%;position:relative;left:30px">
		<br>
		<br>
		<label style="width:150px;margin:0 1%; position:relative;left:30px">Nhập publisher: </label>
		<input type="text" name="publisher"  style="width:280px;margin:0 1%;position:relative;left:30px">
		<br>
		<br>
		<label style="width:150px;margin:0 1%; position:relative;left:30px">Nhập price: </label>
		<input type="text" name="price"  style="width:280px;margin:0 1%;position:relative;left:30px">
		<br>
		<br>
		<label style="width:150px;margin:0 1%; position:relative;left:30px">Nhập mô tả: </label>
		<input type="text" name="description"  style="width:280px;margin:0 1%;position:relative;left:30px">
		<br>
		<br>
		<label style="width:150px;margin:0 1%; position:relative;left:30px">Nhập publish day: </label>
		<input type="text" name="publishDate"  style="width:280px;margin:0 1%;position:relative;left:30px">
		<br>
		<br>
		<label style="width:150px;margin:0 1%; position:relative;left:30px">Nhập link image: </label>
		<input type="text" name="coverImage"  style="width:280px;margin:0 1%;position:relative;left:30px">
		<br>
		<br>
		<label style="width:150px;margin:0 1%; position:relative;left:30px">Nhập số lượng: </label>
		<input type="text" name="quantity"  style="width:280px;margin:0 1%;position:relative;left:30px">
		<br>
		<br>
		<input type="submit" value="Add book" style="width:150px;margin:0 50%;position:relative;left:-80px; border-width:1px" 
		onmouseover="this.style.backgroundColor = 'red';" onmouseout="this.style.backgroundColor = '#f8f9fa';">
		
	</form>
	<br>
</body>

</html>