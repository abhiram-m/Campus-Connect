package model;

public class StudentProfile {

	private String fname;
	private String lname;
	private String email;
	private String dob;
	private String sex;
	private String major;
	private String classof;
	private String stuinterest;
	private String photopath;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getClassof() {
		return classof;
	}

	public void setClassof(String classof) {
		this.classof = classof;
	}

	public String getStuinterest() {
		return stuinterest;
	}

	public void setStuinterest(String stuinterest) {
		this.stuinterest = stuinterest;
	}
	
	public String getPhotopath() {
		return photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}

	public StudentProfile(String fname, String lname, String email, String dob,
			String sex, String major, String classof, String stuinterest) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.dob = dob;
		this.sex = sex;
		this.major = major;
		this.classof = classof;
		this.stuinterest = stuinterest;
	}

}
