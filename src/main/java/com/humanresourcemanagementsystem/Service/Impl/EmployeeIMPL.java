package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.EmployeeDTO;
import com.humanresourcemanagementsystem.Entity.Employee;
import com.humanresourcemanagementsystem.Entity.Person;
import com.humanresourcemanagementsystem.Repo.EmployeeRepository;
import com.humanresourcemanagementsystem.Service.EmployeeService;
import com.humanresourcemanagementsystem.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeIMPL implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PersonService personService;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {

        // Create a Person entity from the DTO
        Person person = new Person(
                employeeDTO.getPersonID(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getAddress(),
                employeeDTO.getEmail(),
                employeeDTO.getPassword(),
                employeeDTO.getPhone(),
                employeeDTO.getDateOfBirth(),
                employeeDTO.getGender(),
                employeeDTO.getNationality(),
                employeeDTO.getMaritalStatus(),
                employeeDTO.getPersonType()
        );

        // Save the Person entity
        Person savedPerson = personService.savePerson(person);

        // Create an Employee entity and set the person
        Employee employee = new Employee(savedPerson, employeeDTO.getDesignation());

        // Save the Employee entity
        employeeRepository.save(employee);

        return employee.getPerson().getFirstName();
    }
}
