<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Quản lý Dụng Cụ Y Tế</title>
 </head>
<style>
header{
	background-color: rgba(46, 138, 240, 0.7);
}
.title{
	padding-top: 20px;
	text-align: center;
	}
section{
	text-align: -webkit-center;
	background-image: url("https://xdcs.cdnchinhphu.vn/thumb_w/650/446259493575335936/2022/7/17/avatar1658046570850-16580465714271238339133.jpg") ;
	background-repeat: no-repeat;
	background-size: 100%;
	height: 500px;
	width: 100%;

}
h4{
	font-size:20px;
	color: red;
}
ul{
	text-align: right;
	list-style: none;
	margin-right: 7%;
	margin-top: -77px;
}
img{
	margin-left:7%}
.login,.signin{
	font-size: 30px;
}

section a {
	text-decoration: none;
	color: #000;
	font-size: 20px;
}
.nav{
	padding-top:10%;
	}
 .level1, .level2, .vp, .mos{
 	height: 33px;
 	background-color: rgba(0,245,199,0.8);
 	width: 20%;
 	display: flex;
 	justify-content: center;
	padding-top: 20px;
	color: #000;
 	 }

.level2 {
	background-color: coral;
}

.vp {
	background-color: chartreuse;
}

.mos {
	background-color: darksalmon;
}

.login-form {
	list-style: none;
	display: flex;
}

.login-form a {
	text-decoration: none;
	padding: 18px;
}

.login-form a:hover {
	background-color: gray;
	color: #fff;
}
.item_footer_right{
	margin-top: -80px;
	text-align: right;
}
 </style>
 <body>
 
 <div class="container">
 <header>
 <h1 class="title">QUẢN LÝ DỤNG CỤ Y TẾ</h1>
 <div class="logo">
 <img src="https://moh.gov.vn/documents/20182/0/ch%E1%BB%89+m%E1%BB%A5c+%281%29.jpg/0d1a9e4b-29c0-4b29-aa8b-6001a78f52fd?t=1550469174025" />
 <ul> 
 <h4>${username}</h4>
 <li><a href="LogIn.jsp" class="login">Đăng nhập</a></li> 
 <li><a href="SignIn.jsp" class="signin">Đăng ký</a></li> 
 </ul>
 </div>

 </header>
 <section>
 <div class = "nav">
 <div class="level1">
 <center><a href="ProductListServlet">Danh Mục Dụng Cụ Y Tế</a></center>
 </div>
 <div class="level2">
 <center><a href="NhanVienListServlet">Nhân Viên</a></center>
 </div>
 <div class="vp">
 <center><a href="CCPL.jsp">Căn Cứ Pháp Lý</a></center>
 </div>
 <div class="mos">
 <center><a href="#">Thống Kê Nhập Xuất</a></center>
 </div> 
 </div>
 </section> 
 </div>
 </body>
 <hr size=3px></hr>
 <footer>
	<img class="logo-footer" src="data:image/png;base64,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">
 	<div class="item_footer_right"><span style="font-size: 20px;">Giấy chứng nhận Đăng ký Kinh doanh số <b>xxxxabc</b> do <b>Cục Cảnh sát ĐKQL cư trú và DLQG về dân cư</b>. Cấp ngày 11/08/2022 </span></div>
 </footer>
</html>