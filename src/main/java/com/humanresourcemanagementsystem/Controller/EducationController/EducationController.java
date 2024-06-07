package com.humanresourcemanagementsystem.Controller.EducationController;

import com.humanresourcemanagementsystem.Dto.EducationDTO;
import com.humanresourcemanagementsystem.Service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    //Save single education
    @PostMapping("/save")
    public String saveEducation(@RequestBody EducationDTO educationDTO) {
        return educationService.addEducation(educationDTO);
    }

    //Save multiple educations
    @PostMapping("/multi")
    public ResponseEntity<?> createMultipleEducations(@RequestBody List<EducationDTO> educationDTOs) {
        String response = educationService.addMultipleEducations(educationDTOs);
        return ResponseEntity.ok(response);
    }

    // Get benefit by ID
     @GetMapping("/{id}")
     public EducationDTO getEducationById(@PathVariable int id) {
         return educationService.getEducationById(id);
     }

    // Get all benefits
     @GetMapping("/all")
     public List<EducationDTO> getAllEducation() {
         return educationService.getAllEducation();
     }

    // Update education by id
    @PutMapping("/update/{id}")
    public String updateEducationById(@PathVariable int id, @RequestBody EducationDTO educationDTO) {
        return educationService.updateEducationById(id, educationDTO);
    }

}
