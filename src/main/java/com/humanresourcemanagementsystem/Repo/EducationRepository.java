package com.humanresourcemanagementsystem.Repo;
import com.humanresourcemanagementsystem.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
}
