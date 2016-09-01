package feeds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FacultyProfile;
import model.StudentProfile;
import dataBase.AuthDAO;

/**
 * Servlet implementation class Search
 */
//@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<String> strList = new ArrayList<String>();
		String temp = new String();
		
		String content = request.getParameter("content").trim().toLowerCase();
		
		AuthDAO ad = new AuthDAO();
		
		if (content != null && !"".equals(content)) {
			
			ArrayList<StudentProfile> studentprofilearray = ad.seachStudent(content);
			ArrayList<FacultyProfile> facultyprofilearray = ad.searchFaculty(content);
			
			if(!studentprofilearray.isEmpty()) {
				for(StudentProfile i : studentprofilearray) {
					temp = i.getFname() + " " + i.getLname() + " - " + i.getEmail();
					strList.add(temp);
				}
			}
			
			if(!facultyprofilearray.isEmpty()) {
				for(FacultyProfile j : facultyprofilearray) {
					temp = j.getFname() + " " + j.getLname() + " - " + j.getFemail();
					strList.add(temp);
				}
				
			}
			
			
			request.setAttribute("strList", strList);
			request.getRequestDispatcher("showAjax.jsp").forward(request, response);

		
		}
			
	}

}
