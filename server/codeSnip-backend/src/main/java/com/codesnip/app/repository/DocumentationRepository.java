package com.codesnip.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codesnip.app.entity.Documentation;

//@Repository
public interface DocumentationRepository extends CrudRepository<Documentation, Integer> {

}
