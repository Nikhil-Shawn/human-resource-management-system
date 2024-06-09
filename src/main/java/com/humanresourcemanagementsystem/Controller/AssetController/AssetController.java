package com.humanresourcemanagementsystem.Controller.AssetController;
import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Service.AssetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin
//Mapping the HTTP requests to the methods in the asset controller
@RequestMapping("api/v1/asset")
public class AssetController
{
    @Autowired
    private AssetService assetService;

    //Save Single Asset
    @PostMapping("/save")
    public String saveAsset(@RequestBody AssetDTO assetDTO) {
        // Calls the service to add the asset
        return assetService.addAsset(assetDTO);
    }

    //Save Multiple Assets
    @PostMapping("/multi")
    public ResponseEntity<?> createMultipleAsset(@RequestBody List<AssetDTO> assetDTOs) {
        // Calls the service to add the assets
        String response = assetService.addMultipleAsset(assetDTOs);
        return ResponseEntity.ok(response);
    }

    // Get Asset By ID
    @GetMapping("/{id}")
    public AssetDTO getAssetById(@PathVariable int id) {
        // Fetches Asset using the service
        return assetService.getAssetById(id);
    }

    // Get All Assets
    @GetMapping("/all")
    public List<AssetDTO> getAllAsset() {
        // Fetches all assets using the service
        return assetService.getAllAsset() ;

    }

    // Update Asset By ID
    @PutMapping("/update/{id}")
    public String updateAssetById(@PathVariable int id, @RequestBody AssetDTO assetDTO) {
        // Calls the service to update the asset
        return assetService.updateAssetById(id, assetDTO);
    }
}
