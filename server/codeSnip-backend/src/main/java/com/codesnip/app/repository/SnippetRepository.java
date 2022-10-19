package com.codesnip.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codesnip.app.entity.Snippet;

@Repository
public interface SnippetRepository extends CrudRepository<Snippet, Integer> {
	public List<Snippet> findAll();
}
