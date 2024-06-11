package com.humanresourcemanagementsystem.Repo;

import com.humanresourcemanagementsystem.Entity.Employee;
import com.humanresourcemanagementsystem.Entity.Separation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SeparationRepository extends JpaRepository<Separation, Long> {
    // Check if the employee already has a separation
    boolean existsByEmployee(Employee employee);
}

