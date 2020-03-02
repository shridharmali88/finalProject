package com.nit.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.nit.entity.EmployeeEntity;
import com.nit.repo.EmployeeEntityRepository;

@SpringBootTest
class EmployeeManagementServiceImplTest {
	@InjectMocks
	private EmployeeManagementServiceImpl empService;
	@Mock
	private EmployeeEntityRepository empRepo;

	@Test
	void testIsUniqueEmail01() {
		when(empRepo.findByEmail("shridharmali@gmail.com"))
			.thenReturn(new EmployeeEntity(501, "Shri", "Mali", "shridharmali@gmail.com", 123467L, new Date(), "M", 101, 201, 301, "SH5JSD", "LOCKED", new Date(), null));
		boolean isUniqueEmail = empService.isUniqueEmail("shridharmali@gmail.com");
		assertFalse(isUniqueEmail);
	}
	
	@Test
	void testIsUniqueEmail02() {
		when(empRepo.findByEmail("shridharmali@gmail.com"))
			.thenReturn(new EmployeeEntity(501, "Shri", "Mali", "shridharmali@gmail.com", 123467L, new Date(), "M", 101, 201, 301, "SH5JSD", "LOCKED", new Date(), null));
		boolean isUniqueEmail = empService.isUniqueEmail("malishridhar@gmail.com");
		assertTrue(isUniqueEmail);
	}
}
