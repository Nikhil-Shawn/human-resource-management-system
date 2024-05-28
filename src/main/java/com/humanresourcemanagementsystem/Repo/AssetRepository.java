package com.humanresourcemanagementsystem.Repo;

import com.humanresourcemanagementsystem.Entity.Asset;
import com.humanresourcemanagementsystem.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Asset (name, type, value) VALUES (:name, :type, :value)", nativeQuery = true)
    void insertAsset(@Param("name") String name, @Param("type") String type, @Param("value") double value);

}
