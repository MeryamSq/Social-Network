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
 * Servlet implementation class Profil
 */
@WebServlet("/Profil")
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
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
		 request.getRequestDispatcher("profil.jsp").forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_user=Integer.parseInt(request.getParameter("userprofil"));
		User userVisited=new User();
		UserImpl userI=new UserImpl();
		userVisited=userI.finById(id_user);
		request.getSession().setAttribute("userVisited", userVisited);
		request.setAttribute("userVisited", userVisited);
		 request.getRequestDispatcher("profil.jsp").forward(request, response);
		
	}

}
