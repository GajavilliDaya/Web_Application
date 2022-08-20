<%@page import="web_7051cem.jdbc_mysql.db_connection"%>
<%@page import="web_7051cem.data.Product_Data" %>
<%@page import="web_7051cem.model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<% User_Details auth =(User_Details) request.getSession().getAttribute("auth");
if(auth!=null){request.setAttribute("auth",auth);}
%>
<% Product_Data pd = new Product_Data(db_connection.getConnection());
List<Product_Details> product_details = pd.getAllProducts();

ArrayList<Cart_Details> crt_list = (ArrayList<Cart_Details>) session.getAttribute("cart-list");
if (crt_list != null) {
	request.setAttribute("cart_list", crt_list);
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Computer For You</title>

</head>
<body>
<%@include file="includes/navigation.jsp"%>
<div class="container">
	<div class="card-header my-3">All Products</div>
	<div class="row">
	<% if(!product_details.isEmpty()){for(Product_Details p:product_details){%>
		<div class="col-md-3 my-4">
		<div class="card w-100">
			<img class="card-img-top" src="Images/<%=p.getImg() %>"
			alt="Card image cap">

	<div class="card-body">
		<h5 class="card-title"><%=p.getName() %></h5>
		<h6 class="price">Price: $<%=p.getPrice() %></h6>
		<h6 class="category">Category: <%=p.getCategory() %></h6>
		<div class="mt-3 d-flex justify-content-between">
		<a class="btn btn-success" src="Images/cart.jpg" href="cart-servlet?id=<%=p.getId()%>">Add to Cart</a>
		<a class="btn btn-primary" href="buy-now?quantity=1&id=<%=p.getId()%>">Buy Now</a>
		</div>
	</div>

		</div>
	</div><% }} %>


</div>
</div>
	
	<%@include file="/includes/footer.jsp"%>
</body>
</html>
