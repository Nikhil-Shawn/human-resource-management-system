package com.humanresourcemanagementsystem.Controller.ExperienceController;

import com.humanresourcemanagementsystem.Dto.BenefitDTO;
import com.humanresourcemanagementsystem.Dto.ExperienceDTO;
import com.humanresourcemanagementsystem.Service.ExperienceService;
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
    @PostMapping("/save")
    public String saveAsset(@RequestBody ExperienceDTO experienceDTO) {
        return experienceService.addExperience(experienceDTO);
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


}