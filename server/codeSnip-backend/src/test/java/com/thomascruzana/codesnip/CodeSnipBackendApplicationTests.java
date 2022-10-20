package com.thomascruzana.codesnip;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.thomascruzana.codesnip.dto.SnippetCollectionDto;
import com.thomascruzana.codesnip.entity.SnippetCollection;
import com.thomascruzana.codesnip.entity.User;
import com.thomascruzana.codesnip.exception.CodeSnipException;
import com.thomascruzana.codesnip.repository.SnippetCollectionRepository;

@SpringBootTest
class CodeSnipBackendApplicationTests {

	@Autowired
	SnippetCollectionRepository snippetCollectionRepository;

	@Autowired
	private Environment environment;

	@Test
	void contextLoads() {
	}
	// REPO TEST
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
	
	@ParameterizedTest
	@ValueSource(strings = {"abc","ABC","123"})
	public void createSnippetCollectionTest(String title) throws CodeSnipException {
		SnippetCollection snippetCollection = new SnippetCollection();

		snippetCollection.setTitle(title);


		// snippetCollection.setSnippets(List<Snippet>);
		User user = new User();
		user.setId(1); // get from session
		snippetCollection.setUser(user); // must be same as user id

		snippetCollectionRepository.save(snippetCollection);
	}
}
