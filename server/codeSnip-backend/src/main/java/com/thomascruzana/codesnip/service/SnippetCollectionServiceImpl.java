package com.thomascruzana.codesnip.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.thomascruzana.codesnip.dto.SnippetCollectionDto;
import com.thomascruzana.codesnip.dto.SnippetDto;
import com.thomascruzana.codesnip.entity.Snippet;
import com.thomascruzana.codesnip.entity.SnippetCollection;
import com.thomascruzana.codesnip.entity.User;
import com.thomascruzana.codesnip.exception.CodeSnipException;
import com.thomascruzana.codesnip.repository.SnippetCollectionRepository;

@Service
public class SnippetCollectionServiceImpl implements SnippetCollectionService {

	@Autowired
	private Environment environment;

	@Autowired
	SnippetCollectionRepository snippetCollectionRepository;

	// reads snippet collection via id and calls its matching repository component
	@Override
	public SnippetCollectionDto readById(int id) throws CodeSnipException {

		SnippetCollectionDto snippetCollectionDto;

		Optional<SnippetCollection> snippetCollectionOptional = snippetCollectionRepository.findById(id);

		SnippetCollection snippetCollection = snippetCollectionOptional
				.orElseThrow(() -> new CodeSnipException(environment.getProperty("error.generic")));

		snippetCollectionDto = new SnippetCollectionDto(snippetCollection);
		return snippetCollectionDto;
	}

	// creates a snippet collection and calls its matching repository component
	@Override
	public void createSnippetCollection(SnippetCollectionDto snippetCollectionDto) throws CodeSnipException {
		SnippetCollection snippetCollection = new SnippetCollection();

		snippetCollection.setTitle(snippetCollectionDto.getTitle());
		snippetCollection.setDescription(snippetCollectionDto.getDescription());
		snippetCollection.setProgrammingLanguage(snippetCollectionDto.getProgrammingLanguage());
		snippetCollection.setDateCreated(new Date(System.currentTimeMillis()));

		// snippetCollection.setSnippets(List<Snippet>);
		User user = new User();
		user.setId(1); // get from session
		snippetCollection.setUser(user); // must be same as user id

		snippetCollectionRepository.save(snippetCollection);
	}

	// reads all snippet collections and calls its matching repository component
	@Override
	public List<SnippetCollectionDto> readAll() throws CodeSnipException {
		List<SnippetCollection> snippetCollectionList = snippetCollectionRepository.findAll();
		if (snippetCollectionList.isEmpty()) {
			throw new CodeSnipException(environment.getProperty("info.warn.empty"));
		}

		// convert to dto
		List<SnippetCollectionDto> snippetCollectionDtoList = new ArrayList<>();
		snippetCollectionList.forEach(snippetCollection -> {
			SnippetCollectionDto snippetCollectionDto = new SnippetCollectionDto(snippetCollection);
			snippetCollectionDtoList.add(snippetCollectionDto);
		});

		return snippetCollectionDtoList;
	}

	// deletes a snippet collection via id and calls its matching repository component
	@Override
	public void deleteById(int id) throws CodeSnipException {
		snippetCollectionRepository.deleteById(id);

	}

	@Override
	public void updateById(int id, String title, String description, String programmingLanguage)
			throws CodeSnipException {

		// find the snippet collection using its id
		Optional<SnippetCollection> snippetCollectionOptional = snippetCollectionRepository.findById(id);

		// return result set
		SnippetCollection snippetCollection = snippetCollectionOptional
				.orElseThrow(() -> new CodeSnipException(environment.getProperty("error.generic")));

		// update fields
		snippetCollection.setTitle(title);
		snippetCollection.setDescription(description);
		snippetCollection.setProgrammingLanguage(programmingLanguage);

		snippetCollectionRepository.save(snippetCollection);
	}

	@Override
	public List<SnippetDto> readAllSnippetsBySnippetCollectionId(int id) throws CodeSnipException {
		List<Snippet> snippets = snippetCollectionRepository.findSnippetCollectionBySnippetId(id);
		if (snippets.isEmpty()) {
			throw new CodeSnipException(environment.getProperty("info.warn.empty"));
		}
		
		// convert to dto list
		List<SnippetDto> SnippetDtos = new ArrayList<>();
		snippets.forEach((snippet)->{
			SnippetDto snippetDto = new SnippetDto(snippet);
			SnippetDtos.add(snippetDto);
		});
		
		return SnippetDtos;
	}

}
