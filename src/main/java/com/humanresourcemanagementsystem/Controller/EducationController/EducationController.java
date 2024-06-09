package com.humanresourcemanagementsystem.Controller.EducationController;

import com.humanresourcemanagementsystem.Dto.EducationDTO;
import com.humanresourcemanagementsystem.Service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//Mapping the HTTP requests to the methods in the education controller
@RequestMapping("api/v1/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    //Save single education
    @PostMapping("/save")
    public String saveEducation(@RequestBody EducationDTO educationDTO) {
        // Calls the service to add the education
        return educationService.addEducation(educationDTO);
    }

    //Save multiple educations
    @PostMapping("/multi")
    public ResponseEntity<?> createMultipleEducations(@RequestBody List<EducationDTO> educationDTOs) {
        // Calls the service to add the educations
        String response = educationService.addMultipleEducations(educationDTOs);
        return ResponseEntity.ok(response);
    }

    // Get education by ID
     @GetMapping("/{id}")
     public EducationDTO getEducationById(@PathVariable int id) {
         // Fetches Education using the service
        return educationService.getEducationById(id);
     }

    // Get all educations
     @GetMapping("/all")
     public List<EducationDTO> getAllEducation() {
         // Fetches Education using the service
        return educationService.getAllEducation();
     }

    // Update education by id
    @PutMapping("/update/{id}")
    public String updateEducationById(@PathVariable int id, @RequestBody EducationDTO educationDTO) {
        // Calls the service to update the education
        return educationService.updateEducationById(id, educationDTO);
    }

}
