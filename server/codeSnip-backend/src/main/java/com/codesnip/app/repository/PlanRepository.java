package com.codesnip.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.codesnip.app.entity.Plan;

// @RepositoryRestResource
public interface PlanRepository extends JpaRepository<Plan, Integer> {

//	Page<Plan> findByCategoryId(@Param("id") Long id, Pageable pageable);

	Page<Plan> findByNameContaining(@Param("name") String name, Pageable pageable);
}
