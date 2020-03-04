package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.EmployeeEntity;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Integer> {
	public EmployeeEntity findByEmail(String email);
	public EmployeeEntity findByEmailAndPassword(String email,String password);
}
