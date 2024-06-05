package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.EducationDTO;
import com.humanresourcemanagementsystem.Entity.Education;
import com.humanresourcemanagementsystem.Entity.Person;
import com.humanresourcemanagementsystem.Repo.EducationRepository;
import com.humanresourcemanagementsystem.Repo.PersonRepository;
import com.humanresourcemanagementsystem.Service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EducationIMPL implements EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public String addMultipleEducations(List<EducationDTO> educationDTOs) {
        for (EducationDTO educationDTO : educationDTOs) {
            Person person = personRepository.findById(educationDTO.getPerson_id()).orElse(null);
            if (person == null) {
                return "Person not found";
            }

            Education education = new Education();
            education.setDegree(educationDTO.getDegree());
            education.setInstitution(educationDTO.getInstitution());
            education.setMajor(educationDTO.getMajor());
            education.setGraduation_start_date(educationDTO.getGraduation_start_date());
            education.setGraduation_end_date(educationDTO.getGraduation_end_date());
            education.setCreated_at(new Date());
            education.setUpdated_at(new Date());
            education.setPerson(person);

            educationRepository.save(education);
        }
        return "Education records added successfully";
    }

    @Override
    public String addEducation(EducationDTO educationDTO) {
        Person person = personRepository.findById(educationDTO.getPerson_id()).orElse(null);
        if (person == null) {
            return "Person not found";
        }

        Education education = new Education();
        education.setDegree(educationDTO.getDegree());
        education.setInstitution(educationDTO.getInstitution());
        education.setMajor(educationDTO.getMajor());
        education.setGraduation_start_date(educationDTO.getGraduation_start_date());
        education.setGraduation_end_date(educationDTO.getGraduation_end_date());
        education.setCreated_at(educationDTO.getCreated_at());
        education.setUpdated_at(educationDTO.getUpdated_at());
        education.setPerson(person);

        educationRepository.save(education);
        return "Education added successfully";
    }

    @Override
    public EducationDTO getEducationById(int id) {
        // Your implementation here
        return null;
    }

    @Override
    public List<EducationDTO> getAllEducation() {
        // Your implementation here
        return List.of();
    }
}
