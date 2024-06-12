package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.EmployeeDTO;
import com.humanresourcemanagementsystem.Dto.EmployeePersonDTO;

import java.util.List;

public interface EmployeeService {
    //Add single employee
    String addEmployee(EmployeeDTO employeeDTO);
    //Display employee by ID
    EmployeeDTO getEmployeeById(int id);
    //Display all employees
    List<EmployeePersonDTO> getAllEmployees();
    //Update Employee
    EmployeePersonDTO updateEmployeePerson(int employeeID, EmployeePersonDTO employeePersonDTO);
}
