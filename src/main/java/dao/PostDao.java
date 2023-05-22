package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import entities.Post;

public class PostDao {
	

	public void insertPost(int user_id, String body,String desc) {
		Connection conn=ConnexionBD.getConnexion();
		String sqlQuery= "INSERT INTO posts(id_user,body,description) VALUES (?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setInt(1, user_id);
			pstmt.setString(2, body);
			pstmt.setString(3, desc);
		
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	public ArrayList<Post> getAllPost(){
		Connection conn=ConnexionBD.getConnexion();
		String sql="SELECT * FROM posts ORDER BY date_creation DESC";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Post> posts = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			 rs = pstmt.executeQuery();
				while(rs.next()) {
					
					Post p = new Post();
					p.setId_post(rs.getInt("id_post"));
					p.setId_user(rs.getInt("id_user"));
					p.setBody(rs.getString("body"));
					p.setDesc(rs.getString("description"));
					p.setPost_time(rs.getTimestamp("date_creation"));
					p.setNbr_like(rs.getInt("nbr_like"));
					p.setNbr_cmt(rs.getInt("nbr_commentaire"));
					posts.add(p);
				}
				return posts; 
			
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
	
	public ArrayList<Post> getAllPostLike(){
		Connection conn=ConnexionBD.getConnexion();
		String sql="SELECT * FROM posts ORDER BY nbr_like DESC";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Post> posts = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			 rs = pstmt.executeQuery();
				while(rs.next()) {
					
					Post p = new Post();
					p.setId_post(rs.getInt("id_post"));
					p.setId_user(rs.getInt("id_user"));
					p.setBody(rs.getString("body"));
					p.setDesc(rs.getString("description"));
					p.setPost_time(rs.getTimestamp("date_creation"));
					p.setNbr_like(rs.getInt("nbr_like"));
					p.setNbr_cmt(rs.getInt("nbr_commentaire"));
					
					posts.add(p);
				}
				return posts; 
			
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
	
	
	
	public ArrayList<Post> getUserPost(int user_id)  {
		Connection conn=ConnexionBD.getConnexion();
		String sql="SELECT * FROM posts WHERE id_user = ? ORDER BY date_creation DESC";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Post> posts = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			 rs = pstmt.executeQuery();
				while(rs.next()) {
					
					Post p = new Post();
					p.setId_post(rs.getInt("id_post"));
					p.setId_user(rs.getInt("id_user"));
					p.setBody(rs.getString("body"));
					p.setDesc(rs.getString("description"));
					p.setPost_time(rs.getTimestamp("date_creation"));
					p.setNbr_like(rs.getInt("nbr_like"));
					p.setNbr_cmt(rs.getInt("nbr_commentaire"));
					
					posts.add(p);
				}
				return posts; 
			
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
	return null;}
	
	
	public void deletePost(int post_id) {
		Connection conn=ConnexionBD.getConnexion();
		PreparedStatement st;
		try {
			st = conn.prepareStatement("DELETE FROM posts WHERE id_post = ?;");
			st.setInt(1, post_id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Post getPost(int post_id) throws SQLException {
		Connection conn=ConnexionBD.getConnexion();
		PreparedStatement st = conn.prepareStatement("SELECT * FROM posts WHERE id_post = ?;");
		st.setInt(1, post_id);
		ResultSet rs = st.executeQuery();
		Post p = new Post();
		if(rs.next()) {
			p.setId_post(rs.getInt("id_post"));
			p.setId_user(rs.getInt("id_user"));
			p.setBody(rs.getString("body"));
			p.setDesc(rs.getString("description"));
			p.setPost_time(rs.getTimestamp("date_creation"));
			p.setNbr_like(rs.getInt("nbr_like"));
			p.setNbr_cmt(rs.getInt("nbr_commentaire"));
			
		}
		return p; 
	}
	
	
	public String updatePost(Post post) {
		try {
			Connection conn=ConnexionBD.getConnexion();
			PreparedStatement st = conn.prepareStatement("UPDATE posts SET body = ?,description=? WHERE id_post = ?;");
			st.setString(1, post.getBody());
			st.setString(2,post.getDesc() );
			st.setInt(3, post.getId_post());
			st.execute();
			return "Post Update Successful.";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Post Update Failed.";
		}
	}
	
	public Void incrementLike(Post post) {
		Connection conn=ConnexionBD.getConnexion();
		PreparedStatement st;
		try {
			st = conn.prepareStatement("UPDATE posts SET nbr_like = ? WHERE id_post = ?;");
			st.setInt(1, post.getNbr_like()+1);
			st.setInt(2, post.getId_post());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
		}
	
	public Void decrementLike(Post post) {
		Connection conn=ConnexionBD.getConnexion();
		PreparedStatement st;
		try {
			st = conn.prepareStatement("UPDATE posts SET nbr_like = ? WHERE id_post = ?;");
			st.setInt(1, post.getNbr_like()-1);
			st.setInt(2, post.getId_post());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
		}
	
	
	public Void incrementComment(Post post) {
		Connection conn=ConnexionBD.getConnexion();
		PreparedStatement st;
		try {
			st = conn.prepareStatement("UPDATE posts SET nbr_commentaire = ? WHERE id_post = ?;");
			st.setInt(1, post.getNbr_cmt()+1);
			st.setInt(2, post.getId_post());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
		}
	
	public Void decrementComment(Post post) {
		Connection conn=ConnexionBD.getConnexion();
		PreparedStatement st;
		try {
			st = conn.prepareStatement("UPDATE posts SET nbr_commentaire = ? WHERE id_post = ?;");
			st.setInt(1, post.getNbr_cmt()-1);
			st.setInt(2, post.getId_post());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
		}
	
	public String PostTime(int id_post) {
		Connection conn=ConnexionBD.getConnexion();
		PreparedStatement st;
		try {
			st = conn.prepareStatement("SELECT date_creation FROM posts WHERE id_post = ?;");
			st.setInt(1, id_post);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				 LocalDateTime createdDate = rs.getTimestamp("date_creation").toLocalDateTime();
				 LocalDateTime now = LocalDateTime.now();
		         Duration duration = Duration.between(createdDate, now);
		        return  duration.toDays() + " d " + duration.toHoursPart() + " h "+ duration.toMinutesPart() +" min";

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
		
	}
		

}
