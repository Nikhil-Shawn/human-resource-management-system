package com.humanresourcemanagementsystem.Repo;

import com.humanresourcemanagementsystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
