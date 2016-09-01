package model;

public class GetNewsFeed {

	private String ID;
	private String Email;
	private String ParentID;
	private String Post;
	private String Time;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getParentID() {
		return ParentID;
	}
	public void setParentID(String parentID) {
		ParentID = parentID;
	}
	public String getPost() {
		return Post;
	}
	public void setPost(String post) {
		Post = post;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public GetNewsFeed(String iD, String email, String parentID, String post,
			String time) {
		super();
		ID = iD;
		Email = email;
		ParentID = parentID;
		Post = post;
		Time = time;
	}
	
}
