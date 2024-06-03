package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Dto.BenefitDTO;

import java.util.List;

public interface BenefitService {
    String addBenefit(BenefitDTO benefitDTO);
    BenefitDTO getBenefitById(int id);
    List<BenefitDTO> getAllBenefit();
}
