package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Dto.BenefitDTO;
import com.humanresourcemanagementsystem.Dto.EducationDTO;
import com.humanresourcemanagementsystem.Dto.ExperienceDTO;
import com.humanresourcemanagementsystem.Repo.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ExperienceService {
    String addExperience(ExperienceDTO experienceDTO);
    String addMultipleExperience(List<ExperienceDTO> experienceDTOs);
    ExperienceDTO getExperienceById(int id);
    List<ExperienceDTO> getAllExperience();
    String updateExperienceById(int id, ExperienceDTO experienceDTO);
}
