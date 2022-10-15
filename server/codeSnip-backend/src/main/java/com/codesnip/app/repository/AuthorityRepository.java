package com.codesnip.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codesnip.app.entity.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

}
