package com.nit.resource;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nit.command.Employee;
import com.nit.service.CityManagementService;
import com.nit.service.CountryManagementService;
import com.nit.service.EmployeeManagementService;
import com.nit.service.StateManagementService;

@Controller
public class EmployeeManagementResource {
	@Autowired
	private EmployeeManagementService empMgmtService;
	@Autowired
	private CountryManagementService countryMgmtService;
	@Autowired
	private StateManagementService statesMgmtService;
	@Autowired
	private CityManagementService cityMgmtService;

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
		String msg=null;
		boolean isRegistered = empMgmtService.registerEmployee(emp);
		if(isRegistered)
			msg="REGISTERED SUCCESSFUL";
		else
			msg="REGISTRATION FAILED";
		model.addAttribute("msg", msg);
		return "signup_success";
	}
	
	@GetMapping("/uniqueEmail")
	public @ResponseBody boolean isUniqueEmail(@RequestParam("email") String email) {
		boolean isUnique = empMgmtService.isUniqueEmail(email);
		return isUnique;
	}
	
	@GetMapping("/getStatusByCountryId")
	public @ResponseBody Map<Integer,String> getStateByCountryId(@RequestParam("countryId") Integer countryId ){
		return statesMgmtService.getStatesByCountryId(countryId);
	}
	
	@GetMapping("/getStatusByStateId")
	public @ResponseBody Map<Integer,String> getCityByStateId(@RequestParam("stateId") Integer stateId ){
		return cityMgmtService.getCitiesByStateId(stateId);
	}
}
