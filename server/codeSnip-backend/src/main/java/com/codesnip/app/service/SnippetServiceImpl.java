package com.codesnip.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.codesnip.app.dto.SnippetDto;
import com.codesnip.app.entity.Snippet;
import com.codesnip.app.entity.SnippetCollection;
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

	@Override
	public void updateById(int id, String title) throws CodeSnipException {

		// find the snippet using its id
		Optional<Snippet> snippetOptional = snippetRepository.findById(id);

		// return result set
		Snippet snippet = snippetOptional
				.orElseThrow(() -> new CodeSnipException(environment.getProperty("error.generic")));

		// update field
		snippet.setTitle(title);

		snippetRepository.save(snippet);
	}

}
