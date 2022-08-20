package web_7051cem.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.*;
import web_7051cem.model.User_Details;

public class User_Data {
	
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	public User_Data(Connection con) {
		
		this.con = con;
	}
	
	public User_Details userLogin(String Email, String Password) {
		
		User_Details user = null;
		
		try {
			query="select * from user_details where email=? and password=?";
			pst = this.con.prepareStatement(query);
			pst.setString(2, Password);
			pst.setString(1, Email);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				user = new User_Details();
				user.setName(rs.getString("Name"));
				user.setEmail(rs.getString("Email"));
				
			}
			
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return user;
	}
}
