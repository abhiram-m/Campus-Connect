package model;

public class GetSMarketFeed {
	private String ID;
	private String Email;
	private String ParentID;
	private String Description;
	private String Amount;
	private String Time;
	private String markettype;
	
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
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getMarkettype() {
		return markettype;
	}
	public void setMarkettype(String markettype) {
		this.markettype = markettype;
	}
	
	public GetSMarketFeed(String iD, String email, String parentID,
			String description, String amount, String time,
			String Roommatetype) {
		super();
		ID = iD;
		Email = email;
		ParentID = parentID;
		Description = description;
		Amount = amount;
		Time = time;
		markettype = Roommatetype;
	}
	
}
