package com.humanresourcemanagementsystem.Controller.AssetController;
import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Service.AssetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/assets")
public class AssetController
{
    @Autowired
    private AssetService assetService;

    //Save Single Asset
    @PostMapping("/save")
    public String saveAsset(@RequestBody AssetDTO assetDTO) {
        return assetService.addAsset(assetDTO);
    }

    //Save Multiple Assets
    @PostMapping("/multi")
    public ResponseEntity<?> createMultipleAsset(@RequestBody List<AssetDTO> assetDTOs) {
        String response = assetService.addMultipleAsset(assetDTOs);
        return ResponseEntity.ok(response);
    }

    // Get Asset By ID
    @GetMapping("/{id}")
    public AssetDTO getAssetById(@PathVariable int id) {
        return assetService.getAssetById(id);
    }

    // Get assets by employee ID
    @GetMapping("/employee/{employeeId}")
    public List<AssetDTO> getAssetsByEmployeeId(@PathVariable Long employeeId) {
        return assetService.getAssetsByEmployeeId(employeeId);
    }

    // Get All Assets
    @GetMapping("/all")
    public List<AssetDTO> getAllAsset() {
        return assetService.getAllAsset() ;
    }

    // Update Asset By ID
    @PutMapping("/update/{id}")
    public String updateAssetById(@PathVariable int id, @RequestBody AssetDTO assetDTO) {
        return assetService.updateAssetById(id, assetDTO);
    }
}
