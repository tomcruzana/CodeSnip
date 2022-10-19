package com.codesnip.app.service;

import java.util.List;

import com.codesnip.app.dto.SnippetDto;
import com.codesnip.app.exception.CodeSnipException;

public interface SnippetService {
	List<SnippetDto> readAll() throws CodeSnipException;
}
