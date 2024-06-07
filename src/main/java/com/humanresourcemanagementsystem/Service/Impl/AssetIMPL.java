package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Dto.BenefitDTO;
import com.humanresourcemanagementsystem.Entity.Asset;
import com.humanresourcemanagementsystem.Entity.Benefit;
import com.humanresourcemanagementsystem.Entity.Employee;
import com.humanresourcemanagementsystem.Repo.AssetRepository;
import com.humanresourcemanagementsystem.Repo.EmployeeRepository;
import com.humanresourcemanagementsystem.Service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssetIMPL implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public AssetDTO getAssetById(int id) {
        Optional<Asset> assetOpt = assetRepository.findById((long) id);
        if (assetOpt.isPresent()) {
            Asset asset = assetOpt.get();
            // Fetch associated asset information
            AssetDTO assetDTO = new AssetDTO();
            assetDTO.setAsset_id(asset.getAsset_id());
            assetDTO.setAsset_type(asset.getAsset_type());
            assetDTO.setSerial_number(asset.getSerial_number());
            assetDTO.setIssued_date(asset.getIssued_date());
            assetDTO.setReturn_date(asset.getReturn_date());
            assetDTO.setCreated_at(asset.getCreated_at());
            assetDTO.setUpdated_at(asset.getUpdated_at());
            // Fetch associated employee details
            Employee employee = asset.getEmployee();
            if (employee != null) {
                assetDTO.setEmployee_id(employee.getEmployeeID());
            }
            return assetDTO;
        } else {
            throw new RuntimeException("Asset not found with id: " + id);
        }
    }

    @Override
    public List<AssetDTO> getAllAsset() {
        List<Asset> assets = assetRepository.findAll();
        return assets.stream()
                .map(asset -> {
                    AssetDTO assetDTO = new AssetDTO();
                    assetDTO.setAsset_id(asset.getAsset_id());
                    assetDTO.setAsset_type(asset.getAsset_type());
                    assetDTO.setSerial_number(asset.getSerial_number());
                    assetDTO.setIssued_date(asset.getIssued_date());
                    assetDTO.setReturn_date(asset.getReturn_date());
                    assetDTO.setCreated_at(asset.getCreated_at());
                    assetDTO.setUpdated_at(asset.getUpdated_at());
                    // Fetch associated employee details
                    Employee employee = asset.getEmployee();
                    if (employee != null) {
                        assetDTO.setEmployee_id(employee.getEmployeeID());
                    }
                    return assetDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public String addAsset(AssetDTO assetDTO) {

        // Fetch and set the employee
        Employee employee = employeeRepository.findById(assetDTO.getEmployee_id()).orElse(null);
        if (employee == null) {
            return "Employee not found";
        }

        // Check if the employee already has an asset assigned
        if (assetRepository.existsByEmployee(employee)) {
            return "Employee already has an asset assigned";
        }

        Asset asset = new Asset();
        asset.setAsset_type(assetDTO.getAsset_type());
        asset.setSerial_number(assetDTO.getSerial_number());
        asset.setIssued_date(assetDTO.getIssued_date());
        asset.setReturn_date(assetDTO.getReturn_date());
        asset.setCreated_at(new Date());
        asset.setUpdated_at(new Date());

        // Set the employee in the asset
        asset.setEmployee(employee);

        assetRepository.save(asset);
        return "Asset added successfully";
    }

    @Override
    public String addMultipleAsset(List<AssetDTO> assetDTOs) {
        for (AssetDTO assetDTO : assetDTOs) {
            // Fetch and set the employee
            Employee employee = employeeRepository.findById(assetDTO.getEmployee_id()).orElse(null);
            if (employee == null) {
                return "Employee not found";
            }

            Asset asset = new Asset();
            asset.setAsset_type(assetDTO.getAsset_type());
            asset.setSerial_number(assetDTO.getSerial_number());
            asset.setIssued_date(assetDTO.getIssued_date());
            asset.setReturn_date(assetDTO.getReturn_date());
            asset.setCreated_at(new Date());
            asset.setUpdated_at(new Date());

            // Set the employee in the asset
            asset.setEmployee(employee);

            assetRepository.save(asset);
        }
        return "Assets records added successfully";
    }


    @Override
    @Transactional
    public String updateAssetById(int id, AssetDTO assetDTO) {
        Optional<Asset> assetOpt = assetRepository.findById((long) id);
        if (assetOpt.isPresent()) {
            Asset asset = assetOpt.get();
            asset.setAsset_type(assetDTO.getAsset_type());
            asset.setSerial_number(assetDTO.getSerial_number());
            asset.setIssued_date(assetDTO.getIssued_date());
            asset.setReturn_date(assetDTO.getReturn_date());
            asset.setUpdated_at(new Date());

            // Fetch and set the employee
            Employee employee = employeeRepository.findById(assetDTO.getEmployee_id()).orElse(null);
            if (employee == null) {
                return "Employee not found";
            }
            // Set the employee in the asset
            asset.setEmployee(employee);
            assetRepository.save(asset);
            return "Asset updated successfully";
        } else {
            return "Asset not found";
        }
    }
}
