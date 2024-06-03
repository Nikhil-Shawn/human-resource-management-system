package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.EmployeeDTO;
import com.humanresourcemanagementsystem.Dto.EmployeePersonDTO;
import com.humanresourcemanagementsystem.Entity.Employee;
import com.humanresourcemanagementsystem.Entity.Person;
import com.humanresourcemanagementsystem.Mapper.EmployeeMapper;
import com.humanresourcemanagementsystem.Repo.EmployeeRepository;
import com.humanresourcemanagementsystem.Service.EmployeeService;
import com.humanresourcemanagementsystem.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeIMPL implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            // Fetch associated person information
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setEmployeeID(employee.getEmployeeID());
            employeeDTO.setDesignation(employee.getDesignation());
            // Fetch associated person details
            Person person = personService.getPersonById(employee.getPerson().getPersonID());
            employeeDTO.setPerson(person);
            return employeeDTO;
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

//    @Override
//    public List<EmployeeDTO> getAllEmployees() {
//        List<Employee> employees = employeeRepository.findAll();
//        return employees.stream()
//                .map(employee -> {
//                    EmployeeDTO employeeDTO = new EmployeeDTO();
//                    employeeDTO.setEmployeeID(employee.getEmployeeID());
//                    employeeDTO.setDesignation(employee.getDesignation());
//                    // Fetch associated person details
//                    Person person = personService.getPersonById(employee.getPerson().getPersonID());
//                    employeeDTO.setPerson(person);
//                    return employeeDTO;
//                })
//                .collect(Collectors.toList());
//    }

    //Filtered Get all employees
    @Override
    public List<EmployeePersonDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }


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
