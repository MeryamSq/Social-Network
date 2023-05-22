package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
	


		private static String username = "root";
		private static String password = "";
		private static String url ="jdbc:mysql://localhost:3306/social";

		private static Connection conn;
		
		static {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (Exception e) {
				
				 System.err.println("Driver jdbc est introuvable ");
		    	 System.err.println("Error : "+ e.getMessage());
		    	 
			}
		}

		public static Connection getConnexion() {
			try {
				
				conn=DriverManager.getConnection(url, username, password);
				
			} catch (SQLException e) {
				
				System.err.println("Probleme de connexion a la BD ");
				System.err.println("Error : "+ e.getMessage());
				System.err.println("Error Code : "+e.getErrorCode());
				
			}
			return conn;
		
		
		
	}


}
