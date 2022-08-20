package web_7051cem.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import web_7051cem.model.Cart_Details;
import web_7051cem.model.Product_Details;

public class Product_Data {
	
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public Product_Data(Connection con) {
		super();
		this.con=con;
		
	}
	
	public List<Product_Details> getAllProducts(){
		
		List<Product_Details> book = new ArrayList<>();
		try {
			query="select * from product_details";
			pst=this.con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				Product_Details row = new Product_Details();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getDouble("price"));
				row.setImg(rs.getString("img"));
				book.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;}
		
		public Product_Details getSingleProduct(int id) {
			 Product_Details row = null;
		        try {
		            query = "select * from products where id=? ";
		            pst = this.con.prepareStatement(query);
		            pst.setInt(1, id);
		            ResultSet rs = pst.executeQuery();

		            while (rs.next()) {
		            	row = new Product_Details();
		                row.setId(rs.getInt("id"));
		                row.setName(rs.getString("name"));
		                row.setCategory(rs.getString("category"));
		                row.setPrice(rs.getDouble("price"));
		                row.setImg(rs.getString("img"));
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		            System.out.println(e.getMessage());
		        }

		        return row;
		    }
		
		public double getTotalCartPrice(ArrayList<Cart_Details> cart) {
	        double sum = 0;
	        try {
	            if (cart.size() > 0) {
	                for (Cart_Details item : cart) {
	                    query = "select price from product_details where id=?";
	                    pst = this.con.prepareStatement(query);
	                    pst.setInt(1,item.getId());
	                    rs = pst.executeQuery();
	                    while (rs.next()) {
	                        sum+=rs.getDouble("price")*item.getQuan();
	                    }

	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return sum;
	    }

	    
	    public List<Cart_Details> getCartProducts(ArrayList<Cart_Details> cart) {
	        List<Cart_Details> book = new ArrayList<>();
	        try {
	            if (cart.size() > 0) {
	                for (Cart_Details item : cart) {
	                    query = "select * from product_details where id=?";
	                    pst = this.con.prepareStatement(query);
	                    pst.setInt(1, item.getId());
	                    rs = pst.executeQuery();
	                    while (rs.next()) {
	                        Cart_Details row = new Cart_Details();
	                        row.setId(rs.getInt("id"));
	                        row.setName(rs.getString("name"));
	                        row.setCategory(rs.getString("category"));
	                        row.setPrice(rs.getDouble("price")*item.getQuan());
	                        row.setQuan(item.getQuan());
	                        book.add(row);
	                    }

	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return book;
	    }

		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getCategory() {
			// TODO Auto-generated method stub
			return null;
		}

		public int getPrice() {
			// TODO Auto-generated method stub
			return 0;
		}



		

		
}