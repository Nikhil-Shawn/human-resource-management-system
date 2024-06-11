package com.humanresourcemanagementsystem.Controller.EducationController;

import com.humanresourcemanagementsystem.Dto.AssetDTO;
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

    // Get education by ID
     @GetMapping("/{id}")
     public EducationDTO getEducationById(@PathVariable int id) {
         return educationService.getEducationById(id);
     }

    // Get education by person ID
    @GetMapping("/byperson/{id}")
    public EducationDTO getEducationByPersonId(@PathVariable int id) {
        return educationService.getEducationByPersonId(id);
    }

    // Get education by ID
    @GetMapping("/byemployee/{id}")
    public EducationDTO getEducationByEmployeeId(@PathVariable int id) {
        return educationService.getEducationByEmployeeId(id);
    }

    // Get all educations
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
