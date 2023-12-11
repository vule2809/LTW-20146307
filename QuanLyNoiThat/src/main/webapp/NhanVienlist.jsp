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
	background-image: url('https://www.talentnet.vn/sites/default/files/images/news/Talentnet_HR%20Outsourcing%20%282%29.jpg');
	background-repeat: no-repeat;
	background-size: 100%;
	
}
.new-product{
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
	
	background-color: rgb(65, 155, 210,0.7);
	width: 598px;
}

</style>
<body>
<h3>Danh sách Nhân Viên</h3>
<p style="color: red;">${errorString}</p>

<div class="table-product">
<table border="1" cellpadding="5" cellspacing="1" > <tr>
          <th>ID</th>
          <th>Tên</th>
          <th>Năm sinh</th>
          <th>Địa chỉ</th>
          <th>Thời gian công tác</th>
          <th>Sửa</th>
		  <th>Xóa</th>
       
       </tr>
<c:forEach items="${nhanvienList}" var="nhanvien" > <tr>
             <td>${nhanvien.id}</td>
             <td>${nhanvien.name}</td>
             <td>${nhanvien.age}</td>
             <td>${nhanvien.address}</td>
             <td>${nhanvien.experience}</td>
             <td> 
				<a href="editNhanVienServlet?id=${nhanvien.id}">Edit</a> </td>
<td>
<a href="deleteNhanVienServlet?id=${nhanvien.id}">Delete</a>
</td> </tr>
       </c:forEach>
    </table>
    </div>
<a href="newNhanVien.jsp" class="new-product">Thêm Nhân Viên</a> </body>
</html>