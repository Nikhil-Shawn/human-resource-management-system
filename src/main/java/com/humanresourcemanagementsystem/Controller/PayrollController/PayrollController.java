package com.humanresourcemanagementsystem.Controller.PayrollController;

import com.humanresourcemanagementsystem.Dto.PayrollDTO;
import com.humanresourcemanagementsystem.Service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payrolls")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @GetMapping("/")
    public List<PayrollDTO> getAllPayrolls() {
        return payrollService.getAllPayrolls();
    }

    @GetMapping("/{id}")
    public PayrollDTO getPayrollById(@PathVariable Long id) {
        return payrollService.getPayrollById(id);
    }

    @PostMapping("/addPayroll/{id}")
    public PayrollDTO createPayroll(@PathVariable Long id, @RequestBody PayrollDTO payrollDTO) {
        return payrollService.createPayroll(id, payrollDTO);
    }

    @PutMapping("/{id}")
    public PayrollDTO updatePayroll(@PathVariable Long id, @RequestBody PayrollDTO payrollDTO) {
        return payrollService.updatePayroll(id, payrollDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
    }
}
