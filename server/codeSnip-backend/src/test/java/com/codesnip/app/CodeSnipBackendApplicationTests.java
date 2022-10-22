package com.codesnip.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.codesnip.app.entity.Snippet;
import com.codesnip.app.entity.SnippetCollection;
import com.codesnip.app.entity.User;
import com.codesnip.app.exception.CodeSnipException;
import com.codesnip.app.repository.SnippetCollectionRepository;
import com.codesnip.app.repository.SnippetRepository;
import com.codesnip.app.repository.UserRepository;
import com.codesnip.app.service.SnippetCollectionService;
import com.codesnip.app.service.SnippetService;
import com.codesnip.app.service.UserService;

@SpringBootTest
class CodeSnipBackendApplicationTests {
	/**** UNIT TEST CASE ****/
	@Autowired
	private SnippetCollectionRepository snippetCollectionRepository;

	@Autowired
	private SnippetRepository snippetRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Environment environment;

	@Autowired
	private SnippetCollectionService snippetCollectionService;

	@Autowired
	private SnippetService snippetService;

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}
	// REPO TEST

	// snippetCOllection
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
	@ValueSource(strings = { "abc", "ABC", "123" })
	public void createSnippetCollectionTest(String title) throws CodeSnipException {
		SnippetCollection snippetCollection = new SnippetCollection();

		snippetCollection.setTitle(title);

		// snippetCollection.setSnippets(List<Snippet>);
		User user = new User();
		user.setId(1); // get from session
		snippetCollection.setUser(user); // must be same as user id

		snippetCollectionRepository.save(snippetCollection);
	}

	// Snippets
	@Test
	public void findAllSnippetsTest() {
		List<Snippet> snippets = snippetRepository.findAll();
		assertNotNull(snippets, "snippets list is not empty");
	};

	// User
	@ParameterizedTest
	@ValueSource(strings = { "testuser1@email.com", "sadasd@email.com", "1213123@email.com" })
	public void findByUserEmailTest(String email) {
		List<User> userList = userRepository.findByEmail(email);

		assertNotNull(userList.get(0), "user found!");
	};

	// SERVICE TEST
	@Test
	public void snippetCollectionServiceDeleteByIdTest() throws CodeSnipException {
		snippetCollectionService.deleteById(1);
	}

	@Test
	public void snippeServicetDeleteByIdTest() throws CodeSnipException {
		snippetService.deleteById(1);
	}

	@Test
	public void userServiceFindByemailTest() throws CodeSnipException {
		userService.readByEmail("testuser1@email.com");
	}

}
