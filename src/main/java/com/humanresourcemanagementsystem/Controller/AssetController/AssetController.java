package com.humanresourcemanagementsystem.Controller.AssetController;
import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Dto.EmployeeDTO;
import com.humanresourcemanagementsystem.Service.AssetService;
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

   // Delete asset by id
    @DeleteMapping("/delete/{id}")
    public String deleteAssetById(@PathVariable long id) {
        return assetService.deleteAssetById(id);
    }

}
