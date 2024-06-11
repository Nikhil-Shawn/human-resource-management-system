package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.DepartmentDTO;
import com.humanresourcemanagementsystem.Entity.Department;
import com.humanresourcemanagementsystem.Repo.DepartmentRepository;
import com.humanresourcemanagementsystem.response.ResponseData;
import com.humanresourcemanagementsystem.util.DepartmentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public DepartmentDTO getDepartmentById(Long id) {
        return departmentRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public ResponseData createDepartment(DepartmentDTO departmentDTO) {
        Optional<Department> existingDepartment = departmentRepository.findByDepartmentName(departmentDTO.getDepartmentName());

        if (existingDepartment.isPresent()) {
            return new ResponseData("Department already exists.", false, null);
        }

        Department department = new Department();
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setDepartmentStatus(DepartmentStatus.valueOf(departmentDTO.getDepartmentStatus().toUpperCase()));

        Department savedDepartment = departmentRepository.save(department);
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("departmentId", savedDepartment.getDepartmentId()); // Include other relevant department data if needed
        responseData.put("departmentName", savedDepartment.getDepartmentName());
        responseData.put("departmentStatus", savedDepartment.getDepartmentStatus());
        responseData.put("createdAt", savedDepartment.getCreatedAt());
        responseData.put("updatedAt", savedDepartment.getUpdatedAt());

        return new ResponseData("Department created successfully.", true, responseData);
    }

    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO) {
        if (departmentRepository.existsById(id)) {
            Department department = departmentRepository.findById(id).orElseThrow();
            department.setDepartmentName(departmentDTO.getDepartmentName());
            department.setDepartmentStatus(DepartmentStatus.valueOf(departmentDTO.getDepartmentStatus().toUpperCase()));

            Department updatedDepartment = departmentRepository.save(department);
            return convertToDTO(updatedDepartment);
        }
        return null;
    }

    public String deleteDepartment(Long id) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);

        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            String departmentName = department.getDepartmentName();
            departmentRepository.deleteById(id);
            return departmentName + " department has been deleted successfully.";
        } else {
            return "Department not found";
        }
    }

    private DepartmentDTO convertToDTO(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentId(department.getDepartmentId());
        departmentDTO.setDepartmentName(department.getDepartmentName());
        departmentDTO.setDepartmentStatus(department.getDepartmentStatus().name()); // Ensure enum is converted to string
        departmentDTO.setCreatedAt(department.getCreatedAt());
        departmentDTO.setUpdatedAt(department.getUpdatedAt());
        return departmentDTO;
    }
}
