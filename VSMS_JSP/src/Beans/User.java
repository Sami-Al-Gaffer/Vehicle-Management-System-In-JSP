package Beans;

import java.util.Date;

public class User {
	private int id;
	private String firstName,lastName,email,password;
	private String mobile,position,address,gender,userType;
	private Date  birthDate;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String fn) {
		this.firstName = fn;
		
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String ln) {
		this.lastName = ln;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mob) {
		this.mobile = mob;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String pos) {
		this.position = pos;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date bd) {
		this.birthDate = bd;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String g) {
		this.gender = g;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String us) {
		this.userType = us;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String add) {
		this.address = add;
	}

	}

