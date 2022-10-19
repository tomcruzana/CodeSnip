package com.thomascruzana.codesnip.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.thomascruzana.codesnip.dto.SnippetDto;
import com.thomascruzana.codesnip.entity.Snippet;
import com.thomascruzana.codesnip.exception.CodeSnipException;
import com.thomascruzana.codesnip.repository.SnippetRepository;

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

		// update title field
		snippet.setTitle(title);

		snippetRepository.save(snippet);
	}

	@Override
	public void saveById(int id, String code) throws CodeSnipException {

		// find the snippet using its id
		Optional<Snippet> snippetOptional = snippetRepository.findById(id);

		// return result set
		Snippet snippet = snippetOptional
				.orElseThrow(() -> new CodeSnipException(environment.getProperty("error.generic")));

		// update code field
		snippet.setCode(code);

		snippetRepository.save(snippet);

	}

}
