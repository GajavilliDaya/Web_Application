package servlet;

import web_7051cem.model.*;
import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Remove_Item
 */
@WebServlet("/remove_item")
public class Remove_Item extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Remove_Item() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String bookId = request.getParameter("id");
			if (bookId != null) {
				ArrayList<Cart_Details> crt_list = (ArrayList<Cart_Details>) request.getSession().getAttribute("crt-list");
				if (crt_list != null) { for (Cart_Details c : crt_list) {
					if (c.getId() == Integer.parseInt(bookId)) { crt_list.remove(crt_list.indexOf(c));break; }}}
				response.sendRedirect("cart.jsp");
				} else { response.sendRedirect("cart.jsp"); }
		}
	}
}