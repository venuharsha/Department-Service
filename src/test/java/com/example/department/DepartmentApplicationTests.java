package com.example.department;

import com.example.department.dto.DepartmentRequest;
import com.example.department.exception.DepartmentNotFoundException;
import com.example.department.model.Department;
import com.example.department.repository.DepartmentRepository;
import com.example.department.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class DepartmentApplicationTests {

	@MockBean
	DepartmentRepository departmentRepository;

	@Autowired
	DepartmentService departmentService;

	@Test
	void createDepartmentTest() {
		DepartmentRequest d = new DepartmentRequest();
		d.setDeptName("MPC");
		String message = departmentService.createDepartment(d);
		assertEquals("Department created successfully.", message);
	}

	@Test
	void getAllDepartmentsTest() {
		when(departmentRepository.findAll()).thenReturn(Stream.of(new Department("1234", "MPC", "Harsha")).toList());
		assertEquals(1, departmentService.getAllDepartments().size());
	}

	@Test
	void getDepartmentByIdTest() {
		when(departmentRepository.findById("1234")).thenReturn(Optional.of(new Department("1234", "MPC", "")));
		assertEquals("MPC", departmentService.getDepartmentById("1234").getDeptName());
	}

	@Test
	void getDepartmentByIdTest2() {
		when(departmentRepository.findById("1234")).thenReturn(Optional.of(new Department("12345", "MPC", "")));
		assertThrows(DepartmentNotFoundException.class, () -> departmentService.getDepartmentById("12345").getDeptName());
	}

}
