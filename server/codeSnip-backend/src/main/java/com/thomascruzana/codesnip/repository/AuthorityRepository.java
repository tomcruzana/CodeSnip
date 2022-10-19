package com.thomascruzana.codesnip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thomascruzana.codesnip.entity.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

}
