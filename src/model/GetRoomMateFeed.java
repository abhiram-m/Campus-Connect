package model;

public class GetRoomMateFeed {
	private String ID;
	private String Email;
	private String ParentID;
	private String Description;
	private String Amount;
	private String Address;
	private String Time;
	private String roommatetype;
	
	public String getRoommatetype() {
		return roommatetype;
	}
	public void setRoommatetype(String roommatetype) {
		this.roommatetype = roommatetype;
	}
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public GetRoomMateFeed(String iD, String email, String parentID,
			String description, String amount, String address, String time,
			String Roommatetype) {
		super();
		ID = iD;
		Email = email;
		ParentID = parentID;
		Description = description;
		Amount = amount;
		Address = address;
		Time = time;
		roommatetype = Roommatetype;
	}

	
}
