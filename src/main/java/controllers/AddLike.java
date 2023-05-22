package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import dao.LikeDao;
import dao.PostDao;
import entities.Post;
import entities.User;

/**
 * Servlet implementation class AddLike
 */
@WebServlet("/AddLike")
public class AddLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source=request.getParameter("source");
		int id_post=Integer.parseInt(request.getParameter("id_post"));
		PostDao postdao =new PostDao();
		Post post =new Post();
		try {
			post=postdao.getPost(id_post);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User userauth=(User) request.getSession().getAttribute("currentUser");
		LikeDao like=new LikeDao();
		if(like.existLike(id_post,userauth.getIduser())) {
			like.deleteLike(id_post, userauth.getIduser());
			postdao.decrementLike(post);
		}
		else if(!like.existLike(id_post,userauth.getIduser())) {
			like.addLike(id_post, userauth.getIduser());
			postdao.incrementLike(post);
			
		}
		
		if(source.equals("home")) {
			response.sendRedirect("Home");
		}
		else if(source.equals("myprofil")) {
			response.sendRedirect("UserProfil");
		}
		else if(source.equals("profil")) {
			response.sendRedirect("Profil");
		}
		else if(source.equals("feed")) {
			response.sendRedirect("NewFeed");
		}
		
		
	}

}
