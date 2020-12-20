<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="cybersoft.java10.model.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js"
	integrity="sha256-MAgcygDRahs+F/Nk5Vz387whB4kSK9NXlDN3w58LLq0="
	crossorigin="anonymous"></script>
<title>Product Page</title>
</head>
<body class="bg-light">

	<div class="container bg-light mx-auto shadow p-5 mt-5">

		<%
			String path = request.getContextPath();
		%>
		<h1 class="text-info text-center">Product List</h1>

		<div class="container w-25 float-left mb-2">
			<a href="<%=path%>/product/add" class="btn btn-info text-white">Add
				new product</a>
		</div>

		<%--Product table --%>

		<table class="table border shadow ">
			<thead class="pl-2">
				<tr class="table-light text-center">
					<th>Id</th>
					<th>Name</th>
					<th>Code</th>
					<th>Description</th>
					<th>Price</th>
					<th />
				</tr>
			</thead>
			<tbody class="pl-2">

				<%-- Product lists --%>
				
				<%
					List<Product> products = (List<Product>) request.getAttribute("products");
				%>
				<%
					for (Product product : products) {
				%>
				<tr class="text-center">
					<td><%=product.id%></td>
					<td><%=product.name%></td>
					<td><%=product.code%></td>
					<td><%=product.description%></td>
					<td><%=product.price%></td>
					<td><a href="<%=path%>/product/edit?id=<%=product.id%>" class="btn btn-outline-warning btn-sm">Edit</a>
						<a href="<%=path%>/product/delete?id=<%=product.id%>"
						class="btn btn-outline-danger btn-sm">Delete</a></td>
				</tr>
				<%
					}
				%>




				<%-- end Product lists --%>

			</tbody>
		</table>

	</div>

</body>
</html>