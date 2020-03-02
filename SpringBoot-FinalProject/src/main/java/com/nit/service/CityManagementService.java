package com.nit.service;

import java.util.Map;

@FunctionalInterface
public interface CityManagementService {
	public Map<Integer,String> getCitiesByStateId(Integer stateId);
}
