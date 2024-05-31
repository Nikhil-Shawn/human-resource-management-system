package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(int id);
    List<EmployeeDTO> getAllEmployees();
}
