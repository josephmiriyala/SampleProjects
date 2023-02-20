package com.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entities.Employee;
import com.learning.entities.EmployeeId;

public interface EmployeeRepo extends JpaRepository<Employee,EmployeeId>{

}
