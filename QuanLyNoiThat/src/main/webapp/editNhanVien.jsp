<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Sửa Nhân Viên</title>
 </head>
 <body>
 <h1>Sửa Nhân Viên</h1>
 <form method="POST" action="editNhanVienServlet" enctype="multipart/form-data">
 <table>
 <tr>
 <td>ID</td>
 <td><input type="text" name="id" value="${nhanvien.getId()}"/></td>
 </tr>
 <tr>
 <td>Tên</td>
 <td><input type="text" name="name"
value="${nhanvien.getName()}"/></td> 
 </tr>
 <tr>
 <td> Tuổi</td>
 <td><input type="text" name="age"
value="${nhanvien.getAge()}"/></td>
 </tr>
 <tr>
 <td>Địa chỉ</td>
 <td><input type="text" name="address"
value="${nhanvien.getAddress()}"/></td>
 </tr>
 <tr>
 <td>Thời gian công tác</td>
  <td><input type="text" name="experience"
value="${nhanvien.getExperience()}"/></td>
 <td colspan="2"><button>Update</button><input type="reset"></td>
 </tr>
 </table>
 </form>
 <div> 
 <h5>${thongbao}</h5> 
 
 </div>
 </body>
</html>