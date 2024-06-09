package com.humanresourcemanagementsystem.Repo;


import com.humanresourcemanagementsystem.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //This method finds a department entity by its email address
    Optional<Department> findByDepartmentName(String departmentName);
}


