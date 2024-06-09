package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Entity.Person;
import com.humanresourcemanagementsystem.Repo.PersonRepository;
import com.humanresourcemanagementsystem.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PersonIMPL implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    //Save person
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    //Display Person details by ID
    public Person getPersonById(int id) {
        Optional<Person> personOpt = personRepository.findById(id);
        if (personOpt.isPresent()) {
            return personOpt.get();
        } else {
            throw new RuntimeException("Person not found with id: " + id);
        }
    }

}