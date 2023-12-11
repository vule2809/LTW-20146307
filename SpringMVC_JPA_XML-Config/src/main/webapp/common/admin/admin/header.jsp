<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--header-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="index.html">BOOKSTORE</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-end"
			id="navbarsExampleDefault">
			<ul class="navbar-nav m-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Trang
						Chủ <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="Books.html">Sản
						Phẩm</a></li>
			</ul>

			<form class="form-inline my-2 my-lg-0">
				<div class="input-group input-group-sm">
					<input type="text" class="form-control" placeholder="Search...">
					<div class="input-group-append">
						<button type="button" class="btn btn-secondary btn-number">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				<a class="btn btn-success btn-sm ml-3" href="cart.html"> <i
					class="fa fa-shopping-cart"></i> Cart <span
					class="badge badge-light">4</span>
				</a>
			</form>

			<c:choose>
				<c:when test="${sessionScope.account == null}">
					<div class="col-sm-6">
						<ul class="list-inline right-topbar pull-right">
							<li><a href="${pageContext.request.contextPath }/login">Đăng
									nhập</a> | <a href="${pageContext.request.contextPath }/register">Đăng
									ký</a></li>
						</ul>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-sm-6">
						<ul class="list-inline right-topbar pull-right">
							<li><a
								href="${pageContext.request.contextPath}/member/myaccount">${sessionScope.account.fullName}</a>
								| <a href="${pageContext.request.contextPath }/logout">Đăng
									Xuất</a></li>
						</ul>
					</div>
				</c:otherwise>
			</c:choose>


		</div>
	</div>
</nav>

<section class="jumbotron text-center">
	<div class="container">
		<h1 class="jumbotron-heading">E-COMMERCE BOOTSTRAP THEME</h1>
		<p class="lead text-muted mb-0">Simple theme for e-commerce buid
			with Bootstrap 4.0.0.</p>
	</div>
</section>
<!---->