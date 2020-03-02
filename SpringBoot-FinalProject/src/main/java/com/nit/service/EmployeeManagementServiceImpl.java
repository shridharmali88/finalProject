package com.nit.service;

import java.util.UUID;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nit.command.Employee;
import com.nit.command.UnlockEmployeeAccount;
import com.nit.constants.AppConstants;
import com.nit.entity.EmployeeEntity;
import com.nit.repo.EmployeeEntityRepository;
import com.nit.util.MailUtil;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeManagementServiceImpl implements EmployeeManagementService {
	private Logger logger = LoggerFactory.getLogger(EmployeeManagementServiceImpl.class);
	private Supplier<String> tempPassword= ()->UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6).toUpperCase();
	@Autowired
	private EmployeeEntityRepository empRepo;
	@Autowired
	private MailUtil mailUtil;
	
	@Override
	public boolean unlockEmployeeAccount(UnlockEmployeeAccount unlockEmployeeAccount) {
		logger.debug(AppConstants.METHOD_START);
		EmployeeEntity employeeEntity = empRepo.findByEmail(unlockEmployeeAccount.getEmail());
		logger.debug(AppConstants.REPO_CALL_DONE);
		if(employeeEntity !=null && employeeEntity.getPassword().equals(unlockEmployeeAccount.getTempPassword())) {
			employeeEntity.setAccountStatus(AppConstants.ACCOUNT_STATUS_UNLOCKED);
			employeeEntity.setPassword(unlockEmployeeAccount.getNewPassword());
			empRepo.save(employeeEntity);
			logger.debug(AppConstants.METHOD_ENDED);
			return true;
		}
		logger.debug(AppConstants.METHOD_ENDED);
		return false;
	}
	
	@Override
	public boolean registerEmployee(Employee employee) {
		logger.debug(AppConstants.METHOD_START);
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employee.setAccountStatus(AppConstants.ACCOUNT_STATUS_LOCKED);
		employee.setPassword(tempPassword.get());
		BeanUtils.copyProperties(employee, employeeEntity);		
		EmployeeEntity savedEntity = empRepo.save(employeeEntity);
		logger.debug(AppConstants.METHOD_START);
		if (savedEntity != null && savedEntity.getEmployeeId() > 0) {
			mailUtil.sendEmail(savedEntity);
			logger.debug(AppConstants.METHOD_ENDED);
			return true;
		}
		logger.debug(AppConstants.METHOD_ENDED);
		return false;
	}

	@Override
	public boolean isUniqueEmail(String email) {
		logger.debug(AppConstants.METHOD_START);
		EmployeeEntity employeeEntity = empRepo.findByEmail(email);
		System.out.println(employeeEntity);
		logger.debug(AppConstants.REPO_CALL_DONE);
		if (employeeEntity != null) {
			logger.debug(AppConstants.METHOD_ENDED);
			return false;
		}
		logger.debug(AppConstants.METHOD_ENDED);
		return true;
	}
}
