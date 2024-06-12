package com.humanresourcemanagementsystem.Repo;

import com.humanresourcemanagementsystem.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    //Find the person by email ID
    Person findByPersonEmail(String email);
}
