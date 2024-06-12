package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.EmployeeDTO;
import com.humanresourcemanagementsystem.Dto.EmployeePersonDTO;
import com.humanresourcemanagementsystem.Entity.Department;
import com.humanresourcemanagementsystem.Entity.Employee;
import com.humanresourcemanagementsystem.Entity.Person;
import com.humanresourcemanagementsystem.Mapper.EmployeeMapper;
import com.humanresourcemanagementsystem.Repo.DepartmentRepository;
import com.humanresourcemanagementsystem.Repo.EmployeeRepository;
import com.humanresourcemanagementsystem.Repo.PersonRepository;
import com.humanresourcemanagementsystem.Service.EmployeeService;
import com.humanresourcemanagementsystem.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeIMPL implements EmployeeService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public EmployeeDTO getEmployeeById(int id) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            // Map the Employee entity to EmployeeDTO using the mapper
            return employeeMapper.toEmployeeDTO(employee);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

//    @Override
//    public EmployeeDTO getEmployeeById(int id) {
//        Optional<Employee> employeeOpt = employeeRepository.findById(id);
//        if (employeeOpt.isPresent()) {
//            Employee employee = employeeOpt.get();
//            // Fetch associated person information
//            EmployeeDTO employeeDTO = new EmployeeDTO();
//            employeeDTO.setEmployeeID(employee.getEmployeeID());
//            employeeDTO.setDesignation(employee.getDesignation());
//            // Fetch associated person details
//            Person person = personService.getPersonById(employee.getPerson().getPersonID());
//            employeeDTO.setPerson(person);
//            return employeeDTO;
//        } else {
//            throw new RuntimeException("Employee not found with id: " + id);
//        }
//    }

// Backup code in case of failure
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

    public EmployeePersonDTO updateEmployeePerson(int employeeID, EmployeePersonDTO employeePersonDTO) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeID);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            Person person = employee.getPerson();

            // Update employee details
            employee.setDesignation(employeePersonDTO.getDesignation());
            employeeRepository.save(employee);

            // Update person details
            person.setFirstName(employeePersonDTO.getFirstName());
            person.setLastName(employeePersonDTO.getLastName());
            person.setAddress(employeePersonDTO.getAddress());
            person.setPersonEmail(employeePersonDTO.getEmail());
            person.setPersonPassword(passwordEncoder.encode(employeePersonDTO.getPassword()));
            person.setPhone(employeePersonDTO.getPhone());
            person.setDateOfBirth(employeePersonDTO.getDateOfBirth());
            person.setGender(employeePersonDTO.getGender());
            person.setNationality(employeePersonDTO.getNationality());
            person.setMaritalStatus(employeePersonDTO.getMaritalStatus());
            person.setPersonType(employeePersonDTO.getPersonType());
            person.setUpdatedAt(employeePersonDTO.getUpdatedAt());
            personRepository.save(person);
            return employeePersonDTO;
        }

        return null;
    }


