package dev.fullstackcode.eis.springboot.devcontainers.service;


import dev.fullstackcode.eis.springboot.devcontainers.entity.Department;
import dev.fullstackcode.eis.springboot.devcontainers.repository.DepartmentRepository;
import dev.fullstackcode.eis.springboot.devcontainers.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	public Department getDepartmentById(Integer id) {
		return departmentRepository.getById(id);
	}

}
