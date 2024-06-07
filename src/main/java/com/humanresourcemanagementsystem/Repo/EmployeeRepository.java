package com.humanresourcemanagementsystem.Repo;

import com.humanresourcemanagementsystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE e.empEmail = :email")
    Optional<Employee> findByEmail(@Param("email") String email);

}
