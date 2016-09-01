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
 * Servlet implementation class SRegistration
 */
//@WebServlet("/SRegistration")
public class SRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SRegistration() {
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
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dob = null;
		try {
			dob = request.getParameter("dob");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sex = request.getParameter("sex");
		String pwd = request.getParameter("pwd");
		String stuinterest = request.getParameter("stuinterest");
		String major = request.getParameter("major");
		String classof = request.getParameter("classof");
		String email = request.getParameter("email");

		System.out.println(fname + " ++ " + lname + " ++ " + dob + " ++ " + sex
				+ " ++ " + pwd + " ++ " + classof + " ++ " + stuinterest
				+ " ++ " + email + " ++ " + major);

		AuthDAO ad = new AuthDAO();

		String check_email[] = email.split("@");

		if ((check_email[1]).equals("albany.edu")) {
			if (!ad.checkEmailAvailble(email)) {
				if (ad.insertStudentRecord(fname, lname, formatter.format(dob),
						sex, pwd, classof, stuinterest, email, major)) {
					request.setAttribute("error_log",
							"You are Registered");
					getServletContext().getRequestDispatcher("/index.jsp")
							.forward(request, response);
				}
			} else {
				request.setAttribute("error_email",
						"Email is already registered");
				getServletContext().getRequestDispatcher("/sregister.jsp")
						.forward(request, response);
			}
		} else {
			request.setAttribute("error_email",
					"Email should be in @albany.edu format");
			getServletContext().getRequestDispatcher("/sregister.jsp").forward(
					request, response);
		}
	}

}
