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

//   @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Experience e " +
//            "WHERE e.company_name = :company_name AND e.employment_type = :employment_type AND " +
//            "e.no_of_years = :no_of_years AND e.position = :position AND e.start_date = :start_date AND " +
//            "e.end_date = :end_date")
//   boolean existsByDetails(
//                            @Param("company_name") String company_name,
//                            @Param("employment_type") String employment_type,
//                            @Param("no_of_years") String no_of_years,
//                            @Param("position") String position,
//                            @Param("start_date") Date start_date,
//                            @Param("end_date") Date end_date);
}

