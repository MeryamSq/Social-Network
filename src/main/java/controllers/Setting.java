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
 * Servlet implementation class Setting
 */
@WebServlet("/Setting")
public class Setting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Setting() {
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
			request.getRequestDispatcher("setting.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("setting");
		User userauth=(User) request.getSession().getAttribute("currentUser");
		if(type.equals("info")) {
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			String number=request.getParameter("number");
			UserImpl userDAO = new UserImpl();
			User user = new User();
			user.setIduser(userauth.getIduser());
			user.setName(username);
			user.setEmail(email);
			user.setNumber(number);
			String result = userDAO.updateProfile(user);
			request.setAttribute("pmsg", result);
			request.getSession().setAttribute("currentUser", userDAO.finById(userauth.getIduser()));
			doGet(request, response);
			
			
		}
		else if(type.equals("password")) {
			String oldpassword=request.getParameter("oldPassword");
			String password = request.getParameter("password");
			String cpassword = request.getParameter("cpassword");
			
			if(!oldpassword.equals(userauth.getPsw())) {
				request.setAttribute("pmsg", "Old password is incorrect");
				doGet(request, response);
			}
			else if(!password.equals(cpassword)) {
				request.setAttribute("pmsg", "New Password and Confirm Password are not match.");
				doGet(request, response);
			}
			else {
				UserImpl userDAO = new UserImpl();
				User user = new User();
				user.setIduser(userauth.getIduser());
				user.setPsw(password);
				String result = userDAO.updatePassword(user);
				request.setAttribute("pmsg", result);
				request.getSession().setAttribute("currentUser", userDAO.finById(userauth.getIduser()));
				doGet(request, response);
			}
			
		}
	}

}
