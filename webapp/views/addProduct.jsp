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
				insert products</div>

			<div class="border p-3 panel-body">
				<form action="./insert.net" method="post" >
					<div class="from-group row mt-3">
						
						<label class="col-sm-2 col-form-label">full name :</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" name="name" placeholder="product name" required="required"/>	
						</div>
					</div>
					<div class="from-group row mt-3">
						
						<label class="col-sm-2 col-form-label">price :</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" name="price"
								placeholder="product price" required="required" />
						</div>
					</div>
					<div class="from-group row mt-3">
						
						<label class="col-sm-2 col-form-label">quantity in stock :</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" name="quantity" placeholder="product quantity" required="required"/>	
						</div>
					</div>
					<div class="d-flex justify-content-end mt-3">
						<button class="btn btn-warning">Add product</button>
					</div>
				</form>
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