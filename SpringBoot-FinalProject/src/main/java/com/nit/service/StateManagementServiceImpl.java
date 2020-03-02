package com.nit.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.constants.AppConstants;
import com.nit.entity.StateEntity;
import com.nit.repo.StateEntityRepository;

@Service
public class StateManagementServiceImpl implements StateManagementService {
	private Logger logger = LoggerFactory.getLogger(StateManagementServiceImpl.class);
	@Autowired
	private StateEntityRepository stateRepo;

	@Override
	public Map<Integer, String> getStatesByCountryId(Integer countryId) {
		logger.debug(AppConstants.METHOD_START);
		Map<Integer, String> statesMap = new LinkedHashMap<>();
		List<StateEntity> statesList = stateRepo.findByCountryId(countryId);
		logger.info(AppConstants.REPO_CALL_DONE);
		statesList.forEach(state -> statesMap.put(state.getStateId(), state.getStateName()));
		logger.debug(AppConstants.METHOD_ENDED);
		return statesMap;
	}
}
