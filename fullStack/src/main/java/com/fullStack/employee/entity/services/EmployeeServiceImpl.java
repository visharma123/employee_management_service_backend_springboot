package com.fullStack.employee.entity.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullStack.employee.entity.EmployeeEntity;
import com.fullStack.employee.entity.model.Employee;
import com.fullStack.employee.entity.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//		this.employeeRepository = employeeRepository;
//	}
	
	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		employeeRepository.save(employeeEntity);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<EmployeeEntity> employeeEntities= employeeRepository.findAll();
		List<Employee> employees = employeeEntities.stream()
				.map(emp -> new Employee(
						emp.getId(),
						emp.getFirstName(),
						emp.getLastName(),
						emp.getEmailId()))
				.collect(Collectors.toList());
		//note you will need no args and all args constructor in employees class
		return employees;
	}

}
