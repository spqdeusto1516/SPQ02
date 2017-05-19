package org.models;

public class User {
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private long birthDate;
	private String countryCode;
	private int phone;
	private String password;
    private Address address;
    public User(){
    	
    }
    public User(String email, long birthDate, String countryCode, int phone, String password, Address address){
    	this.email = email;
    	this.birthDate = birthDate;
    	this.countryCode = countryCode;
    	this.phone = phone;
    	this.password = password;
    	this.address = address;
    }
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public long getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(long birthDate) {
		this.birthDate = birthDate;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    public String getPassword() {
        return password;
    }
}
