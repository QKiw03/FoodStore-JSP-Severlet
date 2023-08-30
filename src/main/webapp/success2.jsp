<%@page import="model.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký thành công</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>

<style>
.custom-button-style {
	background-color: #0bd6cc;
	color: #ffffff;
}
</style>
</head>

<body>
	<div class="container my-5">
		<div
			class="position-relative p-5 text-center text-muted bg-body border border-dashed rounded-5">
			<svg class="bi mt-5 mb-3" width="48" height="48">
  <use xlink:href="#check2-circle"></use>
  <image href="img/check.png" width="48" height="48" />
</svg>
			<h1 style="font-weight: bold; color: #20bf55;">Thay đổi thông tin thành công</h1>
			<p class="col-lg-6 mx-auto mb-4">
				<h4>Chúc mừng bạn đã thay đổi thành công tài khoản tại <span style="font-weight: bold; color: orange;">Food Store</span><br> 
				Đợi một chút để quay lại với Food Store và mua những món đồ ưa thích nhaaaa!
				</h4>
			</p>
			<a class="btn custom-button-style"
				style="white-space: nowrap; margin-left: 10px; margin-right: 16px"
				href="index.jsp">Đi tới Trang Chủ</a>
		</div>
	</div>
	<script>
		setTimeout(function() {
			window.location.href = 'index.jsp';
		}, 6000);
	</script>
</body>
</html>