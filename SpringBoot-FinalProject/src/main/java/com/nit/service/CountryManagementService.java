package com.nit.service;

import java.util.Map;

@FunctionalInterface
public interface CountryManagementService {
	public Map<Integer,String> fetchAllCountries();
}
