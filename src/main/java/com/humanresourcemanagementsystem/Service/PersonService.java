package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Entity.Person;

public interface PersonService {
    //Save person
    Person savePerson(Person person);
    //Get Person by ID
    Person getPersonById(int id);
}