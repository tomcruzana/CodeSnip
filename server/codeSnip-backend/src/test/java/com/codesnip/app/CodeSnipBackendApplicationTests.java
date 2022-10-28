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

	@Test
	void contextLoads() {
	}

}
