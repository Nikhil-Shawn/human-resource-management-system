package com.humanresourcemanagementsystem.Controller.SeparationController;

import com.humanresourcemanagementsystem.Dto.SeparationDTO;
import com.humanresourcemanagementsystem.Service.SeparationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/separation")
public class SeparationController
{
    @Autowired
    private SeparationService separationService;

    //Save Single Separation
    @PostMapping("/save")
    public String saveSeparation(@RequestBody SeparationDTO separationDTO) {
        return separationService.addSeparation(separationDTO);
    }

    // Get Separation By ID
    @GetMapping("/{id}")
    public SeparationDTO getSeparationById(@PathVariable int id) {
        return separationService.getSeparationById(id);
    }

    // Get All Separations
    @GetMapping("/all")
    public List<SeparationDTO> getAllSeparations() {
        return separationService.getAllSeparations() ;

    }
    // Update Separation By ID
    @PutMapping("/update/{id}")
    public String updateSeparationById(@PathVariable int id, @RequestBody SeparationDTO separationDTO) {
        return separationService.updateSeparationById(id, separationDTO);
    }
}

