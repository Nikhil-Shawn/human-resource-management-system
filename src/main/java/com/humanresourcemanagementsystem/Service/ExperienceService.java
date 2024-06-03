package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Dto.ExperienceDTO;
import com.humanresourcemanagementsystem.Repo.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ExperienceService {
    String addExperience(ExperienceDTO experienceDTO);
    ExperienceDTO getExperienceById(int id);
    List<ExperienceDTO> getAllExperience();
}
