package com.humanresourcemanagementsystem.Controller.AssetController;
import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Service.AssetService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
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
}
