package com.codesnip.app.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.codesnip.app.dto.SnippetCollectionDto;
import com.codesnip.app.entity.SnippetCollection;
import com.codesnip.app.entity.User;
import com.codesnip.app.exception.CodeSnipException;
import com.codesnip.app.repository.SnippetCollectionRepository;

@Service
public class SnippetCollectionServiceImpl implements SnippetCollectionService {

	@Autowired
	private Environment environment;

	@Autowired
	SnippetCollectionRepository snippetCollectionRepository;

	public SnippetCollectionDto readById(int id) throws CodeSnipException {

		SnippetCollectionDto snippetCollectionDto;

		Optional<SnippetCollection> snippetCollectionOptional = snippetCollectionRepository.findById(id);

		SnippetCollection snippetCollection = snippetCollectionOptional
				.orElseThrow(() -> new CodeSnipException(environment.getProperty("error.generic")));

		snippetCollectionDto = new SnippetCollectionDto(snippetCollection);
		return snippetCollectionDto;
	}

	@Override
	public void createSnippetCollection(SnippetCollectionDto snippetCollectionDto) throws CodeSnipException {
		SnippetCollection snippetCollection = new SnippetCollection();

		snippetCollection.setTitle(snippetCollectionDto.getTitle());
		snippetCollection.setDescription(snippetCollectionDto.getDescription());
		snippetCollection.setProgrammingLanguage(snippetCollectionDto.getProgrammingLanguage());
		snippetCollection.setDateCreated(new Date(System.currentTimeMillis()));

//		snippetCollection.setSnippets(List<Snippet>);
		User user = new User();
		user.setId(1);
		snippetCollection.setUser(user); // must be same as user id

		snippetCollectionRepository.save(snippetCollection);
	}

}
