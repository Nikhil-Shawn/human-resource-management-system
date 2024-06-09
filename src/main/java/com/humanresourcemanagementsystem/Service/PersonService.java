package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Entity.Person;

public interface PersonService {

    //Save single person
    Person savePerson(Person person);

    //Display person by ID
    Person getPersonById(int id);
}