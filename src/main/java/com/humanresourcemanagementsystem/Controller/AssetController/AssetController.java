package com.humanresourcemanagementsystem.Controller.AssetController;

import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Dto.EmployeeDTO;
import com.humanresourcemanagementsystem.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin
@RequestMapping("api/v1/asset")


public class AssetController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody AssetDTO assetDTO) {
        return employeeService.addEmployee(assetDTO);
    }


}
