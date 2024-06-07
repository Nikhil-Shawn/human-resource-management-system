package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Dto.BenefitDTO;
import com.humanresourcemanagementsystem.Dto.EducationDTO;
import com.humanresourcemanagementsystem.Entity.*;
import com.humanresourcemanagementsystem.Repo.BenefitRepository;
import com.humanresourcemanagementsystem.Repo.EmployeeRepository;
import com.humanresourcemanagementsystem.Service.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BenefitIMPL implements BenefitService {

    @Autowired
    private BenefitRepository benefitRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public BenefitDTO getBenefitById(int id) {
        Optional<Benefit> benefitOpt = benefitRepository.findById(id);
        if (benefitOpt.isPresent()) {
            Benefit benefit = benefitOpt.get();
            // Fetch associated benefit information
            BenefitDTO benefitDTO = new BenefitDTO();
            benefitDTO.setBenefit_id(benefit.getBenefit_id());
            benefitDTO.setBenefit_type(benefit.getBenefit_type());
            benefitDTO.setCoverage_details(benefit.getCoverage_details());
            benefitDTO.setStart_date(benefit.getStart_date());
            benefitDTO.setEnd_date(benefit.getEnd_date());
            benefitDTO.setCreated_at(benefit.getCreated_at());
            benefitDTO.setUpdated_at(benefit.getUpdated_at());
            // Fetch associated employee details
            Employee employee = benefit.getEmployee();
            if (employee != null) {
                benefitDTO.setEmployee_id(employee.getEmployeeID());
            }
            return benefitDTO;
        } else {
            throw new RuntimeException("Benefit not found with id: " + id);
        }
    }

    @Override
    public List<BenefitDTO> getAllBenefit() {
        List<Benefit> benefits = benefitRepository.findAll();
        return benefits.stream()
                .map(benefit -> {
                    BenefitDTO benefitDTO = new BenefitDTO();
                    benefitDTO.setBenefit_id(benefit.getBenefit_id());
                    benefitDTO.setBenefit_type(benefit.getBenefit_type());
                    benefitDTO.setCoverage_details(benefit.getCoverage_details());
                    benefitDTO.setStart_date(benefit.getStart_date());
                    benefitDTO.setEnd_date(benefit.getEnd_date());
                    benefitDTO.setCreated_at(benefit.getCreated_at());
                    benefitDTO.setUpdated_at(benefit.getUpdated_at());
                    // Fetch associated employee details
                    Employee employee = benefit.getEmployee();
                    if (employee != null) {
                        benefitDTO.setEmployee_id(employee.getEmployeeID());
                    }
                    return benefitDTO;
                })
                .collect(Collectors.toList());
    }


    @Override
    public String addBenefit(BenefitDTO benefitDTO) {
        Benefit benefit = new Benefit();
        benefit.setBenefit_type(benefitDTO.getBenefit_type());
        benefit.setCoverage_details(benefitDTO.getCoverage_details());
        benefit.setStart_date(benefitDTO.getStart_date());
        benefit.setEnd_date(benefitDTO.getEnd_date());
        benefit.setCreated_at(new Date());
        benefit.setUpdated_at(new Date());

        // Fetch and set the employee
        Employee employee = employeeRepository.findById(benefitDTO.getEmployee_id()).orElse(null);
        if (employee == null) {
            return "Employee not found";
        }
        benefit.setEmployee(employee);

        benefitRepository.save(benefit);
        return "Benefit added successfully";
    }

    @Override
    public String addMultipleBenefit(List<BenefitDTO> benefitDTOs) {
        for (BenefitDTO benefitDTO : benefitDTOs) {
            // Fetch and set the employee
            Employee employee = employeeRepository.findById(benefitDTO.getEmployee_id()).orElse(null);
            if (employee == null) {
                return "Employee not found";
            }

            Benefit benefit = new Benefit();
            benefit.setBenefit_type(benefitDTO.getBenefit_type());
            benefit.setCoverage_details(benefitDTO.getCoverage_details());
            benefit.setStart_date(benefitDTO.getStart_date());
            benefit.setEnd_date(benefitDTO.getEnd_date());
            benefit.setCreated_at(new Date());
            benefit.setUpdated_at(new Date());

            benefit.setEmployee(employee);

            benefitRepository.save(benefit);
        }
        return "Benefits records added successfully";
    }

    @Override
    @Transactional
    public String updateBenefitById(int id, BenefitDTO benefitDTO) {
        Optional<Benefit> benefitOpt = benefitRepository.findById((int) id);
        if (benefitOpt.isPresent()) {
            Benefit benefit = benefitOpt.get();
            benefit.setBenefit_type(benefitDTO.getBenefit_type());
            benefit.setCoverage_details(benefitDTO.getCoverage_details());
            benefit.setStart_date(benefitDTO.getStart_date());
            benefit.setEnd_date(benefitDTO.getEnd_date());
            benefit.setUpdated_at(new Date());

            // Fetch and set the employee
            Employee employee = employeeRepository.findById(benefitDTO.getEmployee_id()).orElse(null);
            if (employee == null) {
                return "Employee not found";
            }

            benefit.setEmployee(employee);  // Set employee

            benefitRepository.save(benefit);
            return "Benefit updated successfully";
        } else {
            return "Benefit not found";
        }
    }
}
