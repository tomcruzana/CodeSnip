package com.thomascruzana.codesnip.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.thomascruzana.codesnip.dto.SnippetDto;
import com.thomascruzana.codesnip.entity.Snippet;
import com.thomascruzana.codesnip.entity.SnippetCollection;
import com.thomascruzana.codesnip.entity.User;
import com.thomascruzana.codesnip.exception.CodeSnipException;
import com.thomascruzana.codesnip.repository.SnippetRepository;

@Service
public class SnippetServiceImpl implements SnippetService {

	@Autowired
	private Environment environment;

	@Autowired
	SnippetRepository snippetRepository;

	// reads all snippet and calls its matching repository component
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

	// deletes a snippet via id and calls its matching repository component
	@Override
	public void deleteById(int id) throws CodeSnipException {
		snippetRepository.deleteById(id);
	}

	// updates a snippet via id and calls its matching repository component
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

	// updates a snippet via id and code, then calls its matching repository
	// component
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

	@Override
	public void createSnippet(int collectionId, String title) throws CodeSnipException {

		Snippet snippet = new Snippet();

		// initialize values
		snippet.setTitle(title);
		snippet.setProgrammingLanguage("java");
		snippet.setDateCreated(new Date(System.currentTimeMillis()));
		snippet.setCode("// start coding here");
		snippet.setPublic(false);

		// set foreignkey of SnippetCollection
		SnippetCollection snippetCollection = new SnippetCollection();
		snippetCollection.setId(collectionId); // get from session

		snippet.setSnippetCollection(snippetCollection);

		snippetRepository.save(snippet);
	}

}
