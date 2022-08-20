package servlet;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web_7051cem.jdbc_mysql.db_connection;
import web_7051cem.data.Order_Data;
import web_7051cem.model.Buy;
import web_7051cem.model.User_Details;

/**
 * Servlet implementation class Buy_Now
 */
@WebServlet("/buy-now")
public class Buy_Now extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out=response.getWriter()){
			SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
			Date date=new Date();
			request.getSession().getAttribute("auth");
			User_Details auth=(User_Details) request.getSession().getAttribute("auth");
			if(auth!=null) {
				String p_id=request.getParameter("id");
				int p_quan=Integer.parseInt(request.getParameter("quantity"));
				if(p_quan<=0) {p_quan=1;}
				
				Buy buy_model = new Buy();
				buy_model.setId(Integer.parseInt(p_id));
				buy_model.setU_id(auth.getId());
				buy_model.setQuan(p_quan);
				buy_model.setDate(format.format(date));
				Connection con=db_connection.getConnection();
				Order_Data order=new Order_Data(con);
				order.inOrder(buy_model);
				
			}else {response.sendRedirect("login.jsp");}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
