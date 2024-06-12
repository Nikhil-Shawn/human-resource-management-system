package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.SeparationDTO;
import com.humanresourcemanagementsystem.Entity.Employee;
import com.humanresourcemanagementsystem.Entity.Separation;
import com.humanresourcemanagementsystem.Repo.SeparationRepository;
import com.humanresourcemanagementsystem.Repo.EmployeeRepository;
import com.humanresourcemanagementsystem.Service.SeparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeparationIMPL implements SeparationService {

    //Provide data access operations for Separation entity
    @Autowired
    private SeparationRepository separationRepository;

    //Provide data access operations for Employee entity
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    //Save single separation
    public String addSeparation(SeparationDTO separationDTO) {

        // Checks if the associated employee exists
        Employee employee = employeeRepository.findById(separationDTO.getEmployee_id()).orElse(null);
        if (separationDTO.getEmployee_id() == null) {
            return "Employee not found";
        }

        // Check if the employee already has a separation
        if (separationRepository.existsByEmployee(employee)) {
            return "Employee already has a separation";
        }

        Separation separation = new Separation();

        // Add associated separation information
        separation.setSeparation_id(separationDTO.getSeparation_id());
        separation.setEmployee_department(separationDTO.getEmployee_department());
        separation.setSeparate_date(separationDTO.getSeparation_date());
        separation.setSeparation_type(separationDTO.getSeparation_type());
        separation.setSeparation_reason(separationDTO.getSeparation_reason());
        separation.setSettlement(separationDTO.getSettlement());
        separation.setCreated_at(new Date());
        separation.setUpdated_at(new Date());

        // Set the employee in the asset
        separation.setEmployee(employee);

        //Save asset details
        separationRepository.save(separation);
        return "Separation added successfully";
    }

    @Override
    //Display Separation by ID
    public SeparationDTO getSeparationById(int id) {
        Optional<Separation> separationOpt = separationRepository.findById((long) id);
        if (separationOpt.isPresent()) {
            Separation separation = separationOpt.get();

            // Fetch associated separation information
            SeparationDTO separationDTO = new SeparationDTO();
            separationDTO.setSeparation_id(separation.getSeparation_id());
            separationDTO.setSeparation_date(separation.getSeparation_date());
            separationDTO.setSeparation_type(separation.getSeparation_type());
            separationDTO.setSeparation_reason(separation.getSeparation_reason());
            separationDTO.setSettlement(separation.getSettlement());
            separationDTO.setCreated_at(new Date());
            separationDTO.setUpdated_at(new Date());

            // Fetch associated employee details
            Employee employee = separation.getEmployee();
            if (employee != null) {
                separationDTO.setEmployee_id(employee.getEmployeeID());
            }
            return separationDTO;
        } else {
            throw new RuntimeException("Separation not found with id: " + id);
        }
    }

    @Override
    //Display all separations
    public List<SeparationDTO> getAllSeparations() {
        List<Separation> assets = separationRepository.findAll();
        return assets.stream()
                .map(separation -> {
                    // Fetch associated separation information
                    SeparationDTO separationDTO = new SeparationDTO();
                    separationDTO.setSeparation_id(separation.getSeparation_id());
                    separationDTO.setSeparation_date(separation.getSeparation_date());
                    separationDTO.setSeparation_type(separation.getSeparation_type());
                    separationDTO.setSeparation_reason(separation.getSeparation_reason());
                    separationDTO.setSettlement(separation.getSettlement());
                    separationDTO.setCreated_at(new Date());
                    separationDTO.setUpdated_at(new Date());

                    // Fetch associated employee details
                    Employee employee = separation.getEmployee();
                    if (employee != null) {
                        separationDTO.setEmployee_id(employee.getEmployeeID());
                    }
                    return separationDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    //Update separation by ID
    public String updateSeparationById(int id, SeparationDTO separationDTO) {
        Optional<Separation> separationOpt = separationRepository.findById((long) id);
        if (separationOpt.isPresent()) {

            // Checks if the associated employee exists
            Employee employee = employeeRepository.findById(separationDTO.getEmployee_id()).orElse(null);
            if (employee == null) {
                return "Employee not found";
            }

            Separation separation = separationOpt.get();
            //separation.setSeparation_id(separationDTO.getSeparation_id());
            separation.setEmployee_department(separationDTO.getEmployee_department());
            separation.setSeparate_date(separationDTO.getSeparation_date());
            separation.setSeparation_type(separationDTO.getSeparation_type());
            separation.setSeparation_reason(separationDTO.getSeparation_reason());
            separation.setSettlement(separationDTO.getSettlement());
            separation.setUpdated_at(new Date());

            // Set the employee in the separation
            separation.setEmployee(employee);

            //Save asset details
            separationRepository.save(separation);
            return "Separation updated successfully";
        } else {
            return "Separation not found";
        }
    }
}
