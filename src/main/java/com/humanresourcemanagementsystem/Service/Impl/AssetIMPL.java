package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Entity.Asset;
import com.humanresourcemanagementsystem.Entity.Employee;
import com.humanresourcemanagementsystem.Repo.AssetRepository;
import com.humanresourcemanagementsystem.Repo.EmployeeRepository;
import com.humanresourcemanagementsystem.Service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AssetIMPL implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String addAsset(AssetDTO assetDTO) {
        Asset asset = new Asset();
        asset.setAsset_type(assetDTO.getAsset_type());
        asset.setSerial_number(assetDTO.getSerial_number());
        asset.setIssued_date(assetDTO.getIssued_date());
        asset.setReturn_date(assetDTO.getReturn_date());
        asset.setCreated_at(new Date());
        asset.setUpdated_at(new Date());

        // Fetch and set the employee
        Employee employee = employeeRepository.findById(assetDTO.getEmployee_id()).orElse(null);
        if (employee == null) {
            return "Employee not found";
        }
        asset.setEmployee(employee);

        assetRepository.save(asset);
        return "Asset added successfully";
    }
}
