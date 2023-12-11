<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Free Bootstrap 4 Ecommerce Template</title>
    <!-- CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <link href='<c:url value="/templates/user/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

<%@ include file = "/common/admin/header.jsp" %>
	
	<div class="container">
		<table border="1" style="width:600px; text-align:left" align="center">
			<tr>
				<td><decorator:body></decorator:body></td>
				<%-- <td><%@ include file = "/common/admin/right.jsp" %></td> --%>
			</tr>
		</table>
		<br>
	</div>
	
	<%@ include file = "/common/admin/footer.jsp" %>

</body>
</html>