package com.nit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.constants.AppConstants;
import com.nit.entity.EmployeeEntity;
import com.nit.repo.EmployeeEntityRepository;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {
	private Logger logger=LoggerFactory.getLogger(EmployeeManagementServiceImpl.class);
	@Autowired
	private EmployeeEntityRepository empRepo;
	
	@Override
	public boolean isUniqueEmail(String email) {
		logger.debug(AppConstants.METHOD_START);
		EmployeeEntity employeeEntity = empRepo.findByEmail(email);
		logger.debug(AppConstants.REPO_CALL_DONE);
		logger.debug(AppConstants.METHOD_ENDED);
		if(employeeEntity!=null) 
			return employeeEntity.getEmployeeId()>0;
		return true;
	}
}
