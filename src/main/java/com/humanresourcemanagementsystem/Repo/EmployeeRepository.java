package com.humanresourcemanagementsystem.Repo;

import com.humanresourcemanagementsystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
