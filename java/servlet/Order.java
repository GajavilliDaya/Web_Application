package servlet;

import java.io.IOException;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_7051cem.jdbc_mysql.*;
import web_7051cem.data.Order_Data;
import web_7051cem.model.Cart_Details;
import web_7051cem.model.User_Details;

/**
 * Servlet implementation class Order
 */
@WebServlet("/order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            User_Details auth = (User_Details) request.getSession().getAttribute("auth");

            if (auth != null) {
                String p_Id = request.getParameter("id");
                int productQuantity = Integer.parseInt(request.getParameter("quantity"));
                if (productQuantity <= 0) {
                	productQuantity = 1;
                }
                Order o_Model = new Order();
                o_Model.setId(Integer.parseInt(p_Id));
                o_Model.setId(auth.getId());
                o_Model.setQuan(productQuantity);
                o_Model.setDate(formatter.format(date));

                Order_Data o_dao = new Order_Data(db_connection.getConnection());
                boolean result = o_dao.inorder(o_Model);
                if (result) {
                    ArrayList<Cart_Details> crt_list = (ArrayList<Cart_Details>) request.getSession().getAttribute("crt-list");
                    if (crt_list != null) {
                        for (Cart_Details c : crt_list) {
                            if (c.getId() == Integer.parseInt(p_Id)) {
                                crt_list.remove(crt_list.indexOf(c));
                                break;
                            }
                        }
                    }
                    response.sendRedirect("orders.jsp");
                } else {
                    out.println("order failed");
                }
            } else {
                response.sendRedirect("login.jsp");
            }

        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	void setDate(String format) {
		// TODO Auto-generated method stub
		
	}

	void setQuan(int productQuantity) {
		// TODO Auto-generated method stub
		
	}

	void setId(int parseInt) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void setU_id(int id) {
		// TODO Auto-generated method stub
		
	}


	

}
