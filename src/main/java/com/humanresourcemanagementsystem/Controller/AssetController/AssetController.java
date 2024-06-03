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

    // Get employee by ID
    @GetMapping("/{id}")
    public AssetDTO getAssetById(@PathVariable int id) {
        return assetService.getAssetById(id);
    }

    // Get all employees
    @GetMapping("/all")
    public List<AssetDTO> getAllAsset() {
        return assetService.getAllAsset() ;

    }

}
