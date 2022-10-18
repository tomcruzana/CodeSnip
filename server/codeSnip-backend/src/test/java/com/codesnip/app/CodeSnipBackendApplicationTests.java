package com.codesnip.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codesnip.app.repository.SnippetCollectionRepository;

@SpringBootTest
class CodeSnipBackendApplicationTests {
	
	@Autowired
	SnippetCollectionRepository snippetCollectionRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void deleteSnippetCollectionTest() {
		snippetCollectionRepository.deleteById(3);
	}

}
