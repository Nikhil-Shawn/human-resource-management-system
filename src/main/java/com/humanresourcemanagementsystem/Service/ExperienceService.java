package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.ExperienceDTO;
import com.humanresourcemanagementsystem.Repo.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ExperienceService {
    String addExperience(ExperienceDTO experienceDTO);
}
