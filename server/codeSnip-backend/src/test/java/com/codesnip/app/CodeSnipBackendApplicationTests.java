package com.codesnip.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.codesnip.app.entity.SnippetCollection;
import com.codesnip.app.exception.CodeSnipException;
import com.codesnip.app.repository.SnippetCollectionRepository;

@SpringBootTest
class CodeSnipBackendApplicationTests {

	@Autowired
	SnippetCollectionRepository snippetCollectionRepository;

	@Autowired
	private Environment environment;

	@Test
	void contextLoads() {
	}

	@Test
	public void deleteSnippetCollectionTest() {
		snippetCollectionRepository.deleteById(3);
	}

	@Test
	public void findSnippetCollectionByIdTest() throws CodeSnipException {
		Optional<SnippetCollection> snippetCollectionOptional = snippetCollectionRepository.findById(1);

		SnippetCollection snippetCollection = snippetCollectionOptional
				.orElseThrow(() -> new CodeSnipException(environment.getProperty("error.generic")));

		assertNotNull(snippetCollection);
	}
}
