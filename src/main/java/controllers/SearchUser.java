package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import dao.UserImpl;
import entities.User;

/**
 * Servlet implementation class SearchUser
 */
@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUser() {
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
		
		UserImpl userI =new UserImpl();
		ArrayList<User> users=userI.getUsers(userauth.getIduser());
		request.setAttribute("users", users);
		request.getRequestDispatcher("profiles.jsp").forward(request, response);
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String UserSearch =request.getParameter("search");
		UserImpl userI =new UserImpl();
		ArrayList<User> users=userI.getUserByname(UserSearch);
		request.setAttribute("users", users);
		request.getRequestDispatcher("profiles.jsp").forward(request, response);
		
	}

}
