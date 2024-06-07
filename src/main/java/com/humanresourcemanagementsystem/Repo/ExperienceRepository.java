package com.humanresourcemanagementsystem.Repo;

import com.humanresourcemanagementsystem.Entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

}

