<%@page import="model.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Thông tin khách hàng</title>
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
.red {
	color: red;
}
</style>

<style>
body {
	font-family: Verdana;
}

.content {
	text-align: center;
	padding: 10px;
	background-color: white;
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

.form {
	margin-top: 10px;
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
	%>

	<div class="container">
		<%
		String error = request.getAttribute("error") + "";
		error = (error.equals("null")) ? "" : error;

		String userName = request.getParameter("userName") + "";
		userName = (userName.equals("null")) ? "" : userName;

		String fullName = client.getFullName();

		String sex = client.getSex();

		String dob = client.getDob()+"";

		String clientAdress = client.getAddress();

		String shoppingAdress = client.getShoppingAdress();

		String deliveryAdress = client.getDeliveryAddress();

		String phoneNumber = client.getPhoneNumber();
		String email = client.getEmail();
		%>
		<div class="container"
			style="box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
			<div class="content">
				<h1>THÔNG TIN KHÁCH HÀNG</h1>
			</div>

			<div class="red" id="baoLoi">
				<%=error%>
			</div>
			<form class="form" action="client" method="get">
			<input type="hidden" name="action" value="change-account">
				<div class="row">
					<div class="col-sm-6">
						<h3>Tài khoản</h3>
						<div class="mb-3">
							<label for="userName" class="form-label">Tên đăng nhập<span
								class="red">*</span></label> <input type="text" class="form-control"
								id="userName" name="userName" readonly
								value="<%=client.getUserName()%>">
						</div>
						<hr />
						<h3>Thông tin khách hàng</h3>
						<div class="mb-3">
							<label for="fullName" class="form-label">Họ và tên</label> <input
								type="text" class="form-control" id="fullName" name="fullName"
								value="<%=fullName%>">
						</div>
						<div class="mb-3">
							<label for="sex" class="form-label">Giới tính</label> <select
								class="form-control" id="sex" name="sex">
								<option></option>
								<option value="Nam"
									<%=(sex.equals("Nam")) ? "selected='selected'" : ""%>>Nam</option>
								<option value="Nữ"
									<%=(sex.equals("Nữ")) ? "selected='selected'" : ""%>>Nữ</option>
								<option value="Khác"
									<%=(sex.equals("Khác")) ? "selected='selected'" : ""%>>Khác</option>
							</select>
						</div>
						<div class="mb-3">
							<label for="dob" class="form-label">Ngày sinh</label> <input
								type="date" class="form-control" id="dob" name="dob"
								value="<%=dob%>">
						</div>
					</div>
					<div class="col-sm-6">
						<h3>Địa chỉ</h3>
						<div class="mb-3">
							<label for="clientAdress" class="form-label">Địa chỉ
								khách hàng</label> <input type="text" class="form-control"
								id="clientAdress" name="clientAdress" value="<%=clientAdress%>">
						</div>
						<div class="mb-3">
							<label for="shoppingAdress" class="form-label">Địa chỉ
								mua hàng</label> <input type="text" class="form-control"
								id="shoppingAdress" name="shoppingAdress"
								value="<%=shoppingAdress%>">
						</div>
						<div class="mb-3">
							<label for="deliveryAdress" class="form-label">Địa chỉ
								nhận hàng</label> <input type="text" class="form-control"
								id="deliveryAdress" name="deliveryAdress"
								value="<%=deliveryAdress%>">
						</div>
						<div class="mb-3">
							<label for="phoneNumber" class="form-label">Điện thoại</label> <input
								type="tel" class="form-control" id="phoneNumber"
								name="phoneNumber" value="<%=phoneNumber%>">
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">Email</label> <input
								type="email" class="form-control" id="email" name="email"
								value="<%=email%>">
						</div>
						<hr />
						<div class="mb-3">
							<label for="allowLaw" class="form-label">Bạn đã kiểm tra
								<a>rất kĩ thông tin cần sửa đổi </a><span class="red">*</span>
							</label> <input type="checkbox" class="form-check-input" id="allowLaw"
								name="allowLaw" required="required">
						</div>

						<input class="btn btn-primary form-control" type="submit" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<%} %>
</body>

<script>
	function checkPassword() {
		password = document.getElementById("password").value;
		passwordAgain = document.getElementById("passwordAgain").value;
		if (password != passwordAgain) {
			document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
			return false;
		} else {
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
</script>

</html>