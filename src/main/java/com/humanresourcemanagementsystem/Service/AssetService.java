package com.humanresourcemanagementsystem.Service;
import com.humanresourcemanagementsystem.Dto.AssetDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AssetService {
    @Transactional
    String addAsset(AssetDTO assetDTO);
    AssetDTO getAssetById(int id);
    List<AssetDTO> getAllAsset();
    String deleteAssetById(long id);
}