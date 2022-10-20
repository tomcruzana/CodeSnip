package com.thomascruzana.codesnip.service;

import java.util.List;

import com.thomascruzana.codesnip.dto.SnippetCollectionDto;
import com.thomascruzana.codesnip.dto.SnippetDto;
import com.thomascruzana.codesnip.exception.CodeSnipException;

// service interface
public interface SnippetCollectionService {
	public SnippetCollectionDto readById(int id) throws CodeSnipException;

	public List<SnippetCollectionDto> readAll() throws CodeSnipException;

	public void createSnippetCollection(SnippetCollectionDto snippetCollectionDto) throws CodeSnipException;

	public void deleteById(int id) throws CodeSnipException;

	public void updateById(int id, String title, String description, String programmingLanguage)
			throws CodeSnipException;

	public List<SnippetDto> readAllSnippetsBySnippetCollectionId(int id) throws CodeSnipException;
}
