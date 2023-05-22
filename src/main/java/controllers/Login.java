package controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.UserImpl;
import entities.User;



@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       HttpSession session;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user= new User();
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserImpl userI=new UserImpl();
        user=userI.authUser(email,password);
        

        if(user!=null) {
        	session=request.getSession();
			session.setAttribute("currentUser", user);
			response.sendRedirect("Home");

		}else {
			
            request.setAttribute("statut", "Failed");
            request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}
       

	}

}
