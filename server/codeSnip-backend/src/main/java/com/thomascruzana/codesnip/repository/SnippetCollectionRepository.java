package com.thomascruzana.codesnip.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thomascruzana.codesnip.entity.Snippet;
import com.thomascruzana.codesnip.entity.SnippetCollection;

//repo class that is responsible for CRUD operations of the entity
@Repository
public interface SnippetCollectionRepository extends CrudRepository<SnippetCollection, Integer> {

	public Optional<SnippetCollection> findById(int id);

	public List<SnippetCollection> findAll();

	@Query("SELECT s FROM Snippet s INNER JOIN s.snippetCollection r WHERE r.id = :id ")
	List<Snippet> findSnippetCollectionBySnippetId(@Param("id") int id);
	
}
