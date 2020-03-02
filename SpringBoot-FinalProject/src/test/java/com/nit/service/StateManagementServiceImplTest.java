package com.nit.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.nit.entity.StateEntity;
import com.nit.repo.StateEntityRepository;

@SpringBootTest
class StateManagementServiceImplTest {

	@Mock
	private StateEntityRepository stateRepo;

	@InjectMocks
	private StateManagementServiceImpl StateMgmtService;

	@Test
	void testGetStatesByCountryId01() {
		when(stateRepo.findByCountryId(101)).thenReturn(Arrays.asList(new StateEntity(101, "MH", 11),
				new StateEntity(102, "TH", 11), new StateEntity(103, "UP", 11)));
		Map<Integer, String> countryMap = StateMgmtService.getStatesByCountryId(101);
		int size = countryMap.size();
		boolean isFetch = size > 0;
		assertTrue(isFetch);
	}
	
	@Test
	void testGetStatesByCountryId02() {
		when(stateRepo.findByCountryId(101)).thenReturn(Arrays.asList(new StateEntity(101, "MH", 11),
				new StateEntity(102, "TH", 11), new StateEntity(103, "UP", 11)));
		Map<Integer, String> countryMap = StateMgmtService.getStatesByCountryId(102);
		int size = countryMap.size();
		boolean isFetch = size > 0;
		assertFalse(isFetch);
	}
}
