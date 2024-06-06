package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.BenefitDTO;
import com.humanresourcemanagementsystem.Dto.EducationDTO;
import com.humanresourcemanagementsystem.Dto.EmployeePersonDTO;
import com.humanresourcemanagementsystem.Dto.ExperienceDTO;
import com.humanresourcemanagementsystem.Entity.*;
import com.humanresourcemanagementsystem.Repo.ExperienceRepository;
import com.humanresourcemanagementsystem.Repo.PersonRepository;
import com.humanresourcemanagementsystem.Service.ExperienceService;
import com.humanresourcemanagementsystem.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExperienceIMPL implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Override
    public ExperienceDTO getExperienceById(int id) {
        Optional<Experience> experienceOpt = experienceRepository.findById(id);
        if (experienceOpt.isPresent()) {
            Experience experience = experienceOpt.get();
            // Fetch associated experience information
            ExperienceDTO experienceDTO = new ExperienceDTO();
            experienceDTO.setExperience_id(experience.getExperienceID());
            experienceDTO.setPerson_id(experience.getPerson());
            experienceDTO.setCompany_name(experience.getCompany_name());
            experienceDTO.setEmployment_type(experience.getEmployment_type());
            experienceDTO.setNo_of_years(experience.getNo_of_years());
            experienceDTO.setPosition(experience.getPosition());
            experienceDTO.setStart_date(experience.getStart_date());
            experienceDTO.setEnd_date(experience.getEnd_date());
            return experienceDTO;
        } else {
            throw new RuntimeException("Experience not found with id: " + id);
        }
    }

    @Override
    public List<ExperienceDTO> getAllExperience() {
        List<Experience> experiences = experienceRepository.findAll();
        return experiences.stream()
                .map(experience -> {
                    // Fetch associated experience information
                    ExperienceDTO experienceDTO = new ExperienceDTO();
                    experienceDTO.setExperience_id(experience.getExperienceID());
                    experienceDTO.setPerson_id(experience.getPerson());
                    experienceDTO.setCompany_name(experience.getCompany_name());
                    experienceDTO.setEmployment_type(experience.getEmployment_type());
                    experienceDTO.setNo_of_years(experience.getNo_of_years());
                    experienceDTO.setPosition(experience.getPosition());
                    experienceDTO.setStart_date(experience.getStart_date());
                    experienceDTO.setEnd_date(experience.getEnd_date());
                    return experienceDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public String addExperience(ExperienceDTO experienceDTO)
    {
        // Fetch and set the person
        Person person = personRepository.findById(experienceDTO.getPerson_id()).orElse(null);
        if (person == null) {
            return "Person not found";
        }

        // Create and set experience details
        Experience experience = new Experience();
        experience.setCompany_name(experienceDTO.getCompany_name());
        experience.setEmployment_type(experienceDTO.getEmployment_type());
        experience.setNo_of_years(experienceDTO.getNo_of_years());
        experience.setPosition(experienceDTO.getPosition());
        experience.setStart_date(experienceDTO.getStart_date());
        experience.setEnd_date(experienceDTO.getEnd_date());
        experience.setPerson(person);

        experienceRepository.save(experience);
        return "Experience added successfully";
    }

    @Override
    public String addMultipleExperience(List<ExperienceDTO> experienceDTOs) {
        for (ExperienceDTO experienceDTO : experienceDTOs) {
            Person person = personRepository.findById(experienceDTO.getPerson_id()).orElse(null);
            if (person == null) {
                return "Person not found";
            }

            Experience experience = new Experience();
            experience.setCompany_name(experienceDTO.getCompany_name());
            experience.setEmployment_type(experienceDTO.getEmployment_type());
            experience.setNo_of_years(experienceDTO.getNo_of_years());
            experience.setPosition(experienceDTO.getPosition());
            experience.setStart_date(experienceDTO.getStart_date());
            experience.setEnd_date(experienceDTO.getEnd_date());
            experience.setPerson(person);

            experienceRepository.save(experience);
        }
        return "Education records added successfully";
    }

    @Override
    @Transactional
    public String updateExperienceById(int id, ExperienceDTO experienceDTO) {
        Optional<Experience> experienceOpt = experienceRepository.findById((int) id);
        if (experienceOpt.isPresent()) {
            Experience experience = experienceOpt.get();
            experience.setCompany_name(experienceDTO.getCompany_name());
            experience.setEmployment_type(experienceDTO.getEmployment_type());
            experience.setNo_of_years(experienceDTO.getNo_of_years());
            experience.setPosition(experienceDTO.getPosition());
            experience.setStart_date(experienceDTO.getStart_date());
            experience.setEnd_date(experienceDTO.getEnd_date());

            // Fetch and set the person
            Person person = personRepository.findById(experienceDTO.getPerson_id()).orElse(null);
            if (person == null) {
                return "Person not found";
            }

            experienceRepository.save(experience);
            return "Experience updated successfully";
        } else {
            return "Experience not found";
        }
    }
}
