package web_7051cem.data;

import java.sql.*;
import java.util.*;

import servlet.Order;
import web_7051cem.model.Buy;
import web_7051cem.model.Product_Details;



public class Order_Data {
	
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
    

	public Order_Data(Connection con) {
		super();
		this.con = con;
	}

	public boolean inOrder(Buy o_Model) {
        boolean result = false;
        try {
            query = "insert into orders (Product_id, User_id, Quantity, Date) values(?,?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, o_Model.getId());
            pst.setInt(2, o_Model.getU_id());
            pst.setInt(3, o_Model.getQuan());
            pst.setString(4, o_Model.getDate());
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
	

	public List<Buy> userOrder(int id) {
        List<Buy> list = new ArrayList<>();
        try {
            query = "select * from orders where u_id=? order by orders.o_id desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Buy order = new Buy();
                Product_Data p_data = new Product_Data(this.con);
                int pId = rs.getInt("Product_id");
                Product_Details product=Product_Details.getSingleProduct(id);
                order.setO_id(rs.getInt("Order_id"));
                order.setId(pId);
                order.setName(product.getName());
                order.setCategory(product.getCategory());
                order.setPrice(product.getPrice()*rs.getInt("Quantity"));
                order.setQuan(rs.getInt("Quantity"));
                order.setDate(rs.getString("Date"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void cancelOrder(int id) {
        //boolean result = false;
        try {
            query = "delete from orders where Order_id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        //return result;
    }

	public boolean inorder(Order o_Model) {
		// TODO Auto-generated method stub
		return false;
	}

	}



