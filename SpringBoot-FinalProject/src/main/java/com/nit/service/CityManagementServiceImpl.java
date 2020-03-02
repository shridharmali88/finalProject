package com.nit.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.constants.AppConstants;
import com.nit.entity.CityEntity;
import com.nit.repo.CityEntityRepository;

@Service
public class CityManagementServiceImpl implements CityManagementService {
	private Logger logger = LoggerFactory.getLogger(CityManagementServiceImpl.class);
	@Autowired
	private CityEntityRepository cityRepo;

	@Override
	public Map<Integer, String> getCitiesByStateId(Integer stateId) {
		logger.debug(AppConstants.METHOD_START);
		Map<Integer, String> citiesMap = new LinkedHashMap<>();
		List<CityEntity> citiesList = cityRepo.findByStateId(stateId);
		logger.info(AppConstants.REPO_CALL_DONE);
		citiesList.forEach(city -> citiesMap.put(city.getCityId(), city.getCityName()));
		logger.debug(AppConstants.METHOD_ENDED);
		return citiesMap;
	}

}
