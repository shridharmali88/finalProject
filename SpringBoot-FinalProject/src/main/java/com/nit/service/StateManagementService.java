package com.nit.service;

import java.util.Map;

@FunctionalInterface
public interface StateManagementService {
	public Map<Integer,String> getStatesByCountryId(Integer countryId);
}
