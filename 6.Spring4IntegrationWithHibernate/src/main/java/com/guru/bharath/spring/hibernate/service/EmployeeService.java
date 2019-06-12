package com.guru.bharath.spring.hibernate.service;

import java.util.List;

import com.guru.bharath.spring.hibernate.model.Employee;

public interface EmployeeService {


	List<Employee> findAllEmployees();

	Employee findEmployeeBySsn(String ssn);

	Long saveEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	void deleteEmployeeBySsn(String ssn);
}
