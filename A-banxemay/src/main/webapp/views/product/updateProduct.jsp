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
	<form action="update" method="post">
		<label>ID:</label> <br>
		<label>Ten xe:</label> <input type="text" name="productName"><br>
		<label>Hang xe:</label> <input type="text" name="brand"><br>
		<label>Nam san xuat:</label> <input type="text" name="year"><br>
		<label>Mau xe:</label> <input type="text" name="color"><br>
		<label>Gia ca:</label> <input type="text" name="price"><br>
		<label>Mo ta xe:</label> <textarea name="description" cols="5" class="form-control" style="width:99%;"></textarea><br> 
		<input type="submit" value="update">
	</form>

</body>
</html>