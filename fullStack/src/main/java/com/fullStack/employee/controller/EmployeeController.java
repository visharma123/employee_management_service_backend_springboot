package com.fullStack.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullStack.employee.entity.model.Employee;
import com.fullStack.employee.entity.services.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/v1/")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

//	public EmployeeController(EmployeeService employeeService) {
//		this.employeeService = employeeService;
//	}
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();	
	}
}
