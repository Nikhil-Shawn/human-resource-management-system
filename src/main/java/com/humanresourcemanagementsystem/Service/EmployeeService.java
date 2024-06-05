package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.EmployeeDTO;
import com.humanresourcemanagementsystem.Dto.EmployeePersonDTO;

import java.util.List;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(int id);
    List<EmployeePersonDTO> getAllEmployees();
    EmployeePersonDTO updateEmployeePerson(int employeeID, EmployeePersonDTO employeePersonDTO);
}
