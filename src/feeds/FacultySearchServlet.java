package feeds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.AuthDAO;
import model.FacultyProfile;

/**
 * Servlet implementation class FacultySearchServlet
 */
public class FacultySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultySearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("field");
		AuthDAO a = new AuthDAO();
		System.out.println(name);
		ArrayList<FacultyProfile> profile = a.searchFacultyInterests(name);
		
		request.setAttribute("profile", profile);
		RequestDispatcher rd=request.getRequestDispatcher("facultysearch.jsp");
	    rd.forward(request,response);
		//response.sendRedirect("facultysearch.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
