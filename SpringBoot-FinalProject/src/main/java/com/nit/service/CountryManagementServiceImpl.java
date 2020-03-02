package com.nit.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.constants.AppConstants;
import com.nit.entity.CountryEntity;
import com.nit.repo.CountryEntityRepository;

@Service
public class CountryManagementServiceImpl implements CountryManagementService {
	private Logger logger = LoggerFactory.getLogger(CountryManagementServiceImpl.class);
	@Autowired
	private CountryEntityRepository countryRepo;

	@Override
	public Map<Integer, String> fetchAllCountries() {
		logger.debug(AppConstants.METHOD_START);
		Map<Integer, String> countriesMap = new LinkedHashMap<>();
		List<CountryEntity> list = countryRepo.findAll();
		logger.info(AppConstants.REPO_CALL_DONE);
		list.forEach(country -> countriesMap.put(country.getCountryId(), country.getCountryName()));
		logger.debug(AppConstants.METHOD_ENDED);
		return countriesMap;
	}
}
