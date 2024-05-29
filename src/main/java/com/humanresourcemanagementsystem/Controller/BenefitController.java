package com.humanresourcemanagementsystem.Controller;

import com.humanresourcemanagementsystem.Dto.BenefitDTO;
import com.humanresourcemanagementsystem.Service.BenefitService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
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
}