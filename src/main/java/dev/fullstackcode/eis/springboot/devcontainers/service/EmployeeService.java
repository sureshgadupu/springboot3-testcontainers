package dev.fullstackcode.eis.springboot.devcontainers.service;


import dev.fullstackcode.eis.springboot.devcontainers.entity.Department;
import dev.fullstackcode.eis.springboot.devcontainers.entity.Employee;
import dev.fullstackcode.eis.springboot.devcontainers.entity.Gender;
import dev.fullstackcode.eis.springboot.devcontainers.repository.DepartmentRepository;
import dev.fullstackcode.eis.springboot.devcontainers.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Integer id) {
		return employeeRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with id :" + id));
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee updateEmpDepartment(Integer emp_id, Integer dept_id) {
		Employee employee = employeeRepository.findById(emp_id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with id : " + emp_id));

		Department department = departmentRepository.findById(dept_id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found with id : " + emp_id));
		;

		employee.setDepartment(department);
		employeeRepository.save(employee);

		return employee;
	}

	public List<Employee> findEmployeesByGender(Gender gender) {
		return employeeRepository.findByGender(gender);
	}

	public List<Employee> searchEmployeesByGender(Gender gender) {
		return employeeRepository.searchByGender(gender);
	}

	public Employee updateEmployee(Employee employee) {
		employeeRepository.findById(employee.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Employee not found with id : " + employee.getId()));
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

}
