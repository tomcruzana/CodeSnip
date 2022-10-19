package com.thomascruzana.codesnip.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thomascruzana.codesnip.entity.Snippet;

@Repository
public interface SnippetRepository extends CrudRepository<Snippet, Integer> {
	public List<Snippet> findAll();
}
