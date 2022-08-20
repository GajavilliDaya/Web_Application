package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web_7051cem.model.Cart_Details;
/**
 * Servlet implementation class Inc_Dec
 */
@WebServlet("/inc-dec")
public class Inc_Dec extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<Cart_Details> crt_list = (ArrayList<Cart_Details>) request.getSession().getAttribute("crt-list");
			if (action != null && id >= 1) { if (action.equals("inc")) 
			{ for (Cart_Details c : crt_list) { if (c.getId() == id) {
				int quan = c.getQuan();
				quan++;
				c.setQuan(quan);
				response.sendRedirect("cart.jsp");
				}}
			}
			if (action.equals("dec")) { for (Cart_Details c : crt_list) {if (c.getId() == id && c.getQuan() > 1) 
			{ int quan = c.getQuan();
			quan--;
			c.setQuan(quan);
			break; } }
			
			response.sendRedirect("cart.jsp"); }
			} else { response.sendRedirect("cart.jsp"); }
			}
	}
}