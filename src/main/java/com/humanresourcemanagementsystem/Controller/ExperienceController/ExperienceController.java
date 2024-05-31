package com.humanresourcemanagementsystem.Controller.ExperienceController;

import com.humanresourcemanagementsystem.Dto.ExperienceDTO;
import com.humanresourcemanagementsystem.Service.ExperienceService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@CrossOrigin
@RequestMapping("api/v1/experience")
public class ExperienceController
{
    @Autowired
    private ExperienceService benefitService;
    @PostMapping("/save")
    public String saveAsset(@RequestBody ExperienceDTO benefitDTO) {
        return benefitService.addExperience(benefitDTO);
    }
}