package com.humanresourcemanagementsystem.Service;
import com.humanresourcemanagementsystem.Dto.AssetDTO;

import java.util.List;

public interface AssetService {
    String addAsset(AssetDTO assetDTO);
    AssetDTO getAssetById(int id);
    List<AssetDTO> getAllAsset();
}