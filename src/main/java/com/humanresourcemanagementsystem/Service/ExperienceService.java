package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.ExperienceDTO;
import java.util.List;

public interface ExperienceService {

    //Add Single Experience
    String addExperience(ExperienceDTO experienceDTO);

    //Add Multiple Experiences
    String addMultipleExperience(List<ExperienceDTO> experienceDTOs);

    //Display Experience By ID
    ExperienceDTO getExperienceById(int id);

    //Display Experience By Person ID
    ExperienceDTO getExperienceByPersonId(int id);

    //Display Experience By Employee ID
    ExperienceDTO getExperienceByEmployeeId(int id);

    //Display All Experiences
    List<ExperienceDTO> getAllExperience();

    //Update Experience By ID
    String updateExperienceById(int id, ExperienceDTO experienceDTO);
}
