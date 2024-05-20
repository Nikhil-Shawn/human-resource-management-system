package com.humanresourcemanagementsystem.Repo;

import com.humanresourcemanagementsystem.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
