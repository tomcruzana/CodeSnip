package com.thomascruzana.codesnip.service;

import java.util.List;

import com.thomascruzana.codesnip.dto.SnippetDto;
import com.thomascruzana.codesnip.exception.CodeSnipException;

public interface SnippetService {
	List<SnippetDto> readAll() throws CodeSnipException;

	public void deleteById(int id) throws CodeSnipException;

	public void updateById(int id, String title) throws CodeSnipException;

	public void saveById(int id, String code) throws CodeSnipException;

	public void createSnippet(int collectionId, String title) throws CodeSnipException;
}
