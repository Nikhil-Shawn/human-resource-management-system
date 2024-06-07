package com.humanresourcemanagementsystem.Service;
import com.humanresourcemanagementsystem.Dto.BenefitDTO;
import com.humanresourcemanagementsystem.Dto.EducationDTO;

import java.util.List;

public interface BenefitService {
    String addBenefit(BenefitDTO benefitDTO);
    String addMultipleBenefit(List<BenefitDTO> benefitDTOs);
    BenefitDTO getBenefitById(int id);
    List<BenefitDTO> getAllBenefit();
    String updateBenefitById(int id, BenefitDTO benefitDTO);
}
