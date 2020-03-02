package com.nit.resource;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.command.Employee;
import com.nit.service.CountryManagementService;
import com.nit.service.EmployeeManagementService;

@Controller
public class EmployeeManagementResource {
	@Autowired
	private EmployeeManagementService empMgmtService;
	@Autowired
	private CountryManagementService countryMgmtService;

	@GetMapping("/welcome.htm")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/signup")
	public String showSingupForm(@ModelAttribute("emp")Employee emp,Model model) {
		Map<Integer, String> countriesMap = countryMgmtService.fetchAllCountries();
		model.addAttribute("countriesMap", countriesMap);
		return "signup_form";
	}
	
	@PostMapping("/signup")
	public String processSingupForm(Employee emp,Model model) {
		System.out.println(emp);
		return "signup_success";
	}
}
