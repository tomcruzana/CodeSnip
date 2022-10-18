package com.codesnip.app.service;

import com.codesnip.app.dto.SnippetCollectionDto;
import com.codesnip.app.exception.CodeSnipException;

public interface SnippetCollectionService {
	public SnippetCollectionDto readById(int id) throws CodeSnipException;
	
	public void createSnippetCollection(SnippetCollectionDto snippetCollectionDto) throws CodeSnipException;
}
