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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("registration.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user= new User();
		String uname= request.getParameter("name");
		String uemail= request.getParameter("email");
		String upassword= request.getParameter("pass");
		String unumber= request.getParameter("contact");
        user.setName(uname);
        user.setEmail(uemail);
        user.setPsw(upassword);
        user.setNumber(unumber);
        UserImpl userI=new UserImpl();
        boolean i=false;
        i=userI.registerUser(user);
        
        if(i) {
        	request.setAttribute("statut", "success");
        	response.sendRedirect("Login");
        	
		}else {
			request.setAttribute("statut", "Failed");
			response.sendRedirect("Register");
		
	}
        
		
	}

}
