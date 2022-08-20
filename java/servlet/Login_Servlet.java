package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_7051cem.data.User_Data;
import web_7051cem.jdbc_mysql.db_connection;
import web_7051cem.model.User_Details;


@WebServlet("/user-login")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** public Login_Servlet() {
       * super();
        // TODO Auto-generated constructor stub
    }*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login.jsp");
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()){
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			try {
				User_Data udata = new User_Data(db_connection.getConnection());
				User_Details user =udata.userLogin(email, password);
				
				if(user!=null) {
					request.getSession().setAttribute("auth", user);
					response.sendRedirect("index.jsp");
					
				}else {
					out.println("User failed");
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			System.out.println(email+password);
		}
		}
}