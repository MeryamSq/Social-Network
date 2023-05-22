package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.FollowDao;
import dao.UserImpl;
import entities.User;



/**
 * Servlet implementation class Follow
 */
@WebServlet("/Follow")
public class Follow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Follow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("SearchUser");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_user=Integer.parseInt(request.getParameter("follow"));
		User userauth=(User) request.getSession().getAttribute("currentUser");
		FollowDao flwd=new FollowDao();
		if(flwd.existFOllow(userauth.getIduser(), id_user)) {
			flwd.removeFollow(userauth.getIduser(), id_user);
			request.getSession().setAttribute("userVisited", new UserImpl().finById(id_user));
			//request.setAttribute("userVisited", new UserImpl().finById(id_user));
			request.getRequestDispatcher("profil.jsp").forward(request, response);
		}
		else {
			flwd.addFollow(userauth.getIduser(), id_user);
			
			request.getSession().setAttribute("userVisited", new UserImpl().finById(id_user));
			request.getRequestDispatcher("profil.jsp").forward(request, response);
		}
		
		
		
	}

}
