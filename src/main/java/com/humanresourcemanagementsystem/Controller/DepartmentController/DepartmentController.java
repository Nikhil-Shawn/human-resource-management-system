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
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<ResponseData> getAllDepartments() {
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("departments", departments);
        return ResponseEntity.ok(new ResponseData("Success", true, responseData));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData> getDepartmentById(@PathVariable int id) {
        DepartmentDTO departmentDTO = departmentService.getDepartmentById(id);
        if (departmentDTO != null) {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("department", departmentDTO);
            return ResponseEntity.ok(new ResponseData("Success", true, responseData));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addDepartment")
    public ResponseEntity<ResponseData> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        ResponseData responseData = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.ok(responseData);
    }


    @PutMapping("/updateDepartment/{id}")
    public ResponseEntity<ResponseData> updateDepartment(@PathVariable int id, @RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO updatedDepartment = departmentService.updateDepartment(id, departmentDTO);
        if (updatedDepartment != null) {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("department", updatedDepartment);
            return ResponseEntity.ok(new ResponseData("Department updated successfully.", true, responseData));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity<ResponseData> deleteDepartment(@PathVariable int id) {
        String message = departmentService.deleteDepartment(id);
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("message", message);
        return ResponseEntity.ok(new ResponseData(message, true, responseData));
    }
}


