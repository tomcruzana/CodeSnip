package com.thomascruzana.codesnip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thomascruzana.codesnip.dto.SnippetCollectionDto;
import com.thomascruzana.codesnip.dto.SnippetDto;
import com.thomascruzana.codesnip.service.SnippetCollectionService;

//Controller class for user Snippet Collections
@RestController
public class SnippetCollectionController {

	@Autowired
	private Environment environment;

	@Autowired
	private SnippetCollectionService snippetCollectionService;

	// update snippet collection by id and title
	@PatchMapping("/snippetcollection")
	public ResponseEntity<String> updateSnippetCollection(@RequestParam int id, @RequestParam String title,
			@RequestParam String description, @RequestParam String programmingLanguage) throws Exception {
		// update entity
		snippetCollectionService.updateById(id, title, description, programmingLanguage);
		String updateSuccessMessage = environment.getProperty("api.update.success");
		return new ResponseEntity<>(updateSuccessMessage, HttpStatus.OK);
	}

	// fetches all snippet collections
	@GetMapping("/snippetcollection")
	public ResponseEntity<List<SnippetCollectionDto>> getAllSnippetCollections() throws Exception {
		List<SnippetCollectionDto> snippetCollectionDtos = snippetCollectionService.readAll();
		return new ResponseEntity<>(snippetCollectionDtos, HttpStatus.OK);
	}

	// creates an new snippet collection based on its fields
	@PostMapping("/snippetcollection/add/{id}")
	public ResponseEntity<String> createSnippetCollection(@PathVariable int id, @RequestBody SnippetCollectionDto snippetCollectionDto)
			throws Exception {

		snippetCollectionService.createSnippetCollection(id, snippetCollectionDto);
		String createSuccessMessage = environment.getProperty("api.create.success");
		return new ResponseEntity<>(createSuccessMessage, HttpStatus.CREATED);
	}

	// deletes the snippet collection
	@DeleteMapping("/snippetcollection/{id}")
	public ResponseEntity<String> daletSnippetCollection(@PathVariable int id) throws Exception {
		snippetCollectionService.deleteById(id);
		String deleteSuccessMessage = environment.getProperty("api.delete.success");
		return new ResponseEntity<>(deleteSuccessMessage, HttpStatus.OK);
	}

	// fetch all snippets based on Snippet collection id
	@GetMapping("/snippetcollection/snippet")
	public ResponseEntity<List<SnippetDto>> getAllSnippetsBySnippetCollectionId(@RequestParam int id) throws Exception {
		List<SnippetDto> snippetDtos = snippetCollectionService.readAllSnippetsBySnippetCollectionId(id);
		return new ResponseEntity<>(snippetDtos, HttpStatus.OK);
	}
}
