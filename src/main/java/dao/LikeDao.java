package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LikeDao {
	
	public void addLike(int id_post,int id_user) {
		Connection conn=ConnexionBD.getConnexion();
		String sqlQuery= "INSERT INTO likes(id_user,id_post) VALUES (?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setInt(1, id_user);
			pstmt.setInt(2, id_post);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteLike(int id_post,int id_user) {
		
		Connection conn=ConnexionBD.getConnexion();
		String sqlQuery= "DELETE FROM likes WHERE id_post = ? and id_user=?";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sqlQuery);
			pstmt.setInt(1, id_post);
			pstmt.setInt(2, id_user);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public boolean existLike(int id_post,int id_user) {
		
		Connection conn=ConnexionBD.getConnexion();
		String sqlQuery= "SELECT * FROM likes WHERE id_post = ? and id_user=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sqlQuery);
			pstmt.setInt(1, id_post);
			pstmt.setInt(2, id_user);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public ArrayList<Integer>userLike(int id_post){
		Connection conn=ConnexionBD.getConnexion();
		ArrayList<Integer> idLikes =new ArrayList<Integer>();
		String query="SELECT id_user FROM likes WHERE id_post=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, id_post);
			rs=pstmt.executeQuery();
			int id=0;
			while(rs.next()) {
				
				id=rs.getInt("id_user");
				idLikes.add(id);
				
			}
			return idLikes;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

		
		
	}
	}
	

		
	
	
	
	
	
	


