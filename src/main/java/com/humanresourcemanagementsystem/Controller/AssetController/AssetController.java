package com.humanresourcemanagementsystem.Controller.AssetController;

import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.response.AssetResponse;
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
    public AssetResponse saveAsset(@RequestBody AssetDTO assetDTO)
    {
        System.out.println("Hello");
        return assetService.addAsset(assetDTO);

    }
}
