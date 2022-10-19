package com.thomascruzana.codesnip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thomascruzana.codesnip.entity.Pricing;

//@Repository
public interface PricingRepository extends CrudRepository<Pricing, Integer> {

}
