package com.nit.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UnlockEmployeeAccount {
	private String email;
	private String tempPassword;
	private String newPassword;
	private String confirmPassword;
}
