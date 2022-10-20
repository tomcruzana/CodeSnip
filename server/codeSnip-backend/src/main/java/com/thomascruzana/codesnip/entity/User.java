package com.thomascruzana.codesnip.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
//model class. uses hibernate as ORM 
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fname")
	private String firstName;

	@Column(name = "lname")
	private String lastName;

	@NotNull
	@Column(name = "username", length = 32)
	private String username;

	@NotNull
	@Column(name = "email", length = 128)
	private String email;

	// dont include in serialization
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotNull
	@Column(name = "password", length = 512)
	private String password;

	@NotNull
	@Column(name = "enabled")
	private boolean isEnabled;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_brith")
	private Date dob;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "date_created")
	private Date dateCreated;

	@Column(name = "bio")
	private String bio;

	@Column(name = "image", length = 256)
	private String image;

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<Authority> authorities;

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SnippetCollection> snippetCollection;

	public User() {

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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public List<SnippetCollection> getSnippetCollection() {
		return snippetCollection;
	}

	public void setSnippetCollection(List<SnippetCollection> snippetCollection) {
		this.snippetCollection = snippetCollection;
	}

}
