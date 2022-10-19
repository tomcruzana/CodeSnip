package com.codesnip.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.codesnip.app.dto.SnippetDto;
import com.codesnip.app.entity.Snippet;
import com.codesnip.app.exception.CodeSnipException;
import com.codesnip.app.repository.SnippetRepository;

@Service
public class SnippetServiceImpl implements SnippetService {

	@Autowired
	private Environment environment;

	@Autowired
	SnippetRepository snippetRepository;

	@Override
	public List<SnippetDto> readAll() throws CodeSnipException {
		List<Snippet> snippetList = snippetRepository.findAll();
		if (snippetList.isEmpty()) {
			throw new CodeSnipException(environment.getProperty("info.warn.empty"));
		}

		// convert to dto
		List<SnippetDto> snippetDtoList = new ArrayList<>();
		snippetList.forEach(snippet -> {
			SnippetDto snippetDto = new SnippetDto(snippet);
			snippetDtoList.add(snippetDto);
		});

		return snippetDtoList;
	}

	@Override
	public void deleteById(int id) throws CodeSnipException {
		snippetRepository.deleteById(id);
	}

}
