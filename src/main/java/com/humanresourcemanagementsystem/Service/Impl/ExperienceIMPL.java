package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.ExperienceDTO;
import com.humanresourcemanagementsystem.Entity.Experience;
import com.humanresourcemanagementsystem.Entity.Person;
import com.humanresourcemanagementsystem.Repo.ExperienceRepository;
import com.humanresourcemanagementsystem.Repo.PersonRepository;
import com.humanresourcemanagementsystem.Service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceIMPL implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public String addExperience(ExperienceDTO experienceDTO)
    {
//        boolean exists = experienceRepository.existsByDetails(
//                experienceDTO.getCompany_name(),
//                experienceDTO.getEmployment_type(),
//                experienceDTO.getNo_of_years(),
//                experienceDTO.getPosition(),
//                experienceDTO.getStart_date(),
//                experienceDTO.getEnd_date()
//        );
//
//        if (exists) {
//            return "Experience entry already exists";
//        }

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
        experience.setPerson(person); // Correctly set the Person entity

        experienceRepository.save(experience);
        return "Experience added successfully";
    }
}
