package com.mindtree.entity;
import javax.persistence.*;
@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="email")
	private String email;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String passowrd;
	
	
	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param email
	 * @param username
	 * @param passowrd
	 */
	public User(String email, String username, String passowrd) {
		this.email = email;
		this.username = username;
		this.passowrd = passowrd;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassowrd() {
		return passowrd;
	}


	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	
	
	
}
