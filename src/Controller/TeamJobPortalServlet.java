package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TeamJobPortalServlet
 */
//@WebServlet("/TeamJobPortalServlet")
public class TeamJobPortalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement st;
	private Connection c;
	private ResultSet rs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeamJobPortalServlet() {
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
		response.getWriter().append("Served at: ")
				.append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		HttpSession session = request.getSession();

		String location = request.getParameter("location");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		String requirement = request.getParameter("requirement");
		Date date = Date.valueOf(request.getParameter("date"));
		String url = request.getParameter("url");
		String email = request.getParameter("email");

		System.out.println(location);
		System.out.println(category);
		System.out.println(description);
		System.out.println(requirement);
		System.out.println(date);
		System.out.println(url);
		System.out.println(email);

		// Database Connection
		/*
		 * Dao connect = new Dao(); try { connect.DbCon(); } catch
		 * (ClassNotFoundException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } catch (SQLException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); }
		 */
		try {
			//c = DriverManager.getConnection(
			//		"jdbc:mysql://campusconnectnew.ctpwbenvprvc.us-west-2.rds.amazonaws.com:3306/campusconnect", "CampusConnectNew", "campusconnect");
		
		c = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/campusconnect", "root", "manager");
			// owner i am passing srinivas you can put name using your session.
			// so it will be srinivas for all posts.
			String sql = "INSERT INTO `jobportal` (`owner`, `location`, `category`, `description`, `requirement`, `deadlinedate`, `url`, `email`) VALUES ('"
					+ session.getAttribute("email")
					+ "', ?, ?, ?,?, '"
					+ date
					+ "', ?, ?)";

			st = c.prepareStatement(sql);
			st.setString(1, location);
			st.setString(2, category);
			st.setString(3, description);
			st.setString(4, requirement);
			st.setString(5, url);
			st.setString(6, email);

			st.executeUpdate();

			response.sendRedirect("TeamJobPortal.jsp");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
