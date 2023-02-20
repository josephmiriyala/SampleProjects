package com.learning.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entities.Employee;
import com.learning.entities.EmployeeId;
import com.learning.repositories.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee findEmployee(Employee employee) {
		Optional<Employee> emp = Optional.empty();
		EmployeeId empId = new EmployeeId(employee.getEmployeeId(), employee.getEmployeeName());
		emp = employeeRepo.findById(empId);
		return emp.isPresent() ? emp.get() : null;
	}

	public Employee pickARandomEmployee() {
		List<Employee> employeeList = employeeRepo.findAll();
		List<Employee> filteredList = new ArrayList<>();
		Random random = new Random();
		Employee emp = null;
		if (employeeList != null) {
			filteredList = employeeList.stream().filter(x -> !x.getIsPresented()).collect(Collectors.toList());
			int index = random.ints(0, filteredList.size()).findAny().getAsInt();
			emp = filteredList.get(index);
		}
		return emp;
	}

	public Employee updateEmployee(Employee employee) {
		Employee emp = findEmployee(employee);
		if (emp != null) {
			emp.setIsPresented(employee.getIsPresented());
			return employeeRepo.save(emp);
		}
		return emp;
	}

}
