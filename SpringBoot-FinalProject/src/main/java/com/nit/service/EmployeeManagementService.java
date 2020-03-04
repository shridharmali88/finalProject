package com.nit.service;

import com.nit.command.Employee;
import com.nit.command.UnlockEmployeeAccount;

public interface EmployeeManagementService {
	public boolean isUniqueEmail(String email);
	public boolean sendPwdToEmail(String email);
	public boolean registerEmployee(Employee employee);
	public boolean unlockEmployeeAccount(UnlockEmployeeAccount unlockEmployeeAccount);
	public String fetchEmpByEmailAndPassword(String email,String password);

}
