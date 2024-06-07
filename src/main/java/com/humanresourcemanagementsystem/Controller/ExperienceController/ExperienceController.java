package com.humanresourcemanagementsystem.Controller.ExperienceController;

import com.humanresourcemanagementsystem.Dto.ExperienceDTO;
import com.humanresourcemanagementsystem.Service.ExperienceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/experience")

public class ExperienceController
{
    @Autowired
    private ExperienceService experienceService;

    //Save single experience
    @PostMapping("/save")
    public String saveAsset(@RequestBody ExperienceDTO experienceDTO) {
        return experienceService.addExperience(experienceDTO);
    }

    //Save multiple experiences
    @PostMapping("/multi")
    public ResponseEntity<?> createMultipleExperience(@RequestBody List<ExperienceDTO> experienceDTOs) {
        String response = experienceService.addMultipleExperience(experienceDTOs);
        return ResponseEntity.ok(response);
    }

    // Get experience by ID
    @GetMapping("/{id}")
    public ExperienceDTO getExperienceById(@PathVariable int id) {
        return experienceService.getExperienceById(id);
    }

    // Get all experiences
    @GetMapping("/all")
    public List<ExperienceDTO> getAllExperience() {
        return experienceService.getAllExperience();
    }

    // Update experience by id
    @PutMapping("/update/{id}")
    public String updateExperienceById(@PathVariable int id, @RequestBody ExperienceDTO experienceDTO) {
        return experienceService.updateExperienceById(id, experienceDTO);
    }

}