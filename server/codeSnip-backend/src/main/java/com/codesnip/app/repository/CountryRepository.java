package com.codesnip.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codesnip.app.entity.Country;

// @RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
