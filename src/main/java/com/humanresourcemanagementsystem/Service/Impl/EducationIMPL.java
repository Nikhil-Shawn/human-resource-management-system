package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.EducationDTO;
import com.humanresourcemanagementsystem.Dto.ExperienceDTO;
import com.humanresourcemanagementsystem.Entity.Education;
import com.humanresourcemanagementsystem.Entity.Experience;
import com.humanresourcemanagementsystem.Entity.Person;
import com.humanresourcemanagementsystem.Repo.EducationRepository;
import com.humanresourcemanagementsystem.Repo.PersonRepository;
import com.humanresourcemanagementsystem.Service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Optional<Education> educationOpt = educationRepository.findById(id);
        if (educationOpt.isPresent()) {
            Education education = educationOpt.get();
            // Fetch associated education information
            EducationDTO educationDTO = new EducationDTO();
            educationDTO.setEducation_id(education.getEducation_id());
            educationDTO.setPerson_id(education.getPerson());
            educationDTO.setDegree(education.getDegree());
            educationDTO.setInstitution(education.getInstitution());
            educationDTO.setMajor(education.getMajor());
            educationDTO.setGraduation_start_date(education.getGraduation_start_date());
            educationDTO.setGraduation_end_date(education.getGraduation_end_date());
            educationDTO.setCreated_at(education.getCreated_at());
            educationDTO.setUpdated_at(education.getUpdated_at());
            return educationDTO;
        } else {
            throw new RuntimeException("Education not found with id: " + id);
        }
    }

    @Override
    public List<EducationDTO> getAllEducation() {
        List<Education> educations = educationRepository.findAll();
        return educations.stream()
                .map(education -> {
                    // Fetch associated education information
                    EducationDTO educationDTO = new EducationDTO();
                    educationDTO.setEducation_id(education.getEducation_id());
                    educationDTO.setPerson_id(education.getPerson());
                    educationDTO.setDegree(education.getDegree());
                    educationDTO.setInstitution(education.getInstitution());
                    educationDTO.setMajor(education.getMajor());
                    educationDTO.setGraduation_start_date(education.getGraduation_start_date());
                    educationDTO.setGraduation_end_date(education.getGraduation_end_date());
                    educationDTO.setCreated_at(education.getCreated_at());
                    educationDTO.setUpdated_at(education.getUpdated_at());
                    return educationDTO;
                })
                .collect(Collectors.toList());
    }
}
