package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.VacationDTO;
import com.humanresourcemanagementsystem.Entity.Employee;
import com.humanresourcemanagementsystem.Entity.Vacation;
import com.humanresourcemanagementsystem.Repo.EmployeeRepository;
import com.humanresourcemanagementsystem.Repo.VacationRepository;
import com.humanresourcemanagementsystem.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VacationService {

    @Autowired
    private VacationRepository vacationRepository;

    @Autowired
    private EmployeeRepository employeeRepo;

    //Display all vacations
    public List<VacationDTO> getAllVacations() {
        return vacationRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //Display vacations by ID
    public VacationDTO getVacationById(Long id) {
        return vacationRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    //Create Vacations
    public ResponseData createVacation(Long employeeId, VacationDTO vacationDTO) {
        Optional<Employee> employeeOptional = employeeRepo.findById(Math.toIntExact(employeeId));
        if (employeeOptional.isPresent()) {
            Vacation vacation = new Vacation();
            vacation.setEmployee(employeeOptional.get());
            vacation.setStartDate(vacationDTO.getStartDate());
            vacation.setEndDate(vacationDTO.getEndDate());
            vacation.setReason(vacationDTO.getReason());
            vacation.setStatus(vacationDTO.getStatus());
            vacation.setVacationType(vacationDTO.getVacationType());
            vacation.setCreatedAt(vacationDTO.getCreatedAt());
            vacation.setUpdatedAt(vacationDTO.getUpdatedAt());
            Vacation savedVacation = vacationRepository.save(vacation);
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("vacationId", savedVacation.getVacationId());
            responseData.put("employeeId", savedVacation.getEmployee().getEmployeeID());
            responseData.put("startDate", savedVacation.getStartDate());
            responseData.put("endDate", savedVacation.getEndDate());
            responseData.put("reason", savedVacation.getReason());
            responseData.put("status", savedVacation.getStatus());
            responseData.put("vacationType", savedVacation.getVacationType());
            responseData.put("createdAt", savedVacation.getCreatedAt());
            responseData.put("updatedAt", savedVacation.getUpdatedAt());

            return new ResponseData("Vacation created successfully", true, responseData);
        } else {
            return new ResponseData("Employee not found", false, null);
        }
    }

    //Update vacation
    public ResponseData updateVacation(Long id, VacationDTO vacationDTO) {
        Optional<Vacation> vacationOptional = vacationRepository.findById(id);
        if (vacationOptional.isPresent()) {
            Vacation vacation = vacationOptional.get();
            vacation.setStartDate(vacationDTO.getStartDate());
            vacation.setEndDate(vacationDTO.getEndDate());
            vacation.setReason(vacationDTO.getReason());
            vacation.setStatus(vacationDTO.getStatus());
            vacation.setVacationType(vacationDTO.getVacationType());
            vacation.setUpdatedAt(vacationDTO.getUpdatedAt());
            Vacation updatedVacation = vacationRepository.save(vacation);
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("vacationId", updatedVacation.getVacationId());
            responseData.put("employeeId", updatedVacation.getEmployee().getEmployeeID());
            responseData.put("startDate", updatedVacation.getStartDate());
            responseData.put("endDate", updatedVacation.getEndDate());
            responseData.put("reason", updatedVacation.getReason());
            responseData.put("status", updatedVacation.getStatus());
            responseData.put("vacationType", updatedVacation.getVacationType());
            responseData.put("createdAt", updatedVacation.getCreatedAt());
            responseData.put("updatedAt", updatedVacation.getUpdatedAt());

            return new ResponseData("Vacation updated successfully", true, responseData);
        } else {
            return new ResponseData("Vacation not found", false, null);
        }
    }

    //Delete vacation
    public ResponseData deleteVacation(Long id) {
        Optional<Vacation> vacationOptional = vacationRepository.findById(id);
        if (vacationOptional.isPresent()) {
            vacationRepository.deleteById(id);
            return new ResponseData("Vacation deleted successfully", true, null);
        } else {
            return new ResponseData("Vacation not found", false, null);
        }
    }

    private VacationDTO convertToDTO(Vacation vacation) {
        VacationDTO vacationDTO = new VacationDTO();
        vacationDTO.setVacationId(vacation.getVacationId());
        vacationDTO.setEmployeeId(vacation.getEmployee().getEmployeeID());
        vacationDTO.setStartDate(vacation.getStartDate());
        vacationDTO.setEndDate(vacation.getEndDate());
        vacationDTO.setReason(vacation.getReason());
        vacationDTO.setStatus(vacation.getStatus());
        vacationDTO.setVacationType(vacation.getVacationType());
        vacationDTO.setCreatedAt(vacation.getCreatedAt());
        vacationDTO.setUpdatedAt(vacation.getUpdatedAt());
        return vacationDTO;
    }

}

