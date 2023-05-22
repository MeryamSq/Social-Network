package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import entities.User;



public class UserImpl  {

	
	public User authUser(String email, String psw) {
		Connection conn=ConnexionBD.getConnexion();
		String sqlQuery="SELECT * FROM users WHERE email= ? and password = ?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sqlQuery);
			pstmt.setString(1, email);
			pstmt.setString(2, psw);
			rs=pstmt.executeQuery();
			while(rs.next()){
				User User=new User();
				User.setIduser(rs.getInt("id"));
				User.setName(rs.getString("name"));
				User.setPsw(rs.getString("password"));
				User.setEmail(rs.getString("email"));
				User.setNumber(rs.getString("number"));
				User.setImage(rs.getString("image"));
				
				return User;
			}
			 
		 }catch (SQLException e) {
				System.err.println("Probleme de connexion a la BD ");
				System.err.println("Error : "+ e.getMessage());
				System.err.println("Error Code : "+e.getErrorCode());
		}finally {
			try {
				if (rs!=null){rs.close();}
				if (pstmt!=null){pstmt.close();}
				if (conn!=null){conn.close();}
			}catch(SQLException e) {
				System.err.println("Probleme de fermeture des ressources de la BD ");
				System.err.println("Error : "+ e.getMessage());
				System.err.println("Error Code : "+e.getErrorCode());
			}
		}
		return null;
	}

	
	public boolean registerUser(User user) {
		Connection conn=ConnexionBD.getConnexion();
		String sqlQuery = "insert into users(name,password,email,number) values(?, ?, ?, ?)";
		PreparedStatement pstmt=null;
		int i =0;
		try {
			pstmt=conn.prepareStatement(sqlQuery);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPsw());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getNumber());
			i=pstmt.executeUpdate();  
	        if(i>0)  {
				return true;
			}
			 
		 }catch (SQLException e) {
				System.err.println("Probleme de connexion a la BD ");
				System.err.println("Error : "+ e.getMessage());
				System.err.println("Error Code : "+e.getErrorCode());
		}finally {
			try {
				
				if (pstmt!=null){pstmt.close();}
				if (conn!=null){conn.close();}
			}catch(SQLException e) {
				System.err.println("Probleme de fermeture des ressources de la BD ");
				System.err.println("Error : "+ e.getMessage());
				System.err.println("Error Code : "+e.getErrorCode());
			}
		}
		return false;
	}





	public User finById(int id) {
		Connection conn=ConnexionBD.getConnexion();
		String sqlQuery="Select * from users where id=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sqlQuery);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				User User = new User();
				User.setIduser(rs.getInt("id"));
				User.setName(rs.getString("name"));
				User.setPsw(rs.getString("password"));
				User.setEmail(rs.getString("email"));
				User.setNumber(rs.getString("number"));
				User.setImage(rs.getString("image"));
				return User;
			}
		 }catch (SQLException e) {
				System.err.println("Probleme de connexion a la BD ");
				System.err.println("Error : "+ e.getMessage());
				System.err.println("Error Code : "+e.getErrorCode());
		}finally {
			try {
				if (rs!=null){rs.close();}
				if (pstmt!=null){pstmt.close();}
				if (conn!=null){conn.close();}
			}catch(SQLException e) {
				System.err.println("Probleme de fermeture des ressources de la BD ");
				System.err.println("Error : "+ e.getMessage());
				System.err.println("Error Code : "+e.getErrorCode());
			}
		}
		return null;
	}
	
	
	public void deleteUser(int user_id) throws SQLException {
		Connection conn=ConnexionBD.getConnexion();
		PreparedStatement st = conn.prepareStatement("DELETE FROM users WHERE id = ?");
		st.setInt(1, user_id);
		st.executeUpdate();
	}
	
	public String updateProfile(User user) {
		try {
			Connection conn=ConnexionBD.getConnexion();
			PreparedStatement st = conn.prepareStatement("UPDATE users SET name= ?, number = ?, email = ? WHERE id = ?;");
			st.setString(1, user.getName());
			st.setString(2, user.getNumber());
			st.setString(3, user.getEmail());
			st.setInt(4, user.getIduser());
			st.execute();
			return "Profile Update Successful.";
		}  catch (SQLException e) {
			e.printStackTrace();
			return "Profile Update Failed.";
		}
		
	}
	
	public Void updateImage(User user,String image) {
		try {
			Connection conn=ConnexionBD.getConnexion();
			PreparedStatement st = conn.prepareStatement("UPDATE users SET image= ? WHERE id = ?;");
			st.setString(1, image);
			st.setInt(2, user.getIduser());
			st.execute();
			
		}  catch (SQLException e) {
			e.printStackTrace();
			
		}return null;
		
	}
	
	public String updatePassword(User user) {
		try {
			Connection conn=ConnexionBD.getConnexion();
			PreparedStatement st = conn.prepareStatement("UPDATE users SET password = ? WHERE id = ?;");
			st.setString(1, user.getPsw());
			st.setInt(2, user.getIduser());
			st.execute();
			return "Password Update Successful.";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Password Update Failed.";
		}
	}


	public ArrayList<User> getUsers(int id_user) {
		Connection conn=ConnexionBD.getConnexion();
		ArrayList<User> users=new ArrayList<User>();
		String query="SELECT * FROM users WHERE id <> ?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, id_user);
			 rs= pstmt.executeQuery();
			while(rs.next()) {
				User User = new User();
				User.setIduser(rs.getInt("id"));
				User.setName(rs.getString("name"));
				User.setPsw(rs.getString("password"));
				User.setEmail(rs.getString("email"));
				User.setNumber(rs.getString("number"));
				User.setImage(rs.getString("image"));
				
				users.add(User);
			}return users;

		} catch (SQLException e) {
			System.err.println("Probleme de connexion a la BD ");
			System.err.println("Error : "+ e.getMessage());
			System.err.println("Error Code : "+e.getErrorCode());
	}finally {
		try {
			if (rs!=null){rs.close();}
			if (pstmt!=null){pstmt.close();}
			if (conn!=null){conn.close();}
		}catch(SQLException e) {
			System.err.println("Probleme de fermeture des ressources de la BD ");
			System.err.println("Error : "+ e.getMessage());
			System.err.println("Error Code : "+e.getErrorCode());
		}
	}
	return null;
		
		
	}
	public ArrayList<User> getUserByname(String name) {
		Connection conn=ConnexionBD.getConnexion();
		ArrayList<User> users=new ArrayList<User>();
		String query="SELECT * FROM users WHERE name=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, name);
			 rs= pstmt.executeQuery();
			while(rs.next()) {
				User User = new User();
				User.setIduser(rs.getInt("id"));
				User.setName(rs.getString("name"));
				User.setPsw(rs.getString("password"));
				User.setEmail(rs.getString("email"));
				User.setNumber(rs.getString("number"));
				User.setImage(rs.getString("image"));
				
				users.add(User);
			}return users;

		} catch (SQLException e) {
			System.err.println("Probleme de connexion a la BD ");
			System.err.println("Error : "+ e.getMessage());
			System.err.println("Error Code : "+e.getErrorCode());
	}finally {
		try {
			if (rs!=null){rs.close();}
			if (pstmt!=null){pstmt.close();}
			if (conn!=null){conn.close();}
		}catch(SQLException e) {
			System.err.println("Probleme de fermeture des ressources de la BD ");
			System.err.println("Error : "+ e.getMessage());
			System.err.println("Error Code : "+e.getErrorCode());
		}
	}
	return null;
		
		
	}
	

}
