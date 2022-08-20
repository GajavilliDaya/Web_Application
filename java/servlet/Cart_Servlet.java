package servlet;

import java.io.*;
import java.util.*;
import web_7051cem.model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Card_Servlet
 */
@WebServlet("/cart-servlet")
public class Cart_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()){
			ArrayList<Cart_Details> cart=new ArrayList<>();
			int id = Integer.parseInt(request.getParameter("id"));
			Cart_Details crt=new Cart_Details();
			crt.setId(id);
			crt.setQuan(1);
			
			HttpSession session=request.getSession();
			@SuppressWarnings("unchecked")
			ArrayList<Cart_Details> crt_list=(ArrayList<Cart_Details>) session.getAttribute("crt-list");
			if(crt_list==null) {
				cart.add(crt);
				session.setAttribute("crt-list", cart);
				response.sendRedirect("index.jsp");
			}else {
				cart=crt_list;
				boolean exist=false;
				
				for(Cart_Details c:crt_list) {
					if(c.getId()==id) {
						exist=true;
						out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart."
								+ "<a href='cart.jsp'>Go to Cart Page</a></h3>");
					}
				}if(!exist) {
					cart.add(crt);
					response.sendRedirect("index.jsp");
				}
			}
		}
	}

}