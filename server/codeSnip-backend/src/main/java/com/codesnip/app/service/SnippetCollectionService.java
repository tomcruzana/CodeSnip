package com.codesnip.app.service;

import java.util.List;

import com.codesnip.app.dto.SnippetCollectionDto;
import com.codesnip.app.dto.SnippetDto;
import com.codesnip.app.exception.CodeSnipException;

// service interface
public interface SnippetCollectionService {
	public SnippetCollectionDto readById(int id) throws CodeSnipException;

	public List<SnippetCollectionDto> readAll(int id) throws CodeSnipException;

	public void createSnippetCollection(int userId, SnippetCollectionDto snippetCollectionDto) throws CodeSnipException;

	public void deleteById(int id) throws CodeSnipException;

	public void updateById(int id, String title, String description, String programmingLanguage)
			throws CodeSnipException;

	public List<SnippetDto> readAllSnippetsBySnippetCollectionId(int id) throws CodeSnipException;
}
