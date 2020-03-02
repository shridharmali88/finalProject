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

import com.nit.entity.CityEntity;
import com.nit.repo.CityEntityRepository;

@SpringBootTest
class CityManagementServiceImplTest {

	@InjectMocks
	private CityManagementServiceImpl citiesService;
	
	@Mock
	private CityEntityRepository cityRepo;
	
	@Test
	void testGetCitiesByStateId01() {
		when(cityRepo.findByStateId(201)).thenReturn(Arrays.asList(new CityEntity(302,"KOLHAPUR",201),new CityEntity(301,"SANGLI",201)));
		Map<Integer, String> citiesMap = citiesService.getCitiesByStateId(201);
		int size = citiesMap.size();
		boolean isFetched=size>0;
		assertTrue(isFetched);
	}
	
	@Test
	void testGetCitiesByStateId02() {
		when(cityRepo.findByStateId(201)).thenReturn(Arrays.asList(new CityEntity(302,"KOLHAPUR",201),new CityEntity(301,"SANGLI",201)));
		Map<Integer, String> citiesMap = citiesService.getCitiesByStateId(202);
		int size = citiesMap.size();
		boolean isFetched=size>0;
		assertFalse(isFetched);
	}
}
