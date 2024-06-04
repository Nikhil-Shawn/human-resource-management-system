package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.PayrollDTO;
import com.humanresourcemanagementsystem.Entity.Employee;
import com.humanresourcemanagementsystem.Entity.Payroll;
import com.humanresourcemanagementsystem.Repo.EmployeeRepository;
import com.humanresourcemanagementsystem.Repo.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private EmployeeRepository employeeRepo;

    public List<PayrollDTO> getAllPayrolls() {
        return payrollRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PayrollDTO getPayrollById(Long id) {
        return payrollRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public PayrollDTO createPayroll(Long employeeId, PayrollDTO payrollDTO) {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId.intValue());
        if (employeeOptional.isPresent()) {
            Payroll payroll = new Payroll();
            payroll.setEmployee(employeeOptional.get());
            payroll.setPayAmount(payrollDTO.getPayAmount());
            payroll.setPayFrequency(payrollDTO.getPayFrequency());
            payroll.setBonus(payrollDTO.getBonus());
            payroll.setIncrementApplicable(payrollDTO.getIncrementApplicable());
            payroll.setPercentageIncrement(payrollDTO.getPercentageIncrement());
            payroll.setCreatedAt(payrollDTO.getCreatedAt());
            payroll.setUpdatedAt(payrollDTO.getUpdatedAt());

            Payroll savedPayroll = payrollRepository.save(payroll);
            return convertToDTO(savedPayroll);
        }
            System.out.println("Employee not found for ID: " + employeeId);
            return null;

    }

    public PayrollDTO updatePayroll(Long id, PayrollDTO payrollDTO) {
        if (payrollRepository.existsById(id)) {
            Payroll payroll = payrollRepository.findById(id).orElseThrow();
            payroll.setPayAmount(payrollDTO.getPayAmount());
            payroll.setPayFrequency(payrollDTO.getPayFrequency());
            payroll.setBonus(payrollDTO.getBonus());
            payroll.setIncrementApplicable(payrollDTO.getIncrementApplicable());
            payroll.setPercentageIncrement(payrollDTO.getPercentageIncrement());
            payroll.setUpdatedAt(payrollDTO.getUpdatedAt());

            Payroll updatedPayroll = payrollRepository.save(payroll);
            return convertToDTO(updatedPayroll);
        }
        return null;
    }

    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }

    private PayrollDTO convertToDTO(Payroll payroll) {
        PayrollDTO payrollDTO = new PayrollDTO();
        payrollDTO.setPayroll_id(payroll.getPayroll_id());
        payrollDTO.setEmployeeId(payroll.getEmployee().getEmployeeID());
        payrollDTO.setPayAmount(payroll.getPayAmount());
        payrollDTO.setPayFrequency(payroll.getPayFrequency());
        payrollDTO.setBonus(payroll.getBonus());
        payrollDTO.setIncrementApplicable(payroll.getIncrementApplicable());
        payrollDTO.setPercentageIncrement(payroll.getPercentageIncrement());
        payrollDTO.setCreatedAt(payroll.getCreatedAt());
        payrollDTO.setUpdatedAt(payroll.getUpdatedAt());
        return payrollDTO;
    }
}
