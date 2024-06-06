package com.humanresourcemanagementsystem.Controller.BenefitController;

import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Dto.BenefitDTO;
import com.humanresourcemanagementsystem.Dto.EducationDTO;
import com.humanresourcemanagementsystem.Service.BenefitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/benefit")
public class BenefitController
{
    @Autowired
    private BenefitService benefitService;
    @PostMapping("/save")
    public String saveAsset(@RequestBody BenefitDTO benefitDTO) {
        return benefitService.addBenefit(benefitDTO);
    }


    @PostMapping("/multi")
    public ResponseEntity<?> createMultipleBenefit(@RequestBody List<BenefitDTO> benefitDTOs) {
        String response = benefitService.addMultipleBenefit(benefitDTOs);
        return ResponseEntity.ok(response);
    }

    // Get benefit by ID
    @GetMapping("/{id}")
    public BenefitDTO getBenefitById(@PathVariable int id) {
        return benefitService.getBenefitById(id);
    }

    // Get all benefits
    @GetMapping("/all")
    public List<BenefitDTO> getAllBenefit() {
        return benefitService.getAllBenefit() ;

    }

    // Update benefit by id
    @PutMapping("/update/{id}")
    public String updateBenefitById(@PathVariable int id, @RequestBody BenefitDTO benefitDTO) {
        return benefitService.updateBenefitById(id, benefitDTO);
    }

}