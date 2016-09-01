package session;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataBase.AuthDAO;

/**
 * Servlet implementation class LoginAuth
 */
//@WebServlet("/LoginAuth")
public class LoginAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAuth() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");

		AuthDAO ad = new AuthDAO();

		System.out.println(ad.LoginAuth(email, password));

		if (ad.LoginAuth(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("type", ad.getType(email));
			if ((ad.getType(email)).equals("1")) {
				session.setAttribute("profile", ad.getStudentProfile(email));
			}
			if ((ad.getType(email)).equals("3")) {
				session.setAttribute("fprofile", ad.getFacultyProfile(email));
			}
			session.setAttribute("photopath",
					"CSS/images/" + ad.getPhoto(email));
			response.sendRedirect("NewsFeed");
		} else {
			request.setAttribute("login_error",
					"Username and Password not correct");
			getServletContext().getRequestDispatcher("/index.jsp").forward(
					request, response);
		}

	}
}
