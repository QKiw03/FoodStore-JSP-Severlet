<%@page import="model.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Store</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
	crossorigin="anonymous"></script>

<style>
.custom-button-style {
	background-color: #0bd6cc;
	color: #ffffff;
}

.logo-image {
	height: 50px; /* Điều chỉnh chiều cao dựa trên yêu cầu */
	width: auto;
	margin-left: 0px;
	margin-top: 0px;
	margin-bottom: 0px;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg bg-body-tertiary"
		style="background-color:;">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp"> <img alt="Logo"
				src="img/logo.png" class="logo-image">
			</a>



			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#" style="font-size: 18px">Trang chủ</a></li>
					<li class="nav-item"><a class="nav-link" href="#"
						style="font-size: 18px">Combo Thần thánh</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"
						style="font-size: 18px">Loại hàng</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Nước uống</a></li>
							<li><a class="dropdown-item" href="#">Bánh</a></li>
							<li><a class="dropdown-item" href="#">Đồ ăn vặt</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled"
						aria-disabled="true">Chưa mở</a></li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search"
						placeholder="Nhập sản phẩm cần tìm" aria-label="Search"
						style="width: 220px;">
					<button class="btn btn-outline-success" type="submit">Tìm</button>

					<%
					Object obj = session.getAttribute("client");
					Client client = null;
					if (obj != null) {
						client = (Client) obj;
					}
					if (client == null) {
					%>
					
					<a class="btn custom-button-style"
						style="white-space: nowrap; margin-left: 10px; margin-right: 16px"
						href="login.jsp"> Đăng nhập</a>
					<%
					} else {
					%>
					<div style="margin-left: 10px;">
						<div class="flex-shrink-0 dropdown">
							<a href="#"
								class="d-block link-body-emphasis text-decoration-none dropdown-toggle"
								data-bs-toggle="dropdown" aria-expanded="false"> <img
								src="img/avt.png" alt="mdo" width="32" height="32"
								class="rounded-circle">
							</a>
							<ul class="dropdown-menu text-small shadow"
								style="left: -120px; right: auto; top: 40px">
								<li><a class="dropdown-item" href="changeaccount.jsp">Tài khoản</a></li>
								<li><a class="dropdown-item" href="#">Đơn hàng</a></li>
								<li><a class="dropdown-item" href="#">Thông báo</a></li>
								<li><a class="dropdown-item" href="changepassword.jsp">Đổi mật khẩu</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="logout">Đăng xuất</a></li>
							</ul>

						</div>
					</div>
					<%
					}
					%>

				</form>
			</div>
		</div>
	</nav>

	<!-- Page content -->
	<div class="container mt-3">
		<div class="row">
			<!-- Menu left -->
			<div class="col-lg-3">
				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-action"
						style="background-color: #f8f9fa;">
						<h5 style="color: #60b1cc;">Đồ ăn nhanh</h5>
					</a> <a href="#" class="list-group-item list-group-item-action"
						style="background-color: #f8f9fa;">
						<h5 style="color: #60b1cc;">Đồ ăn ít calo</h5>
					</a> <a href="#" class="list-group-item list-group-item-action"
						style="background-color: #f8f9fa;">
						<h5 style="color: #60b1cc;">Khác</h5>
					</a>
				</div>
			</div>
			<!-- End Menu left -->

			<!-- Slider and Products -->
			<div class="col-lg-9">
				<!-- Slider -->
				<div id="carouselExampleIndicators" class="carousel slide mb-4"
					data-bs-ride="true">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="img/slide/2.png" class="d-block w-100" alt="..."
								style="height: 250px">
						</div>
						<div class="carousel-item">
							<img src="img/slide/1.png" class="d-block w-100" alt="..."
								style="height: 250px">
						</div>
						<div class="carousel-item">
							<img src="img/slide/3.png" class="d-block w-100" alt="..."
								style="height: 250px">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
				<!-- End Slider -->
				<!-- Products -->
				<div class="row">
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"> <img class="card-img-top"
								src="img/product/1.png" alt="">
							</a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Bánh quế</a>
								</h4>
								<h5>450.000</h5>
								<p class="card-text">Ăn vào thì ngon thôi rồiiii</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" src="img/product/4.png"
								alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Cà phê sữa</a>
								</h4>
								<h5>660.000</h5>
								<p class="card-text">Mua 1 tặng 1 tính tiền 2</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>


					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" src="img/product/2.png"
								alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Donuts</a>
								</h4>
								<h5>230.000</h5>
								<p class="card-text">Kẹo này thì mùa nào chả ăn được</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" src="img/product/3.png"
								alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Kem ốc</a>
								</h4>
								<h5>250.000</h5>
								<p class="card-text">Ăn vào không sợ gầy</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" src="img/product/5.png"
								alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Nước dưa hấu</a>
								</h4>
								<h5>450.000</h5>
								<p class="card-text">Ăn vào thì da đẹp như chủ shop</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" src="img/product/6.png"
								alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Trứng chiên</a>
								</h4>
								<h5>450.000</h5>
								<p class="card-text">Đồ ăn này shop đánh giá là ngon</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
				</div>
				<!-- End Products -->
			</div>
			<!-- End Slider and Products -->
		</div>
	</div>
	<!-- End Page content -->


	<!-- Footer --->
	<div class="container">
		<footer
			class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
			<div class="col-md-4 d-flex align-items-center">
				<a href="index.jsp"
					class="mb-3 me-2 mb-md-0 text-body-secondary text-decoration-none lh-1">
					<img src="img/logo.png" alt="Logo" width="30" height="30"
					class="me-2">
				</a> <span class="mb-3 mb-md-0 text-body-secondary">© 2023
					AnCangChungMinh, Inc</span>
			</div>


			<ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
				<li class="ms-3"><a class="text-body-secondary" href="#"><img
						src="img/contact/email.png" alt="Email" width="40"></a></li>
				<li class="ms-3"><a class="text-body-secondary" href="#"><img
						src="img/contact/instagram.png" alt="Instagram" width="39"></a></li>
				<li class="ms-3"><a class="text-body-secondary" href="#"><img
						src="img/contact/facebook.png" alt="Facebook" width="38"></a></li>
			</ul>

		</footer>
	</div>


</body>
</html>