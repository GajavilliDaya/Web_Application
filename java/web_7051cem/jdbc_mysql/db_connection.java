package web_7051cem.jdbc_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_connection {
	
	private static Connection connection = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		if(connection==null) {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer_for_you","root","7095");
			System.out.println("connected");
		}
		return connection;
	}

}
