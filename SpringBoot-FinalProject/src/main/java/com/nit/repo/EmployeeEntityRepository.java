package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.EmployeeEntity;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Integer> {
	public EmployeeEntity findByEmail(String email);
	
	@Modifying
	@Query("UPDATE EmployeeEntity SET accountStatus= :status WHERE email= :email")
	public int updateEmployeeAccountStatus(String email,String status);
	
}
