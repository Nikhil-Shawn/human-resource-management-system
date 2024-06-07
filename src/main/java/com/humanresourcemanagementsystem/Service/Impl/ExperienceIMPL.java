package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.ExperienceDTO;
import com.humanresourcemanagementsystem.Entity.*;
import com.humanresourcemanagementsystem.Repo.ExperienceRepository;
import com.humanresourcemanagementsystem.Repo.PersonRepository;
import com.humanresourcemanagementsystem.Service.ExperienceService;
import com.humanresourcemanagementsystem.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExperienceIMPL implements ExperienceService {

    //Provide data access operations for Experience entity
    @Autowired
    private ExperienceRepository experienceRepository;

    //Provide data access operations for Person entity
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;


    @Override
    //Save single experience
    public String addExperience(ExperienceDTO experienceDTO)
    {
        // Checks if the associated person exists
        Person person = personRepository.findById(experienceDTO.getPerson_id()).orElse(null);
        if (person == null) {
            return "Person not found";
        }

        // set experience details
        Experience experience = new Experience();
        experience.setCompany_name(experienceDTO.getCompany_name());
        experience.setEmployment_type(experienceDTO.getEmployment_type());
        experience.setNo_of_years(experienceDTO.getNo_of_years());
        experience.setPosition(experienceDTO.getPosition());
        experience.setStart_date(experienceDTO.getStart_date());
        experience.setEnd_date(experienceDTO.getEnd_date());
        experience.setPerson(person);
        System.out.println(experience);
        //Save experience details
        experienceRepository.save(experience);
        return "Experience added successfully";
    }

    @Override
    //Save multiple experiences
    public String addMultipleExperience(List<ExperienceDTO> experienceDTOs) {
        for (ExperienceDTO experienceDTO : experienceDTOs) {

            // Checks if the associated person exists
            Person person = personRepository.findById(experienceDTO.getPerson_id()).orElse(null);
            if (person == null) {
                return "Person not found";
            }

            Experience experience = new Experience();

            // Create and set experience details
            experience.setCompany_name(experienceDTO.getCompany_name());
            experience.setEmployment_type(experienceDTO.getEmployment_type());
            experience.setNo_of_years(experienceDTO.getNo_of_years());
            experience.setPosition(experienceDTO.getPosition());
            experience.setStart_date(experienceDTO.getStart_date());
            experience.setEnd_date(experienceDTO.getEnd_date());
            experience.setPerson(person);

            //Save experience details
            experienceRepository.save(experience);
        }
        return "Education records added successfully";
    }

    @Override
    //Display experience by ID
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
    //Display multiple experiences
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
    @Transactional
    //Updates experience by ID
    public String updateExperienceById(int id, ExperienceDTO experienceDTO) {
        Optional<Experience> experienceOpt = experienceRepository.findById((int) id);
        if (experienceOpt.isPresent()) {

            // set experience details
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

            //Save experience details
            experienceRepository.save(experience);
            return "Experience updated successfully";
        } else {
            return "Experience not found";
        }
    }
}
