<%@page contentType="text/html" pageEncoding="UTF-8"%> <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; 
charset=UTF-8"> <title>Thêm Nhân viên</title>
</head> <body>
<h1>Thêm nhân viên</h1>
<form method="POST" action="newNhanVienServlet" enctype="multipart/form-data"> <table>
<tr>
<td>ID</td>
<td><input type="text" name="ID"/></td>
</tr> 
<tr>
<td>Tên nhân viên</td>
<td><input type="text" name="Name"/></td> 
</tr>
<tr>
<td>Tuổi</td>
<td><input type="text" name="Age"/></td>
 
</tr> 
<tr>
<td>Địa Chỉ</td>
<td><input type="text" name="Address"/></td> 
</tr>
<tr>
<td>Thời gian công tác</td>
<td><input type="text" name="Experience"/></td> 
</tr> <tr>
<td colspan="2"><button>Submit</button><input type="reset"></td> 
</tr>
</table> </form> <div>
<h5>${thongbao}</h5>
</div> </body>
</html>