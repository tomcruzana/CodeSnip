package com.codesnip.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.codesnip.app.entity.State;

// @RepositoryRestResource
public interface StateRepository extends JpaRepository<State, Integer> {
	List<State> findByCountryCode(@Param("code") String code);
}
