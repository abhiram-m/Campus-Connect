package model;

public class FacultyProfile {
	
	private String fname;
	private String lname;
	private String femail;
	private String dob;
	private String fsex;
	private String fdept;
	private String fcourse;
	private String frarea;
	private String fofhours;
	private String fofloc;
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getFsex() {
		return fsex;
	}
	public void setFsex(String fsex) {
		this.fsex = fsex;
	}
	public String getFdept() {
		return fdept;
	}
	public void setFdept(String fdept) {
		this.fdept = fdept;
	}
	public String getFcourse() {
		return fcourse;
	}
	public void setFcourse(String fcourse) {
		this.fcourse = fcourse;
	}
	public String getFrarea() {
		return frarea;
	}
	public void setFrarea(String frarea) {
		this.frarea = frarea;
	}
	public String getFofhours() {
		return fofhours;
	}
	public void setFofhours(String fofhours) {
		this.fofhours = fofhours;
	}
	public String getFofloc() {
		return fofloc;
	}
	public void setFofloc(String fofloc) {
		this.fofloc = fofloc;
	}
	
	public FacultyProfile(String fname, String lname, String femail, String dob, String fsex, String fdept,
			String fcourse, String frarea, String fofhours, String fofloc) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.femail = femail;
		this.dob = dob;
		this.fsex = fsex;
		this.fdept = fdept;
		this.fcourse = fcourse;
		this.frarea = frarea;
		this.fofhours = fofhours;
		this.fofloc = fofloc;
	}
	
	

}
