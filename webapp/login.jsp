<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="web_7051cem.model.*" %>
<%@page import="java.util.*" %>
<% User_Details auth =(User_Details) request.getSession().getAttribute("auth");
if(auth!=null){response.sendRedirect("index.jsp");}
ArrayList<Cart_Details> crt_list = (ArrayList<Cart_Details>) session.getAttribute("cart-list");
if (crt_list != null) {
	request.setAttribute("cart_list", crt_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@include file="includes/header.jsp" %>
</head>
<body>
<%@include file="includes/navigation.jsp" %>
<div class="container">
<div class="card w-50 mx-auto my-5">
<div class="card-header text-center">User Login
<div class="card-body">

<form action="user-login" method="post">

<div class="form-group">
<label>User name/Email Address</label>
<input type="email" class="form-control" name="login-email" requried>
<label>Password</label>
<input type="password" class="form-control" name="login-password" requried>
</div>
<div class="text-centre">
<button type="submit" class="btn btn-primary">Login</button>
</div>
</form>

</div>
</div>
</div>
</div>


</body>
</html>