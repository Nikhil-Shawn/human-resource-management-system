package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.EducationDTO;

import java.util.List;

public interface EducationService {
    String addEducation(EducationDTO educationDTO);
    String addMultipleEducations(List<EducationDTO> educationDTOs);
    EducationDTO getEducationById(int id);
    List<EducationDTO> getAllEducation();
}
