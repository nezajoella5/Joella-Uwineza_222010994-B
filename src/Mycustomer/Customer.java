package Mycustomer;

public class Customer {
	
	private int customerid;
	private String firstname;
	private String lastname;
	private String email;
	private String gender;
	
public Customer( int customerid, String firstname,String lastname, String email, String gender) {
	super();
	this.customerid = customerid;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.gender = gender;
	
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public int getCustomerid() {
	return customerid;
}

public void setCustomerid(int customerid) {
	this.customerid = customerid;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
}











