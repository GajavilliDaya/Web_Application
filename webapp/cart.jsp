<%@page import="web_7051cem.jdbc_mysql.db_connection"%>
<%@page import="web_7051cem.data.*"%>
<%@page import="web_7051cem.model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
User_Details auth = (User_Details) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}
ArrayList<Cart_Details> crt_list = (ArrayList<Cart_Details>) session.getAttribute("crt-list");
List<Cart_Details> crt_pro = null;
if (crt_list != null) {
	Product_Data pdata = new Product_Data(db_connection.getConnection());
	crt_pro = pdata.getCartProducts(crt_list);
	double total = pdata.getTotalCartPrice(crt_list);
	request.setAttribute("total", total);
	request.setAttribute("crt_list", crt_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/header.jsp"%>
<title>E-Commerce Cart</title>
<style type="text/css">
.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
</head>
<body>
	<%@include file="includes/navigation.jsp"%>

	<div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price: $ ${(total>0)?dcf.format(total):0} </h3> <a class="mx-3 btn btn-primary" href="Check_Out">Check Out</a></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (crt_list!=null) {
					for (Cart_Details c : crt_pro) {
				%>
				<tr>
					<td><%=c.getName()%></td>
					<td><%=c.getCategory()%></td>
					<td><%= dcf.format(c.getPrice())%></td>
					<td>
						<form action="buy-now" method="post" class="form-inline">
						<input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="inc-dec?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a> 
								<input type="text" name="quantity" class="form-control"  value="<%=c.getQuan()%>" readonly> 
								<a class="btn btn-sm btn-decre" href="inc-dec?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">Buy</button>
						</form>
					</td>
					<td><a href="remove_item?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

				<%
				}}%>
			</tbody>
		</table>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>