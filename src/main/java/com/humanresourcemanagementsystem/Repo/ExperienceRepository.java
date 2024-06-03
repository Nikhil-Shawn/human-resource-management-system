package com.humanresourcemanagementsystem.Repo;

import java.util.Date;
import com.humanresourcemanagementsystem.Entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

}

