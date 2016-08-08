package Organisations;

public class OrganisationInfo {
	
	private String contactPerson;
	private String telephone;
	private String email;
	private int xCoord;
	private int yCoord;
	
	public OrganisationInfo(){}
	
	public OrganisationInfo(String contactPerson, String telephone, String email, int xCoord, int yCoord,
			String address) {
		super();
		this.contactPerson = contactPerson;
		this.telephone = telephone;
		this.email = email;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		Address = address;
	}
	
	String Address;
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getxCoord() {
		return xCoord;
	}
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	public int getyCoord() {
		return yCoord;
	}
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
}
