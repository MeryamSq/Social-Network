package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import dao.CommentDao;
import dao.PostDao;
import entities.Post;
import entities.User;


/**
 * Servlet implementation class AddComment
 */
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComment() {
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
		String contenu=request.getParameter("contenu");
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
		CommentDao comtdao=new CommentDao();
		comtdao.addComment(userauth.getIduser(), id_post, contenu);
		postdao.incrementComment(post);
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
