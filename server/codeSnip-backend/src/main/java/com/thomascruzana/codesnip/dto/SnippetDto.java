package com.thomascruzana.codesnip.dto;

import java.util.Date;

import com.thomascruzana.codesnip.entity.Snippet;
import com.thomascruzana.codesnip.entity.SnippetCollection;

//data transfer object for snippet
public class SnippetDto {

	private int id;

	private String title;

	private boolean isPublic;

	private String programmingLanguage;

	private Date dateCreated;

	private String code;

	private SnippetCollection snippetCollection;

	public SnippetDto() {
	}

	public SnippetDto(Snippet snippet) {
		this.code = snippet.getCode();
		this.dateCreated = snippet.getDateCreated();
		this.id = snippet.getId();
		this.isPublic = snippet.isPublic();
		this.programmingLanguage = snippet.getProgrammingLanguage();
		this.snippetCollection = snippet.getSnippetCollection();
		this.title = snippet.getTitle();
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
