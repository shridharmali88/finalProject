package com.nit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.StateEntity;

public interface StateEntityRepository extends JpaRepository<StateEntity, Integer> {
	public List<StateEntity> findByCountryId(Integer countryId);
	
}
