package com.humanresourcemanagementsystem.Controller.PayrollController;

import com.humanresourcemanagementsystem.Dto.PayrollDTO;
import com.humanresourcemanagementsystem.Service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Mapping the HTTP requests to the methods in the payroll controller
@RequestMapping("api/payrolls")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    // Get all payrolls
    @GetMapping("/")
    public List<PayrollDTO> getAllPayrolls() {
        // Fetches Payrolls using the service
        return payrollService.getAllPayrolls();
    }

    // Get payroll by ID
    @GetMapping("/{id}")
    public PayrollDTO getPayrollById(@PathVariable Long id) {
        // Fetches Payroll using the service
        return payrollService.getPayrollById(id);
    }

    //Create Payroll
    @PostMapping("/addPayroll/{id}")
    public PayrollDTO createPayroll(@PathVariable Long id, @RequestBody PayrollDTO payrollDTO) {
        // Calls the service to add the payroll
        return payrollService.createPayroll(id, payrollDTO);
    }

    // Update payroll by id
    @PutMapping("/{id}")
    public PayrollDTO updatePayroll(@PathVariable Long id, @RequestBody PayrollDTO payrollDTO) {
        // Calls the service to update the payroll
        return payrollService.updatePayroll(id, payrollDTO);
    }

    //Delete payroll by ID
    @DeleteMapping("/{id}")
    public void deletePayroll(@PathVariable Long id) {
        // Calls the service to delete the payroll
        payrollService.deletePayroll(id);
    }
}
