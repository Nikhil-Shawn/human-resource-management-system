package com.humanresourcemanagementsystem.Controller.EmployeeController;

import org.springframework.web.bind.annotation.*;
import com.humanresourcemanagementsystem.Entity.Employee;
import com.humanresourcemanagementsystem.Repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")

public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) {
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            // Set other fields as needed
            return employeeRepository.save(employee);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeRepository.deleteById(id);
    }
}
