package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.FacultyProfile;
import model.GetNewsFeed;
import model.GetRoomMateFeed;
import model.GetSMarketFeed;
import model.StudentProfile;

public class AuthDAO {

	Connection conn = null;
	Statement s = null;

	public AuthDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection(
				//	"jdbc:mysql://campusconnectnew.ctpwbenvprvc.us-west-2.rds.amazonaws.com:3306/campusconnect", "CampusConnectNew", "campusconnect");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/campusconnect", "root", "manager");
			s = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean LoginAuth(String email, String password) {
		String sql = "select * from login where Email='" + email + "'";

		try {

			java.sql.ResultSet rs = s.executeQuery(sql);
			String thisemail = "null";
			String thispassword = "null";
			int thistype = 2;

			while (rs.next()) {
				thisemail = rs.getString("Email");
				thispassword = rs.getString("Password");
				thistype = rs.getInt("Type");
			}

			if (thisemail.equals(email) && thispassword.equals(password)
					&& thistype != 2) {
				return true;

			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public String getType(String email) {
		System.out.println("There is email " + email);
		String sql = "select * from login where Email='" + email + "'";

		try {

			ResultSet rs = s.executeQuery(sql);
			String type = "null";

			while (rs.next()) {
				type = rs.getString("Type");
			}
			System.out.println("There is type " + type);
			return type;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertStudentRecord(String fname, String lname, String dob,
			String sex, String pwd, String classof, String stuinterest,
			String email, String major) {

		try {

			String sql = "INSERT INTO student VALUES ('" + fname + "', '"
					+ lname + "', '" + email + "', '" + dob + "', '" + sex
					+ "', '" + major + "'," + classof + ", '" + stuinterest
					+ "')";

			int random_number = (int) Math.round(Math.random() * 999999);

			String sql1 = "INSERT INTO login VALUES ('" + email + "', '" + pwd
					+ "', 1)";
			String sql2 = "INSERT INTO emailveri VALUES ('" + email + "', "
					+ random_number + ")";
			String sql3 = "INSERT INTO photo VALUES ('" + email
					+ "', 'default.jpg')";

			System.out.println(sql + " " + sql1);
			if (s.executeUpdate(sql) == 1) {
				if (s.executeUpdate(sql1) == 1) {
					if (s.executeUpdate(sql3) == 1) {
						// EmailVeri ev = new EmailVeri();
						//ev.sendMail(email, random_number);
						if (s.executeUpdate(sql2) == 1) {
							return true;
						}
					}
				}
				return false;
			}
			// return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
		return false;
	}

	public boolean insertFacultyRecord(String fname, String lname,
			String femail, String dob, String fsex, String fpwd, String fdept,
			String fcourse, String frarea, String fofhours, String fofloc) {

		try {

			String sql = "INSERT INTO faculty VALUES ('" + fname + "', '"
					+ lname + "', '" + femail + "', '" + dob + "', '" + fsex
					+ "','" + fdept + "', '" + fcourse + "','" + frarea + "','"
					+ fofhours + "','" + fofloc + "');";

			int random_number = (int) Math.round(Math.random() * 999999);

			String sql1 = "INSERT INTO login VALUES ('" + femail + "', '"
					+ fpwd + "', 3);";
			String sql2 = "INSERT INTO emailveri VALUES ('" + femail + "', "
					+ random_number + ");";

			System.out.println(sql + " " + sql1);
			if (s.executeUpdate(sql) == 1) {
				if (s.executeUpdate(sql1) == 1) {
					// EmailVeri ev = new EmailVeri();
					// ev.sendMail(email, random_number);
					if (s.executeUpdate(sql2) == 1) {
						return true;
					}
				}
				return false;
			}
			// return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
		return false;
	}

	public boolean checkEmailAvailble(String email) {

		String query = "select * from login where Email = '" + email + "'";

		try {
			ResultSet rs = s.getResultSet();
			rs = s.executeQuery(query);
			String getemail = null;
			if (rs.next()) {
				getemail = rs.getString("Email");
			}

			if (email.equals(getemail))
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<StudentProfile> getStudentProfile(String email) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ResultSet rs = null;

		String query = "SELECT * FROM `student` where Email = '" + email + "'";

		try {
			rs = s.executeQuery(query);

			ArrayList<StudentProfile> profile = new ArrayList<>();

			while (rs.next()) {
				String getemail = rs.getString("Email");
				String getdob = rs.getString("Dob");
				String getsex = rs.getString("Sex");
				String getmajor = rs.getString("Major");
				String getclassof = rs.getString("Classof");
				String getinterest = rs.getString("Major");
				String getfname = rs.getString("Fname");
				String getlname = rs.getString("Lname");
				StudentProfile studentProfile = new StudentProfile(getfname,
						getlname, getemail, getdob, getsex, getmajor,
						getclassof, getinterest);
				profile.add(studentProfile);
			}
			return profile;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public ArrayList<FacultyProfile> getFacultyProfile(String femail) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ResultSet rs = null;

		String query = "SELECT * FROM `faculty` where Femail = '" + femail + "'";

		try {
			rs = s.executeQuery(query);

			ArrayList<FacultyProfile> profile = new ArrayList<>();

			while (rs.next()) {
				String getFname = rs.getString("Ffname");
				String getLname = rs.getString("Flname");
				String getFemail = rs.getString("Femail");
				String getDob = rs.getString("Fdob");
				String getFsex = rs.getString("Fsex");
				String getFdept = rs.getString("Fdept");
				String getFcourse = rs.getString("Fcourse");
				String getFrarea = rs.getString("Frarea");
				String getFofhours = rs.getString("Fohours");
				String getFofloc = rs.getString("Folocation");
				
				FacultyProfile facultyProfile = new FacultyProfile(getFname, getLname, getFemail, getDob, getFsex,
						getFdept, getFcourse, getFrarea, getFofhours, getFofloc);
				profile.add(facultyProfile);
			}
			return profile;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public boolean verifyMail(String email, int code) {
		String sql = "select * from emailveri where email='" + email + "'";

		try {

			ResultSet rs = s.executeQuery(sql);
			String email1 = "null";
			int code1 = 0;

			while (rs.next()) {
				email1 = rs.getString("Email");
				code1 = rs.getInt("Code");
			}

			if (email.equals(email1) && code == code1) {
				String sql2 = "DELETE FROM emailveri WHERE Email = '" + email
						+ "'";
				String sql3 = "UPDATE login SET Type = '1' WHERE Email = '"
						+ email + "';";
				s.executeUpdate(sql2);
				s.executeUpdate(sql3);
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<GetNewsFeed> getAllFeeds() {

		ResultSet rs = null;

		String query = "SELECT * FROM `newsfeed` ORDER BY time DESC";

		try {
			Statement s = conn.createStatement();
			rs = s.executeQuery(query);

			ArrayList<GetNewsFeed> FeedList = new ArrayList<>();

			while (rs.next()) {
				String ID = rs.getString("ID");
				String datetime = rs.getString("Time");
				String post = rs.getString("Post");
				String parentID = rs.getString("ParentID");
				String email = rs.getString("Email");
				GetNewsFeed feedcontent = new GetNewsFeed(ID, email, parentID,
						post, datetime);
				FeedList.add(feedcontent);
			}
			return FeedList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<GetRoomMateFeed> getAllRoomMateFeeds() {

		ResultSet rs = null;

		String query = "SELECT * FROM `roommatefeed` ORDER BY time DESC";

		try {
			Statement s = conn.createStatement();
			rs = s.executeQuery(query);

			ArrayList<GetRoomMateFeed> FeedList = new ArrayList<>();

			while (rs.next()) {
				String ID = rs.getString("ID");
				String datetime = rs.getString("Time");
				String description = rs.getString("Description");
				String amount = rs.getString("Amount");
				String address = rs.getString("Address");
				String parentID = rs.getString("ParentID");
				String email = rs.getString("Email");
				String roommatetype = rs.getString("roommatetype");
				GetRoomMateFeed feedcontent = new GetRoomMateFeed(ID, email,
						parentID, description, amount, address, datetime,
						roommatetype);
				FeedList.add(feedcontent);
			}
			return FeedList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ArrayList<GetSMarketFeed> getAllMarketFeeds() {

		ResultSet rs = null;

		String query = "SELECT * FROM `marketfeed` ORDER BY time DESC";

		try {
			Statement s = conn.createStatement();
			rs = s.executeQuery(query);

			ArrayList<GetSMarketFeed> FeedList = new ArrayList<>();

			while (rs.next()) {
				String ID = rs.getString("ID");
				String datetime = rs.getString("Time");
				String description = rs.getString("Description");
				String amount = rs.getString("Amount");
				String parentID = rs.getString("ParentID");
				String email = rs.getString("Email");
				String markettype = rs.getString("markettype");
				GetSMarketFeed feedcontent = new GetSMarketFeed(ID, email,
						parentID, description, amount, datetime,
						markettype);
				FeedList.add(feedcontent);
			}
			return FeedList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertNewsFeed(String id, String email, String pid,
			String post, String datenow) {
		String sql = "insert into newsfeed VALUES('" + id + "','" + email
				+ "','" + pid + "','" + post + "','" + datenow + "')";
		try {
			if (s.executeUpdate(sql) == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertRoomMateFeed(String id, String email, String pid,
			String description, String roommatetype, String amount,
			String address, String datenow) {
		String sql = "insert into roommatefeed VALUES('" + id + "','" + email
				+ "','" + pid + "','" + description + "','" + roommatetype
				+ "','" + amount + "','" + address + "', '" + datenow + "')";
		try {
			if (s.executeUpdate(sql) == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertSMarketFeed(String id, String email, String pid,
			String description, String roommatetype, String amount,
			 String datenow) {
		String sql = "insert into marketfeed VALUES('" + id + "','" + email
				+ "','" + pid + "','" + description + "','" + roommatetype
				+ "','" + amount + "','" + datenow + "')";
		try {
			if (s.executeUpdate(sql) == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	public boolean insertPhoto(String email, String photoname) {
		String sql = "UPDATE photo SET PhotoName = '" + photoname
				+ "' WHERE Email = '" + email + "';";
		try {
			if (s.executeUpdate(sql) == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getPhoto(String email) {
		String sql = "select * from photo WHERE Email = '" + email + "';";
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				return rs.getString("PhotoName");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "default.jpg";
	}
	
	public ArrayList<StudentProfile> seachStudent(String search) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ResultSet rs = null;
		String query = "SELECT * FROM `student` where Fname LIKE '%" + search
				+ "%' OR Lname LIKE '%" + search + "%'";
		try {
			rs = s.executeQuery(query);
			ArrayList<StudentProfile> profile = new ArrayList<>();
			while (rs.next()) {
				String getemail = rs.getString("Email");
				String getdob = rs.getString("Dob");
				String getsex = rs.getString("Sex");
				String getmajor = rs.getString("Major");
				String getclassof = rs.getString("Classof");
				String getinterest = rs.getString("Major");
				String getfname = rs.getString("Fname");
				String getlname = rs.getString("Lname");
				StudentProfile studentProfile = new StudentProfile(getfname,
						getlname, getemail, getdob, getsex, getmajor,
						getclassof, getinterest);
				profile.add(studentProfile);
			}
			return profile;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<FacultyProfile> searchFaculty(String search) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ResultSet rs = null;
		String query = "SELECT * FROM `faculty` where Ffname LIKE '%" + search
				+ "%' OR Flname LIKE '%" + search + "%'";
		try {
			rs = s.executeQuery(query);
			ArrayList<FacultyProfile> profile = new ArrayList<>();
			while (rs.next()) {
				String getFname = rs.getString("Ffname");
				String getLname = rs.getString("Flname");
				String getFemail = rs.getString("Femail");
				String getDob = rs.getString("Fdob");
				String getFsex = rs.getString("Fsex");
				String getFdept = rs.getString("Fdept");
				String getFcourse = rs.getString("Fcourse");
				String getFrarea = rs.getString("Frarea");
				String getFofhours = rs.getString("Fohours");
				String getFofloc = rs.getString("Folocation");
				FacultyProfile facultyProfile = new FacultyProfile(getFname,
						getLname, getFemail, getDob, getFsex, getFdept,
						getFcourse, getFrarea, getFofhours, getFofloc);
				profile.add(facultyProfile);
			}
			return profile;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void deletePost(String id){
		String q = "delete from roommatefeed where ID='"+id+"';";
		try {
			s.executeUpdate(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteSmarketPost(String id){
		String q = "delete from marketfeed where ID='"+id+"';";
		try {
			s.executeUpdate(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void deleteNewsfeed(String id){
			String q = "delete from newsfeed where ID='"+id+"';";
			try {
				s.executeUpdate(q);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		
		public ArrayList<FacultyProfile> searchFacultyInterests(String search) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			ResultSet rs = null;
			String query = "SELECT * FROM `faculty` where Fcourse LIKE '%" + search
					+ "%' OR Frarea LIKE '%" + search + "%'";
			try {
				rs = s.executeQuery(query);
				ArrayList<FacultyProfile> profile = new ArrayList<>();
				while (rs.next()) {
					String getFname = rs.getString("Ffname");
					String getLname = rs.getString("Flname");
					String getFemail = rs.getString("Femail");
					String getDob = rs.getString("Fdob");
					String getFsex = rs.getString("Fsex");
					String getFdept = rs.getString("Fdept");
					String getFcourse = rs.getString("Fcourse");
					String getFrarea = rs.getString("Frarea");
					String getFofhours = rs.getString("Fohours");
					String getFofloc = rs.getString("Folocation");
					FacultyProfile facultyProfile = new FacultyProfile(getFname,
							getLname, getFemail, getDob, getFsex, getFdept,
							getFcourse, getFrarea, getFofhours, getFofloc);
					profile.add(facultyProfile);
				}
				return profile;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
}
