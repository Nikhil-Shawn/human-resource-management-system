package com.humanresourcemanagementsystem.Service;
import com.humanresourcemanagementsystem.Dto.BenefitDTO;

import java.util.List;

public interface BenefitService {

    // Add Single Benefit
    String addBenefit(BenefitDTO benefitDTO);

    // Add Multiple Benefits
    String addMultipleBenefit(List<BenefitDTO> benefitDTOs);

    //Display Benefit By ID
    BenefitDTO getBenefitById(int id);

    //Display All Benefits
    List<BenefitDTO> getAllBenefit();

    //Update Benefit By ID
    String updateBenefitById(int id, BenefitDTO benefitDTO);
}
