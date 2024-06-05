package com.humanresourcemanagementsystem.Controller.EducationController;

import com.humanresourcemanagementsystem.Dto.BenefitDTO;
import com.humanresourcemanagementsystem.Dto.EducationDTO;
import com.humanresourcemanagementsystem.Dto.ExperienceDTO;
import com.humanresourcemanagementsystem.Service.EducationService;
import com.humanresourcemanagementsystem.Service.ExperienceService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/education")
public class EducationController
{
    @Autowired
    private EducationService educationService;
    @PostMapping("/save")
    public String saveEducation(@RequestBody EducationDTO educationDTO) {
        return educationService.addEducation(educationDTO);
    }

//    // Get experience by ID
//    @GetMapping("/{id}")
//    public ExperienceDTO getExperienceById(@PathVariable int id) {
//        return experienceService.getExperienceById(id);
//    }
//
//    // Get all experiences
//    @GetMapping("/all")
//    public List<ExperienceDTO> getAllExperience() {
//        return experienceService.getAllExperience();
//
//    }


}