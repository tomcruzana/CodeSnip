package com.thomascruzana.codesnip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thomascruzana.codesnip.entity.Tag;

//repo class that is responsible for CRUD operations of the entity
@Repository
public interface TagRepository extends CrudRepository<Tag, String> {
	// To be implemented
}
