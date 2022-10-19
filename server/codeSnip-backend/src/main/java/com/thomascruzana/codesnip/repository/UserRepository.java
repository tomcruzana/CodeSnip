package com.thomascruzana.codesnip.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thomascruzana.codesnip.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	public List<User> findByEmail(String email);
}
