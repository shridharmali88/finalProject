package com.nit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.CityEntity;

public interface CityEntityRepository extends JpaRepository<CityEntity, Integer> {

	public List<CityEntity> findByStateId(Integer stateId);

}
