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
				Find products</div>

			<div class="border p-3 panel-body">
				<form action="./find.net" method="get">
					<div class="form-group row align-items-center">
						<div class="col-lg-6 col-xs-12">
							<label for="nameInput">Name</label> <input name="nameInput"
								id="nameInput" type="text" class="form-control"
								value="${model.getKeyWord() }" />
						</div>
						<div class="col-lg-2 pt-4">
							<button class="btn btn-warning">find products</button>
						</div>

					</div>

				</form>

				<div class="mt-5 container">
					<table class="table table-responsive">
						<thead>
							<tr>
								<th scop="col">id_product</th>
								<th scop="col">name</th>
								<th scop="col">price</th>
								<th scop="col">quantity</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${model.getProducts() }" var="p">
								<tr>
									<td scop="row">${p.getId() }</td>
									<td scop="row">${p.getName() }</td>
									<td scop="row">${p.getPrice() }</td>
									<td scop="row">${p.getQuantity() }</td>
									<td scop="row">
										<a href="./delete.net?id=${p.getId() }">
											<button class="btn btn-danger"> delete </button>
										</a>
									</td>
									<td>
										<a href="./update.net?id=${p.getId() }">
											<button class="btn btn-primary"> edit </button>
										</a>	
									</td>
								</tr>
							</c:forEach>


						</tbody>

					</table>
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