//    @Override
//    public String addEmployee(EmployeeDTO employeeDTO) {
//
//        // Create a Person entity from the DTO
//        Person person = new Person(
//                employeeDTO.getPersonID(),
//                employeeDTO.getFirstName(),
//                employeeDTO.getLastName(),
//                employeeDTO.getAddress(),
//                employeeDTO.getPersonEmail(),
//                passwordEncoder.encode(employeeDTO.getPersonPassword()),
//                employeeDTO.getPhone(),
//                employeeDTO.getDateOfBirth(),
//                employeeDTO.getGender(),
//                employeeDTO.getNationality(),
//                employeeDTO.getMaritalStatus(),
//                employeeDTO.getPersonType()
//        );
//
//        // Save the Person entity
//        Person savedPerson = personService.savePerson(person);
//
//        // Create an Employee entity and set the person
//        Employee employee = new Employee(savedPerson, employeeDTO.getDesignation());
//
//        // Set supervisorId if provided and valid
//        if (employeeDTO.getSupervisorId() != 0) {
//            Optional<Employee> supervisorOptional = employeeRepository.findById(employeeDTO.getSupervisorId());
//            if (supervisorOptional.isPresent()) {
//                employee.setSupervisorId(employeeDTO.getSupervisorId());
//            } else {
//                // Handle case where supervisorId does not exist
//                // You can throw an exception or handle it according to your application logic
//                throw new RuntimeException("Supervisor with ID " + employeeDTO.getSupervisorId() + " not found.");
//            }
//        }
//        employee.setEmployeeID(employeeDTO.getEmployeeID());
//        employee.setPerson(person);
////        employee.setDepartment(department);
////        employee.setExperience(experience);
////        employee.setEducation(education);
////        employee.setSupervisor(supervisor);
//        employee.setSupervisorId(employeeDTO.getSupervisorId());
//        employee.setManageWhom(employeeDTO.getManageWhom());
//        employee.setEmploymentType(employeeDTO.getEmploymentType());
//        employee.setAdmin(employeeDTO.getAdmin());
//        employee.setEmpEmail(employeeDTO.getEmpEmail());
//        employee.setEmpPassword(passwordEncoder.encode(employeeDTO.getEmpPassword()));
//        employee.setDesignation(employeeDTO.getDesignation());
//        employee.setHireDate(employeeDTO.getHireDate());
//        employee.setTerminationDate(employeeDTO.getTerminationDate());
//        employee.setEmploymentStatus(employeeDTO.getEmploymentStatus());
//        employee.setWorkLocation(employeeDTO.getWorkLocation());
//        employee.setCreatedAt(employeeDTO.getCreatedAt());
//        employee.setUpdatedAt(employeeDTO.getUpdatedAt());
//
//        // Save the Employee entity
//        employeeRepository.save(employee);
//
//        return employee.getPerson().getFirstName();
//
//
//    }

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        // Create a Person entity from the DTO
//        if (EmployeePersonDTO().equalsIgnoreCase("applicant")) {
//            // set person
//        }else { // employee and person
//             }

        Person person = new Person(
                employeeDTO.getPersonID(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getAddress(),
                employeeDTO.getPersonEmail(),
                passwordEncoder.encode(employeeDTO.getPersonPassword()),
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
        Employee employee = new Employee(savedPerson);

        // Initially set the supervisorId to 0
        employee.setSupervisorId(0);
        System.out.println(employeeDTO.getDepartment().getDepartmentId());
        Department department = departmentRepository.findById(employeeDTO.getDepartment().getDepartmentId()).orElseThrow(() -> new RuntimeException("Department not found"));




        // Set other employee details from the DTO
        employee.setDepartment(department);
        employee.setManageWhom(employeeDTO.getManageWhom());
        employee.setEmploymentType(employeeDTO.getEmploymentType());
        employee.setAdmin(employeeDTO.getAdmin());
        employee.setEmpEmail(employeeDTO.getEmpEmail());
        employee.setEmpPassword(passwordEncoder.encode(employeeDTO.getEmpPassword()));
        employee.setDesignation(employeeDTO.getDesignation());
        employee.setHireDate(employeeDTO.getHireDate());
        employee.setTerminationDate(employeeDTO.getTerminationDate());
        employee.setEmploymentStatus(employeeDTO.getEmploymentStatus());
        employee.setWorkLocation(employeeDTO.getWorkLocation());
        employee.setCreatedAt(employeeDTO.getCreatedAt());
        employee.setUpdatedAt(employeeDTO.getUpdatedAt());

        // Save the Employee entity to get the employeeID
        Employee savedEmployee = employeeRepository.save(employee);

        // Set supervisorId to the employee's own ID if necessary
        if (employeeDTO.getSupervisorId() == 0) {
            savedEmployee.setSupervisorId(savedEmployee.getEmployeeID());
            employeeRepository.save(savedEmployee);
        }

        return savedEmployee.getPerson().getFirstName();
    }
}
