package com.codesnip.app.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.codesnip.app.entity.Snippet;
import com.codesnip.app.entity.SnippetCollection;
import com.codesnip.app.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SnippetCollectionDto {

	private int id;

	private String title;

	private String description;

	@Column(name = "programming_language")
	private String programmingLanguage;

	private Date dateCreated;

	private String link;

	@JsonIgnore
	private User user;

	@JsonIgnore
	private List<Snippet> snippets;

	public SnippetCollectionDto() {

	}

	public SnippetCollectionDto(SnippetCollection snippetCollection) {
		this.id = snippetCollection.getId();
		this.title = snippetCollection.getTitle();
		this.description = snippetCollection.getDescription();
		this.programmingLanguage = snippetCollection.getProgrammingLanguage();
		this.dateCreated = snippetCollection.getDateCreated();
		this.link = snippetCollection.getLink();
		this.user = snippetCollection.getUser();
		this.snippets = snippetCollection.getSnippets();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Snippet> getSnippets() {
		return snippets;
	}

	public void setSnippets(List<Snippet> snippets) {
		this.snippets = snippets;
	}

}
