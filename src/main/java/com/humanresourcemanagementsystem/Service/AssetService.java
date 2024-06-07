package com.humanresourcemanagementsystem.Service;
import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Dto.BenefitDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AssetService {
    @Transactional
    String addAsset(AssetDTO assetDTO);
    String addMultipleAsset(List<AssetDTO> assetDTOs);
    AssetDTO getAssetById(int id);
    List<AssetDTO> getAllAsset();
    String updateAssetById(int id, AssetDTO assetDTO);
}