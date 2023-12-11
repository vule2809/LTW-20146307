<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product List</title>
 </head>
<style>
body{
	background-image: url('https://speedmaint.com/wp-content/uploads/2021/04/measuring-blood-pressure.jpg');
	background-repeat: no-repeat;
	background-size: 100%;
	
}
.new-product{
	height: 33px;
 	background-color: rgba(0,245,199,0.8);
 	width: 10%;
 	display: flex;
	padding-top: 20px;
	padding-left: 20px;
	color: #000;
	margin-left:15%;
	margin-top: 30px;
}
.new-product:hover {
	background-color: gray;
	color: #fff;
}

h3{
	text-align: center;
	font-size: 40px;
}
.table-product{
	margin-left: 30%;
	
	background-color: rgb(212, 155, 65,0.7);
	width: 612px;
}

</style>
<body>
<h3>Danh sách Dụng cụ</h3>
<p style="color: red;">${errorString}</p>

<div class="table-product">
<table border="1" cellpadding="5" cellspacing="1" > <tr>
          <th>ID</th>
          <th>Tên</th>
          <th>Loại</th>
          <th>Giá</th>
          <th>Hình Ảnh</th>
          <th>Sửa</th>
		  <th>Xóa</th>
       </tr>
<c:forEach items="${productList}" var="product" > <tr>
             <td>${product.id}</td>
             <td>${product.name}</td>
             <td>${product.type}</td>
             <td>${product.price}</td>
             <td>${product.image}</td>
             <td> 
				<a href="editProductServlet?id=${product.id}">Edit</a> </td>
<td>
<a href="deleteProductServlet?id=${product.id}">Delete</a>
</td> </tr>
       </c:forEach>
    </table>
    </div>
<a href="newProduct.jsp" class="new-product">Thêm Sản Phẩm</a> </body>
</html>