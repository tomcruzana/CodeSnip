package com.codesnip.app.dto;

import com.codesnip.app.entity.SnippetCollection;

public class TagDto {
	private String name;

	private SnippetCollection snippetCollection;

	public TagDto() {

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
