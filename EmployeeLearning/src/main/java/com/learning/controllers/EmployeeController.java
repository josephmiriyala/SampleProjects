package com.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entities.Employee;
import com.learning.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/home")
	public String home() {
		return "Welcome Home";
	}

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		try {
			Employee emp = employeeService.saveEmployee(employee);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/find")
	public ResponseEntity<Employee> findEmployee(@RequestBody Employee employee) {
		try {
			Employee emp = employeeService.findEmployee(employee);
			if(ObjectUtils.isEmpty(emp)) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/pickARandomEmployee")
	public ResponseEntity<Employee> pickARandomEmployee(){
		try {
			Employee emp = employeeService.pickARandomEmployee();
			if(ObjectUtils.isEmpty(emp)) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		try {
			Employee emp = employeeService.updateEmployee(employee);
			if(ObjectUtils.isEmpty(emp)) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}
