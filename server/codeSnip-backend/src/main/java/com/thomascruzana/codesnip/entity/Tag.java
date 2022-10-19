package com.thomascruzana.codesnip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag {

	@Id
	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "snippet_collection_id")
	private SnippetCollection snippetCollection;

	public Tag() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SnippetCollection getSnippetCollection() {
		return snippetCollection;
	}

	public void setSnippetCollection(SnippetCollection snippetCollection) {
		this.snippetCollection = snippetCollection;
	}

}
