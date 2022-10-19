package com.codesnip.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codesnip.app.entity.Snippet;
import com.codesnip.app.entity.SnippetCollection;

@Repository
public interface SnippetCollectionRepository extends CrudRepository<SnippetCollection, Integer> {

	public Optional<SnippetCollection> findById(int id);

	public List<SnippetCollection> findAll();

	@Query("SELECT s FROM Snippet s INNER JOIN s.snippetCollection r WHERE r.id = :id ")
	List<Snippet> findSnippetCollectionBySnippetId(@Param("id") int id);
	
}
