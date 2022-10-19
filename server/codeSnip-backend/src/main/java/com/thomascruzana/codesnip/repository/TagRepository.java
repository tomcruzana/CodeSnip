package com.thomascruzana.codesnip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thomascruzana.codesnip.entity.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, String> {

}
