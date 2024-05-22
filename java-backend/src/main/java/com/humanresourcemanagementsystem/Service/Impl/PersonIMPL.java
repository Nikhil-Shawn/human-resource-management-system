package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Entity.Person;
import com.humanresourcemanagementsystem.Repo.PersonRepository;
import com.humanresourcemanagementsystem.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonIMPL implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}