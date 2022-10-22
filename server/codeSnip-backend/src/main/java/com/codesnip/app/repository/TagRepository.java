package com.codesnip.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codesnip.app.entity.Tag;

//repo class that is responsible for CRUD operations of the entity
@Repository
public interface TagRepository extends CrudRepository<Tag, String> {
	// To be implemented
	
	
}
