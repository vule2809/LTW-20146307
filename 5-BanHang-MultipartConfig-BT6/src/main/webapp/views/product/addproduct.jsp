<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD PRODUCT</title>
</head>
<body>
	
	<form action="admin-insertpro" method="post"
		enctype="multipart/form-data">
		<label>Nhap product name:</label> <input type="text" name="productName"><br> 
		<label>Nhap description:</label> <textarea name="desc" cols="5" class="form-control" style="width:99%;"></textarea><br> 
		<label>Nhap price:</label> <input type="text" name="price"><br> 
		<label>Nhap link hinh:</label> <input type="file" name="imageLink"><br> 
		<label for="category">Category:</label> 
			<select name="categoryID">
				<c:forEach items="${listcate }" var="item">
					<option value="${item.cateID}">${item.cateName}</option>
				</c:forEach>
			</select><br>
		<label>Nhap stoke:</label> <input type="text" name="stoke"><br>
		<input type="submit" value="insert product">

	</form>

</body>
</html>