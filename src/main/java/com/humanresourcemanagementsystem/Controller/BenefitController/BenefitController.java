package com.humanresourcemanagementsystem.Controller.BenefitController;

import com.humanresourcemanagementsystem.Dto.BenefitDTO;
import com.humanresourcemanagementsystem.Service.BenefitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin
//Mapping the HTTP requests to the methods in the benefit controller
@RequestMapping("api/v1/benefit")
public class BenefitController
{
    @Autowired
    private BenefitService benefitService;

    //Save single benefit
    @PostMapping("/save")
    public String saveAsset(@RequestBody BenefitDTO benefitDTO) {
        // Calls the service to add the benefit
        return benefitService.addBenefit(benefitDTO);
    }

    //Save multiple benefits
    @PostMapping("/multi")
    public ResponseEntity<?> createMultipleBenefit(@RequestBody List<BenefitDTO> benefitDTOs) {
        // Calls the service to add the benefits
        String response = benefitService.addMultipleBenefit(benefitDTOs);
        return ResponseEntity.ok(response);
    }

    // Get benefit by ID
    @GetMapping("/{id}")
    public BenefitDTO getBenefitById(@PathVariable int id) {
        // Fetches Benefit using the service
        return benefitService.getBenefitById(id);
    }

    // Get all benefits
    @GetMapping("/all")
    public List<BenefitDTO> getAllBenefit() {
        // Fetches all benefits using the service
        return benefitService.getAllBenefit() ;

    }

    // Update benefit by id
    @PutMapping("/update/{id}")
    public String updateBenefitById(@PathVariable int id, @RequestBody BenefitDTO benefitDTO) {
        // Calls the service to update the benefit
        return benefitService.updateBenefitById(id, benefitDTO);
    }

}