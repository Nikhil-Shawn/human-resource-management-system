package com.humanresourcemanagementsystem.Controller.AssetController;
import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Dto.BenefitDTO;
import com.humanresourcemanagementsystem.Dto.EmployeeDTO;
import com.humanresourcemanagementsystem.Service.AssetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/asset")
public class AssetController
{
    @Autowired
    private AssetService assetService;
    @PostMapping("/save")
    public String saveAsset(@RequestBody AssetDTO assetDTO) {
        return assetService.addAsset(assetDTO);
    }

    @PostMapping("/multi")
    public ResponseEntity<?> createMultipleAsset(@RequestBody List<AssetDTO> assetDTOs) {
        String response = assetService.addMultipleAsset(assetDTOs);
        return ResponseEntity.ok(response);
    }

    // Get asset by ID
    @GetMapping("/{id}")
    public AssetDTO getAssetById(@PathVariable int id) {
        return assetService.getAssetById(id);
    }

    // Get all assets
    @GetMapping("/all")
    public List<AssetDTO> getAllAsset() {
        return assetService.getAllAsset() ;

    }

    // Update asset by id
    @PutMapping("/update/{id}")
    public String updateAssetById(@PathVariable int id, @RequestBody AssetDTO assetDTO) {
        return assetService.updateAssetById(id, assetDTO);
    }
}
