package com.humanresourcemanagementsystem.Service;
import com.humanresourcemanagementsystem.Dto.EducationDTO;

import java.util.List;

public interface EducationService {

    //Add Single Education
    String addEducation(EducationDTO educationDTO);

    //Add Multiple Educations
    String addMultipleEducations(List<EducationDTO> educationDTOs);

    //Display Education By ID
    EducationDTO getEducationById(int id);

    //Display Education By Person ID
    EducationDTO getEducationByPersonId(int id);

    //Display Education By Employee ID
    EducationDTO getEducationByEmployeeId(int id);

//    List<EducationDTO> getEducationByEmployeeId(Long employeeId);
//
    //Display All Education
    List<EducationDTO> getAllEducation();

    // Update Education By ID
    String updateEducationById(int id, EducationDTO educationDTO);
}
