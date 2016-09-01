package dataBase;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FRegistration
 */
//@WebServlet("/FRegistration")
public class FRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FRegistration() {
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
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		String fname = request.getParameter("ffname");
		String lname = request.getParameter("flname");
		String femail = request.getParameter("femail");
		String dob = null;
		try {
			//dob = formatter.parse(request.getParameter("fdob"));
			dob =request.getParameter("fdob");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fsex = request.getParameter("fsex");
		String fpwd = request.getParameter("fpwd");
		String fdept = request.getParameter("department");
		String fcourse = request.getParameter("courses");

		String frarea = request.getParameter("rarea");
		String fofhours = request.getParameter("ohours");
		String fofloc = request.getParameter("olocation");

		System.out.println(fname + " ++ " + lname + " ++ " + femail + " ++ "
				+ dob + " ++ " + fsex + " ++ " + fpwd + " ++ " + fdept + " ++ "
				+ fdept + " ++ " + fcourse + " ++ " + frarea + " ++ "
				+ fofhours + " ++ " + fofloc);

		AuthDAO ad = new AuthDAO();

		String check_email[] = femail.split("@");

		if ((check_email[1]).equals("albany.edu")) {
			if (!ad.checkEmailAvailble(femail)) {
				if (ad.insertFacultyRecord(fname, lname, femail,
						dob, fsex, fpwd, fdept, fcourse,
						frarea, fofhours, fofloc)) {
					request.setAttribute("error_log",
							"You are Registered");
					getServletContext().getRequestDispatcher("/index.jsp")
							.forward(request, response);
				}
			} else {
				request.setAttribute("error_email",
						"Email is already registered");
				getServletContext().getRequestDispatcher("/fregister.jsp")
						.forward(request, response);
			}
		} else {
			request.setAttribute("error_email",
					"Email should be in @albany.edu format");
			getServletContext().getRequestDispatcher("/fregister.jsp").forward(
					request, response);
		}
	}

}
