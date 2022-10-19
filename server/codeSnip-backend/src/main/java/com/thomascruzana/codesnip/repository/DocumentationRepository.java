package com.thomascruzana.codesnip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thomascruzana.codesnip.entity.Documentation;

//@Repository
public interface DocumentationRepository extends CrudRepository<Documentation, Integer> {

}
