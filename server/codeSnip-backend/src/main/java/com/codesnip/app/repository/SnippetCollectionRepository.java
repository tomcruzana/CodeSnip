package com.codesnip.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codesnip.app.entity.SnippetCollection;

@Repository
public interface SnippetCollectionRepository extends CrudRepository<SnippetCollection, Integer> {

	Optional<SnippetCollection> findById(int id);

	List<SnippetCollection> findAll();
}
