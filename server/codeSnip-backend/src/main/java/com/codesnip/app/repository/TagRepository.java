package com.codesnip.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codesnip.app.entity.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, String> {

}
