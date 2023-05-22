package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Comment;




public class CommentDao {
	
	
	public Void addComment(int id_user,int id_post,String contenu) {
			Connection conn=ConnexionBD.getConnexion();
			String sqlQuery= "INSERT INTO commentaire(id_user,id_post,contenu) VALUES (?,?,?)";
			PreparedStatement pstmt=null;
			try {
				pstmt = conn.prepareStatement(sqlQuery);
				pstmt.setInt(1, id_user);
				pstmt.setInt(2, id_post);
				pstmt.setString(3, contenu);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
	
	
	public Void deleteComment(int id_comment) {
		Connection conn=ConnexionBD.getConnexion();
		String sqlQuery= "DELETE FROM commentaire WHERE id_cmnt = ?";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sqlQuery);
			pstmt.setInt(1, id_comment);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Void updateComment(int id_comment,String contenu) {
		Connection conn=ConnexionBD.getConnexion();
		String sqlQuery= "UPDATE commentaire SET contenu = ? WHERE id_cmt = ?";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sqlQuery);
			pstmt.setString(1, contenu);
			pstmt.setInt(2, id_comment);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ArrayList<Comment> getPostComments(int id_post){
		Connection conn=ConnexionBD.getConnexion();
		String sql="SELECT * FROM commentaire WHERE id_post=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Comment> comments = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id_post);
			 rs = pstmt.executeQuery();
				while(rs.next()) {
					
					Comment c = new Comment();
					c.setId_cmt(rs.getInt("id_cmnt"));
					c.setId_post(rs.getInt("id_post"));
					c.setId_user(rs.getInt("id_user"));
					c.setContenu(rs.getString("contenu"));
					comments.add(c);

					
					
				}
				return comments; 
			
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
	



