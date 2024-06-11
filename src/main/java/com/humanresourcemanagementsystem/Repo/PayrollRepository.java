package com.humanresourcemanagementsystem.Repo;

import com.humanresourcemanagementsystem.Entity.Asset;
import com.humanresourcemanagementsystem.Entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    //List<Payroll> findByEmployeeID(Long employeeId);
    @Query("SELECT p FROM Payroll p WHERE p.employee.id = :employeeId")
    List<Payroll> findByEmployeeId(@Param("employeeId") Long employeeId);
}
