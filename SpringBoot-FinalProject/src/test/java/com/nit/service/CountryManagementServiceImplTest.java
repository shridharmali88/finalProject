package com.nit.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CountryManagementServiceImplTest {

	@Autowired
	private CountryManagementServiceImpl service;

	@Test
	void testFetchAllCountries() {
		Map<Integer, String> countries = service.fetchAllCountries();
		int size = countries.size();
		boolean isContains = size > 0;
		assertTrue(isContains);
	}
}
