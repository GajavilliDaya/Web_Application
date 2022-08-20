<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="web_7051cem.model.*" %>
<% User_Details auth =(User_Details) request.getSession().getAttribute("auth");
if(auth!=null){request.setAttribute("auth",auth);}
%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="web_7051cem.data.Order_Data"%>
<%@page import="web_7051cem.jdbc_mysql.db_connection"%>
<%@page import="web_7051cem.model.*"%>
<%@page import="java.util.*"%>

<% DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
List<Buy> orders=null;
if (auth != null) {
	request.setAttribute("person", auth);
	Order_Data oDao  = new Order_Data(db_connection.getConnection());
	 //oDao =Buy.userOrder(auth.getId());
	}else{response.sendRedirect("login.jsp");}

ArrayList<Cart_Details> crt_list = (ArrayList<Cart_Details>) session.getAttribute("cart-list");
if (crt_list != null) {request.setAttribute("cart_list", crt_list);}
	%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/header.jsp"%>
<title>E-Commerce Cart</title>
</head>
<body>
	<%@include file="includes/navigation.jsp"%>
	<div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			
			<%
			if(orders!= null){
				for(Buy o : orders){%>
					<tr>
						<td><%=o.getDate() %></td>
						<td><%=o.getName() %></td>
						<td><%=o.getCategory() %></td>
						<td><%=o.getQuan() %></td>
						<td><%=dcf.format(o.getPrice()) %></td>
						<td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%=o.getO_id()%>">Cancel Order</a></td>
					</tr>
				<%}
				}%>
			
			</tbody>
		</table>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
</html>