package com.jconnect.dto;

import java.io.Serializable;

public class RegisterUserDto implements Serializable {
	
	
	private static final long serialVersionUID = -7412131154468922932L;
	private String firstName;
	private String  lastName;
	private String email;
	private String password;
	private String tel;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	

}
