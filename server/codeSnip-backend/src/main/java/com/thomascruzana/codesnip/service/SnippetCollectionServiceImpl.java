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
import com.thomascruzana.codesnip.repository.SnippetRepository;

@Service
public class SnippetCollectionServiceImpl implements SnippetCollectionService {

	@Autowired
	private Environment environment;

	@Autowired
	private SnippetCollectionRepository snippetCollectionRepository;

	@Autowired
	private SnippetRepository snippetRepository;

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
	// also create an empty snippet
	@Override
	public void createSnippetCollection(int userId, SnippetCollectionDto snippetCollectionDto)
			throws CodeSnipException {

		// create the snippet collection
		SnippetCollection snippetCollection = new SnippetCollection();

		snippetCollection.setTitle(snippetCollectionDto.getTitle());
		snippetCollection.setDescription(snippetCollectionDto.getDescription());
		snippetCollection.setProgrammingLanguage(snippetCollectionDto.getProgrammingLanguage());
		snippetCollection.setDateCreated(new Date(System.currentTimeMillis()));

		// snippetCollection.setSnippets(List<Snippet>);
		User user = new User();
		user.setId(userId); // get from session
		snippetCollection.setUser(user); // user id of the user currently in the session

		SnippetCollection newlyCreatedSnippetCollection = snippetCollectionRepository.save(snippetCollection);

		System.out.println("LOG>>> Newly Created SnippetCollection id " + newlyCreatedSnippetCollection.getId() + "<<<");

		// create the snippet
		Snippet newSnippet = new Snippet();
		newSnippet.setTitle("UNTITLED SNIPPET");
		newSnippet.setSnippetCollection(newlyCreatedSnippetCollection);
		newSnippet.setCode("// code goes here");
		newSnippet.setDateCreated(new Date(System.currentTimeMillis()));
		newSnippet.setProgrammingLanguage("java");
		newSnippet.setPublic(false);

		snippetRepository.save(newSnippet);

		System.out.println(
				"LOG>>> Snippet Merged into the SnippetCollection id" + newlyCreatedSnippetCollection.getId() + "<<<");

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

	// deletes a snippet collection via id and calls its matching repository
	// component
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

	@Override // get all snippets based on SnippetCollectionId
	public List<SnippetDto> readAllSnippetsBySnippetCollectionId(int id) throws CodeSnipException {
		List<Snippet> snippets = snippetCollectionRepository.findSnippetCollectionBySnippetId(id);

		// if list is empty return blank
		if (snippets.isEmpty()) {
			throw new CodeSnipException(environment.getProperty("info.warn.empty"));
		}

		// convert to dto list
		List<SnippetDto> SnippetDtos = new ArrayList<>();
		snippets.forEach((snippet) -> {
			SnippetDto snippetDto = new SnippetDto(snippet);
			SnippetDtos.add(snippetDto);
		});

		return SnippetDtos;
	}

}
