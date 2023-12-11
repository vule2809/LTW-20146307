<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Thống kê Nhập Xuất</title>
 </head>
<style>
body{
	background-image: url('https://speedmaint.com/wp-content/uploads/2021/04/measuring-blood-pressure.jpg');
	background-repeat: no-repeat;
	background-size: 100%;
	
}
.new-product{
	text-align: center;
	height: 33px;
 	background-color: rgba(0,245,199,0.8);
 	width: 10%;
 	display: flex;
	padding-top: 20px;
	padding-left: 3%;
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
<h3>Thống kê Nhập Xuất</h3>
<p style="color: red;">${errorString}</p>

<div class="table-product">
<table border="1" cellpadding="5" cellspacing="1" > <tr>
          <th>ID</th>
          <th>Tên</th>
          <th>Số lượng</th>
          <th>Địa Chỉ Nhập/Xuất</th>
          <th>Tình Trạng</th>
          <th>Sửa</th>
		  <th>Xóa</th>
       
       </tr>
<c:forEach items="${nhapxuatList}" var="nhapxuat" > <tr>
             <td>${nhapxuat.id}</td>
             <td>${nhapxuat.name}</td>
             <td>${nhapxuat.quantity}</td>
             <td>${nhapxuat.address}</td>
             <td>${nhapxuat.status}</td>
             <td> 
				<a href="editNhapXuatServlet?id=${nhapxuat.id}">Edit</a> </td>
<td>
<a href="deleteNhapXuatServlet?id=${nhanvien.id}">Delete</a>
</td> </tr>
       </c:forEach>
    </table>
    </div>
<a href="newNhapXuat.jsp" class="new-product">Thêm Thống Kê</a> </body>
</html>