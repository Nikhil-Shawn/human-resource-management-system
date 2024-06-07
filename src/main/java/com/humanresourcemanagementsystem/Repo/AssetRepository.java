package com.humanresourcemanagementsystem.Repo;

import com.humanresourcemanagementsystem.Entity.Asset;
import com.humanresourcemanagementsystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AssetRepository extends JpaRepository<Asset, Long> {
    // Check if the employee already has an asset assigned
    boolean existsByEmployee(Employee employee);
}

