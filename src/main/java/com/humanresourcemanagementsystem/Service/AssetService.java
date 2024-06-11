package com.humanresourcemanagementsystem.Service;
import com.humanresourcemanagementsystem.Dto.AssetDTO;

import java.util.List;

public interface AssetService {

    // Add Single Asset
    String addAsset(AssetDTO assetDTO);

    //Add Multiple Assets
    String addMultipleAsset(List<AssetDTO> assetDTOs);

    //Display Asset By ID
    AssetDTO getAssetById(int id);

    List<AssetDTO> getAssetsByEmployeeId(Long employeeId);

    //Display All Assets
    List<AssetDTO> getAllAsset();

    //Update Asset By ID
    String updateAssetById(int id, AssetDTO assetDTO);

}