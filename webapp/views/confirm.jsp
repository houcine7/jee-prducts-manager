<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous" />
<title>Product Manager</title>
</head>
<body>
    <!--  include header -->
	<%@include file="navBar.jsp" %>
	 <!--  include header -->
	<section class="container center-block mt-5">
		<div class="panel">
			<div
				class="panel-heading bg-warning p-2 text-center rounded font-weight-bold">
				You have just added one product :</div>

			<div class="border p-3 panel-body">
				<div class="row">
					<div class="col-lg-2">
						<p> Id product :</p>
					</div>
					<div class="col-lg-4">
						<b> ${product.getId()}</b>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-2">
						<p> name product :</p>
					</div>
					<div class="col-lg-4">
						<b> ${product.getName()}</b>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-2">
						<p> quantity product :</p>
					</div>
					<div class="col-lg-4">
						<b> ${product.getQuantity()}</b>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-2">
						<p> price product :</p>
					</div>
					<div class="col-lg-4">
						<b> ${product.getPrice()}</b>
					</div>
				</div>
				
			<div class="d-flex justify-content-end btn-block">
				<a href="./insert.net">
					<button class="btn btn-warning w-30" style="width: 100px">
						OK
					</button>
				</a>
				
			</div>
			</div>
		</div>
	</section>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
		integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>