package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.StateEntity;

public interface StateEntityRepository extends JpaRepository<StateEntity, Integer> {

}
