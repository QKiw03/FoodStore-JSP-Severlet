<%@page import="model.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đổi mật khẩu</title>
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
	<%
	Object obj = session.getAttribute("client");
	Client client = null;
	if (obj != null)
		client = (Client) obj;
	if (client == null) {
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống, vui lòng quay lại trang chủ</h1>

	<%
	} else {
		String error = request.getAttribute("error") + "";
		if (error.equals("null")) {
		error = "";
		}
	%>
	<div class="container">
		<div class="col-md-4 offset-md-3">
			<div class="d-flex justify-4ontent-center align-items-center"
				style="min-height: 30vh;">
				<div>
					<img src="img/logo.png" alt="" width="200">
				</div>
			</div>


			<!-- form card change password -->
			<div class="card card-outline-secondary">
				<div class="card-header">
					<h3 class="mb-0">Đổi mật khẩu</h3>
				</div>
				<span style="color: red"> <%=error%>
				</span>
				<div class="card-body">
					<form class="form" role="form" autocomplete="off"
						action="client" method="POST">
						<input type="hidden" name="action" value="change-password">
						<div class="form-group">
							<label for="passCurrent">Nhập mật khẩu hiện tại</label> <input
								type="password" class="form-control" id="passCurrent"
								name="passCurrent" required="required">
						</div>
						<div class="form-group">
							<label for="passNew">Mật khẩu mới</label> <input type="password"
								class="form-control" id="passNew" required="required"
								name="passNew"> <span class="form-text small text-muted">
								Mật khẩu phải có ký tự và <em>không</em> chứa khoảng trống.
							</span>
						</div>
						<div class="form-group">
							<label for="passNewVerify">Nhập lại</label> <input
								type="password" class="form-control" id="passNewVerify"
								required="required" name="passNewVerify"> <span
								class="form-text small text-muted"> Để xác nhận, hãy nhập
								lại mật khẩu mới. </span>
						</div>
						<div class="form-group d-flex justify-content-center">
							<button type="submit" class="btn btn-success btn-lg">Thay
								đổi</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>