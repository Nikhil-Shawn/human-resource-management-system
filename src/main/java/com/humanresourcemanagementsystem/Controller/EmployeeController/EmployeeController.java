package com.humanresourcemanagementsystem.Controller.EmployeeController;

import com.humanresourcemanagementsystem.Dto.EmployeeDTO;
import com.humanresourcemanagementsystem.Dto.EmployeePersonDTO;
import com.humanresourcemanagementsystem.Service.EmployeeService;
import com.humanresourcemanagementsystem.Service.Impl.EmployeeIMPL;
import org.springframework.http.ResponseEntity;
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
    private EmployeeService employeeService;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    // Get employee
    @GetMapping("/employeeget/{id}")
    public EmployeeDTO getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    //Get ALL employees Filtered
    @GetMapping("/all")
    public List<EmployeePersonDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeePersonDTO> updateEmployeePerson(@PathVariable int id, @RequestBody EmployeePersonDTO employeePersonDTO) {
        EmployeePersonDTO updatedEmployeePerson = employeeService.updateEmployeePerson(id, employeePersonDTO);
        if (updatedEmployeePerson != null) {
            return ResponseEntity.ok(updatedEmployeePerson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
