package com.nit.command;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UnlockEmployeeAccount {
	private String email;
	private String tempPassword;
	private String newPassword;
	private String confirmPassword;
}
