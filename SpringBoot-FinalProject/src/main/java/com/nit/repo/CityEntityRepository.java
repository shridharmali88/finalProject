package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.CityEntity;

public interface CityEntityRepository extends JpaRepository<CityEntity, Integer> {

}
