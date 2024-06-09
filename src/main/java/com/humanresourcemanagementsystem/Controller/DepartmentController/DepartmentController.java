package com.humanresourcemanagementsystem.Controller.DepartmentController;

import com.humanresourcemanagementsystem.Dto.DepartmentDTO;
import com.humanresourcemanagementsystem.Service.DepartmentService;
import com.humanresourcemanagementsystem.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//Mapping the HTTP requests to the methods in the department controller
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //Display all departments
    @GetMapping
    public ResponseEntity<ResponseData> getAllDepartments() {
        // Fetches all departments using the service
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("departments", departments);
        return ResponseEntity.ok(new ResponseData("Success", true, responseData));
    }

    //Display departments by ID
    @GetMapping("/{id}")
    public ResponseEntity<ResponseData> getDepartmentById(@PathVariable Long id) {
        // Fetches department using the service
        DepartmentDTO departmentDTO = departmentService.getDepartmentById(id);
        if (departmentDTO != null) {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("department", departmentDTO);
            return ResponseEntity.ok(new ResponseData("Success", true, responseData));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Save single department
    @PostMapping("/addDepartment")
    public ResponseEntity<ResponseData> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        // Calls the service to create a new department
        ResponseData responseData = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.ok(responseData);
    }


    //Update the department by ID
    @PutMapping("/updateDepartment/{id}")
    public ResponseEntity<ResponseData> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) {
        // Calls the service to update the department
        DepartmentDTO updatedDepartment = departmentService.updateDepartment(id, departmentDTO);
        if (updatedDepartment != null) {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("department", updatedDepartment);
            return ResponseEntity.ok(new ResponseData("Department updated successfully.", true, responseData));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Delete department by ID
    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity<ResponseData> deleteDepartment(@PathVariable Long id) {
        // Calls the service to delete the department
        String message = departmentService.deleteDepartment(id);
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("message", message);
        return ResponseEntity.ok(new ResponseData(message, true, responseData));
    }
}


