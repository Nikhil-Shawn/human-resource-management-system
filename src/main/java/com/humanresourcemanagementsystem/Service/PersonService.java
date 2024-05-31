package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.PersonDTO;
import com.humanresourcemanagementsystem.Entity.Person;

import java.util.List;

public interface PersonService {
    Person savePerson(Person person);
    Person getPersonById(int id);
}