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
import com.thomascruzana.codesnip.service.SnippetService;

@RestController
public class SnippetController {

	@Autowired
	private Environment environment;

	@Autowired
	private SnippetService snippetService;

	@GetMapping("/snippet")
	public ResponseEntity<List<SnippetDto>> getAllSnippets() throws Exception {
		List<SnippetDto> snippetDtos = snippetService.readAll();
		return new ResponseEntity<>(snippetDtos, HttpStatus.OK);
	}

	@DeleteMapping("/snippet/{id}")
	public ResponseEntity<String> daletSnippet(@PathVariable int id) throws Exception {
		snippetService.deleteById(id);
		String deleteSuccessMessage = environment.getProperty("api.delete.success");
		return new ResponseEntity<>(deleteSuccessMessage, HttpStatus.OK);
	}

	@PatchMapping("/snippet")
	public ResponseEntity<String> updateSnippetTitle(@RequestParam int id, @RequestParam String title)
			throws Exception {
		// update entity
		snippetService.updateById(id, title);
		String updateSuccessMessage = environment.getProperty("api.update.success");
		return new ResponseEntity<>(updateSuccessMessage, HttpStatus.OK);
	}

	@PatchMapping("/snippet/save/{id}")
	public ResponseEntity<String> updateSnippetCode(@PathVariable int id, @RequestBody() String code)
			throws Exception {
		// update entity
		snippetService.saveById(id, code);
		String updateSuccessMessage = environment.getProperty("api.update.success");
		return new ResponseEntity<>(updateSuccessMessage, HttpStatus.OK);
	}

	@PostMapping("/snippet/add")
	public ResponseEntity<String> createSnippetCollection(@RequestParam int collectionId, @RequestParam String title)
			throws Exception {
		snippetService.createSnippet(collectionId, title);
		String createSuccessMessage = environment.getProperty("api.create.success");
		return new ResponseEntity<>(createSuccessMessage, HttpStatus.CREATED);
	}
}