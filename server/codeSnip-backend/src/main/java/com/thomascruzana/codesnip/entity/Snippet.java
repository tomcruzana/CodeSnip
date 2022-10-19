package com.thomascruzana.codesnip.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "snippet")
public class Snippet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	@Column(name = "is_public")
	private boolean isPublic;

	@Column(name = "programming_language")
	private String programmingLanguage;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_created")
	private Date dateCreated;

	@Lob
	private String code;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "snippet_collection_id")
	private SnippetCollection snippetCollection;

	public Snippet() {
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

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public SnippetCollection getSnippetCollection() {
		return snippetCollection;
	}

	public void setSnippetCollection(SnippetCollection snippetCollection) {
		this.snippetCollection = snippetCollection;
	}

}
