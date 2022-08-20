package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_7051cem.model.Cart_Details;
import web_7051cem.model.User_Details;
import web_7051cem.data.Order_Data;
import web_7051cem.data.Product_Data;
import web_7051cem.jdbc_mysql.db_connection;

/**
 * Servlet implementation class Check_Out
 */
@WebServlet("/Check_Out")
public class Check_Out extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check_Out() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
		ArrayList<Cart_Details> cart_list = (ArrayList<Cart_Details>) request.getSession().getAttribute("crt-list");
		User_Details auth = (User_Details) request.getSession().getAttribute("auth");
		if(cart_list != null && auth!=null) {
			for(Cart_Details c:cart_list) {
				Order order = new Order();
				order.setId(c.getId());
				order.setU_id(auth.getId());
				order.setQuan(c.getQuan());
				order.setDate(formatter.format(date));
				
				Order_Data oDao = new Order_Data(db_connection.getConnection());
				boolean result = oDao.inorder(order);
				if(!result) break;
			}
			cart_list.clear();
			response.sendRedirect("orders.jsp");
		}else {
			if(auth==null) {
				response.sendRedirect("login.jsp");
			}
			response.sendRedirect("cart.jsp");
		}
	} catch(Exception e) {
		
		e.printStackTrace();
	}
}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
