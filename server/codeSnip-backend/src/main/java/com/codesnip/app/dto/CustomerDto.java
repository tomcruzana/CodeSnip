package com.codesnip.app.dto;

import java.util.Date;

import com.codesnip.app.entity.Customer;

public class CustomerDto {
	private int id;

	private String firstName;

	private String lastName;

	private String username;

	private String email;

	private String password;

	private String role;

	private boolean isEnabled;

	private Date dob;

	private Date dateCreated;

	private String bio;

	private String image;

	public CustomerDto() {

	}

	public CustomerDto(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public CustomerDto(Customer customer) {
		this.id = customer.getId();
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		this.username = customer.getUsername();
		this.email = customer.getEmail();
		this.password = customer.getPassword();
		this.role = customer.getRole();
		this.isEnabled = customer.isEnabled();
		this.dob = customer.getDob();
		this.dateCreated = customer.getDateCreated();
		this.bio = customer.getBio();
		this.image = customer.getImage();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
