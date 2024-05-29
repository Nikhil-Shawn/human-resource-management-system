package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.BenefitDTO;
import com.humanresourcemanagementsystem.Entity.Benefit;
import com.humanresourcemanagementsystem.Entity.Employee;
import com.humanresourcemanagementsystem.Repo.BenefitRepository;
import com.humanresourcemanagementsystem.Repo.EmployeeRepository;
import com.humanresourcemanagementsystem.Service.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BenefitIMPL implements BenefitService {

    @Autowired
    private BenefitRepository benefitRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

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
}
