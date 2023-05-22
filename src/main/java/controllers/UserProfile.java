package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

import dao.UserImpl;
import entities.User;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfile() {
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
			request.getRequestDispatcher("My_profil.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String UserImage=request.getParameter("UserImage");
		User userauth=(User) request.getSession().getAttribute("currentUser");
        UserImpl userI=new UserImpl();
        userI.updateImage(userauth, UserImage);
        request.getSession().setAttribute("currentUser", userI.finById(userauth.getIduser()));
        request.getServletContext().getRequestDispatcher("/My_profil.jsp").forward(request, response);
	

}}
