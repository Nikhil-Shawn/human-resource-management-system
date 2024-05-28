package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.response.AssetResponse;

public interface AssetService {
    AssetResponse addAsset(AssetDTO assetDTO);
}
