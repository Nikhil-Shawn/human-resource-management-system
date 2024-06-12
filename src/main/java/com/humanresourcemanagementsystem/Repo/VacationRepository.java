package com.humanresourcemanagementsystem.Repo;

import com.humanresourcemanagementsystem.Entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Long> {
    @Query("SELECT v FROM Vacation v WHERE v.employee.employeeID = :employeeID")
    List<Vacation> findByEmployeeId(@Param("employeeID") Long employeeId);
}
