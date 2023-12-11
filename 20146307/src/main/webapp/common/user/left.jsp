<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/common/taglib.jsp"%>

<style>
	.active{
		background-color: #0062cc;
		color: #ffffff;
	}
</style>

	<c:forEach var="item" items="${list}">
		<%-- <c:forEach var="item1" items="${countCID}">
			<c:if test="${item1.categoryID == item.cateID && item1.total != 0 }">
				<a href='<c:url value="/listprocate?cateid=${item.cateID}"/>'>
					<span class="${setactive == item.cateID?'active':'' }">${item.cateName}</span>
				</a>
				<br>
				
			</c:if>
		</c:forEach> --%>
		<%-- <a href="#">${item.coverImage}</a> <br> --%>
		<%-- <a href='<c:url value="/listprocate?cateid=${item.coverImage}"/>'> --%>
	</c:forEach>