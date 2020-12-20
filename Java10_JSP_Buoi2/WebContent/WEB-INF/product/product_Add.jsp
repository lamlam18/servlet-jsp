<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js" integrity="sha256-MAgcygDRahs+F/Nk5Vz387whB4kSK9NXlDN3w58LLq0=" crossorigin="anonymous"></script>
<title>Add new product</title>
</head>
<body>
	<div class="container bg-light shadow mx-auto pb-5">
		<h3 class="text-info text-center mt-5 pt-2">Add new product</h3>
		<div class="container w-50 p-4 mb-4 shadow rounded">
			<%-- đặt đg dẫn khi ấn submit dẫn tới doPost với url là /product/add --%>
			<%String path = request.getContextPath(); %>
			<%
					String message = (String) request.getAttribute("message");
				%>
				<%
					if (message != null) {
				%>
				<p class="text-danger"><%=message%></p>
				<%
					}
				%>
			<form method="POST" action="<%=path%>/product/add">
				<div class="form-group">
			    <label class="text-info" for="id">Product id</label>
			    <input type="text" class="form-control" name="productId" id="id">
			  </div>
			  <div class="form-group">
			    <label class="text-info" for="name">Product name</label>
			    <input type="text" class="form-control" name="productName" id="name">
			  </div>
			  <div class="form-group">
			    <label class="text-info" for="code">Product code</label>
			    <input type="text" class="form-control" name="productCode" id="code">
			  </div>
			  <div class="form-group">
			    <label class="text-info" for="description">Description</label>
			    <textarea rows=2 type="number" class="form-control" name="productDescription" placeholder="Enter Product Code" id="description">
			    
			    </textarea>
			  </div>
			  <div class="form-group">
			    <label class="text-info" for="price">Price</label><br>
			    <input class="w-25" type="number" class="form-control" name="productPrice" id="price">
			  </div>
			  <div class="form-group mt-2">
			  	<button  type="submit" class="btn btn-info w-50 mx-auto">Add</button>
			  </div>
		
			</form>
		</div>
	</div>
</body>
</html>