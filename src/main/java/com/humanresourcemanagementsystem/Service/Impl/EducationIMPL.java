package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Dto.BenefitDTO;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EducationIMPL implements EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private PersonRepository personRepository;

//    @Override
//    public EducationDTO getEducationById(int id) {
//        Optional<Education> educationOpt = educationRepository.findById(id);
//        if (educationOpt.isPresent()) {
//            Education education = educationOpt.get();
//            // Fetch associated education information
//            EducationDTO educationDTO = new EducationDTO();
//            educationDTO.setEducation_id(education.getEducation_id());
//            educationDTO.setDegree(education.getDegree());
//            educationDTO.setInstitution(education.getInstitution());
//            educationDTO.setMajor(education.getMajor());
//            educationDTO.setGraduation_start_date(education.getGraduation_start_date());
//            educationDTO.setGraduation_end_date(education.getGraduation_end_date());
//            educationDTO.setCreated_at(education.getCreated_at());
//            educationDTO.setUpdated_at(education.getUpdated_at());
//
//            // Fetch associated employee details
//            Employee employee = benefit.getEmployee();
//            if (employee != null) {
//                benefitDTO.setEmployee_id(employee.getEmployeeID());
//            }
//            return benefitDTO;
//        } else {
//            throw new RuntimeException("Benefit not found with id: " + id);
//        }
//    }

//    @Override
//    public List<BenefitDTO> getAllBenefit() {
//        List<Benefit> benefits = benefitRepository.findAll();
//        return benefits.stream()
//                .map(benefit -> {
//                    BenefitDTO benefitDTO = new BenefitDTO();
//                    benefitDTO.setBenefit_id(benefit.getBenefit_id());
//                    benefitDTO.setBenefit_type(benefit.getBenefit_type());
//                    benefitDTO.setCoverage_details(benefit.getCoverage_details());
//                    benefitDTO.setStart_date(benefit.getStart_date());
//                    benefitDTO.setEnd_date(benefit.getEnd_date());
//                    benefitDTO.setCreated_at(benefit.getCreated_at());
//                    benefitDTO.setUpdated_at(benefit.getUpdated_at());
//                    // Fetch associated employee details
//                    Employee employee = benefit.getEmployee();
//                    if (employee != null) {
//                        benefitDTO.setEmployee_id(employee.getEmployeeID());
//                    }
//                    return benefitDTO;
//                })
//                .collect(Collectors.toList());
//    }


    @Override
    public String addEducation(EducationDTO educationDTO) {

        // Fetch and set the person
        Person person = personRepository.findById(educationDTO.getPerson_id()).orElse(null);
        if (person == null) {
            return "Person not found";
        }

        Education education = new Education();
        // Fetch associated education information
        education.setEducation_id(educationDTO.getEducation_id());
        education.setDegree(educationDTO.getDegree());
        education.setInstitution(educationDTO.getInstitution());
        education.setMajor(educationDTO.getMajor());
        education.setGraduation_start_date(educationDTO.getGraduation_start_date());
        education.setGraduation_end_date(educationDTO.getGraduation_end_date());
        education.setCreated_at(educationDTO.getCreated_at());
        education.setUpdated_at(educationDTO.getUpdated_at());
        education.setPerson(person); // Correctly set the Person entity

        education.setPerson(person);

        educationRepository.save(education);
        return "Education added successfully";
    }

    @Override
    public EducationDTO getEducationById(int id) {
        return null;
    }

    @Override
    public List<EducationDTO> getAllEducation() {
        return List.of();
    }
}
