package com.codesnip.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codesnip.app.dto.SnippetCollectionDto;
import com.codesnip.app.service.SnippetCollectionService;

@RestController
public class SnippetCollectionController {

	@Autowired
	private Environment environment;

	@Autowired
	private SnippetCollectionService snippetCollectionService;

	@GetMapping("/snippetcollection/{id}")
	public ResponseEntity<SnippetCollectionDto> getSnippetCollections(@PathVariable int id) throws Exception {
		SnippetCollectionDto snippetCollectionDto = snippetCollectionService.readById(id);
		return new ResponseEntity<>(snippetCollectionDto, HttpStatus.OK);
	}

	@PostMapping("/snippetcollection")
	public ResponseEntity<String> createSnippetCollection(@RequestBody SnippetCollectionDto snippetCollectionDto)
			throws Exception {
		snippetCollectionService.createSnippetCollection(snippetCollectionDto);
		String successMessage = environment.getProperty("api.create.success");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

}
