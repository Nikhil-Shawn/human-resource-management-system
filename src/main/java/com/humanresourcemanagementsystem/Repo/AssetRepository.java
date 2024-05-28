package com.humanresourcemanagementsystem.Repo;

import com.humanresourcemanagementsystem.Entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {
}
