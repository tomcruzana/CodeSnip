package com.codesnip.app.service;

import java.util.List;

import com.codesnip.app.dto.SnippetCollectionDto;
import com.codesnip.app.exception.CodeSnipException;

public interface SnippetCollectionService {
	public SnippetCollectionDto readById(int id) throws CodeSnipException;

	public List<SnippetCollectionDto> readAll() throws CodeSnipException;

	public void createSnippetCollection(SnippetCollectionDto snippetCollectionDto) throws CodeSnipException;
	
	public void deleteById(int id) throws CodeSnipException;
}
