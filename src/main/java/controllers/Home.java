package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


import dao.PostDao;
import entities.Post;
import entities.User;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userauth=(User) request.getSession().getAttribute("currentUser");
		if(userauth==null) {
			response.sendRedirect("Login");
		}
		else {
		PostDao postDAO = new PostDao();
		ArrayList<Post> posts = new ArrayList<>();
	
		posts = postDAO.getAllPost();
			

		request.setAttribute("posts", posts);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		if(type.equals("addpost")) {
			String desc=request.getParameter("description");
			String newpost= request.getParameter("newpost");
			User userauth=(User) request.getSession().getAttribute("currentUser");
		
			PostDao postDao=new PostDao();
			postDao.insertPost(userauth.getIduser(), newpost, desc);
			
			doGet(request,response);
		}
		else if(type.equals("popularity")) {
			PostDao postDAO = new PostDao();
			ArrayList<Post> posts = new ArrayList<>();
		
				posts = postDAO.getAllPostLike();
				

			request.setAttribute("posts", posts);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		else if(type.equals("date")) {
			doGet(request,response);
		}

		
	
	}

}
