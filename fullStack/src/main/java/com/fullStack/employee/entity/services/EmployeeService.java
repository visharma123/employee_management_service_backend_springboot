package com.fullStack.employee.entity.services;

import java.util.List;

import com.fullStack.employee.entity.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

}
