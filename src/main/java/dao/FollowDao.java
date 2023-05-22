package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FollowDao {
	
	public Void addFollow(int id_emet,int id_recu) {
		
		Connection conn=ConnexionBD.getConnexion();
		String sqlQuery= "INSERT INTO follow(id_emet,id_recu,statu) VALUES (?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setInt(1, id_emet);
			pstmt.setInt(2, id_recu);
			pstmt.setString(3,"follow");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Void removeFollow(int id_emet,int id_recu) {
		Connection conn=ConnexionBD.getConnexion();
		PreparedStatement st;
		try {
			st = conn.prepareStatement("DELETE FROM follow WHERE id_emet = ? AND id_recu=?;");
			st.setInt(1, id_emet);
			st.setInt(2, id_recu);	
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public boolean existFOllow(int id_emet,int id_recu) {
		Connection conn=ConnexionBD.getConnexion();
		String sql="SELECT * FROM follow WHERE id_emet = ? AND id_recu=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id_emet);
			pstmt.setInt(2, id_recu);
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
	
	public int sommeFollowers(int id_user) {
		Connection conn=ConnexionBD.getConnexion();
		String sql="SELECT * FROM follow WHERE id_recu=? AND id_emet<>id_recu";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int somme=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id_user);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				somme+=1;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return somme;
		
	}
	
	public int sommeFollowing(int id_user) {
		Connection conn=ConnexionBD.getConnexion();
		String sql="SELECT * FROM follow WHERE id_emet=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int somme=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id_user);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				somme+=1;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return somme;
		
	}
	
	public ArrayList<Integer> getFollowing(int id_user){
		Connection conn=ConnexionBD.getConnexion();
		ArrayList<Integer> idFollowing =new ArrayList<Integer>();
		String query="SELECT id_recu FROM follow WHERE id_emet=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, id_user);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int id=0;
				id=rs.getInt("id_recu");
				idFollowing.add(id);
				
			}
			return idFollowing;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

		
		
	}
	public ArrayList<Integer> getFollowers(int id_user){
		Connection conn=ConnexionBD.getConnexion();
		ArrayList<Integer> idFollowers =new ArrayList<Integer>();
		String query="SELECT id_emet FROM follow WHERE id_recu=? AND id_emet<>id_recu";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, id_user);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int id=0;
				id=rs.getInt("id_emet");
				idFollowers.add(id);
				
			}
			return idFollowers;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

		
		
	}

}
