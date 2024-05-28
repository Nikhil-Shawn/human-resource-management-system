package com.humanresourcemanagementsystem.Service.Impl;

import com.humanresourcemanagementsystem.Dto.AssetDTO;
import com.humanresourcemanagementsystem.Entity.Asset;
import com.humanresourcemanagementsystem.Repo.AssetRepository;
import com.humanresourcemanagementsystem.Service.AssetService;
import com.humanresourcemanagementsystem.response.AssetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AssetImp implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

//    @Autowired
//    private AuthenticationManager authenticationManager;


    @Override
    public AssetResponse addAsset(AssetDTO AssetDTO) {
        Asset Asset = new Asset(
                AssetDTO.getAsset_id(),
                AssetDTO.getAsset_type(),
                AssetDTO.getSerial_number(),
                AssetDTO.getIssued_date(),
                AssetDTO.getReturn_date(),
                AssetDTO.getCreated_at(),
                AssetDTO.getUpdated_at()

        );
        assetRepository.save(Asset);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("Asset type", Asset.getAsset_type());
        responseData.put("serial_number", Asset.getSerial_number());

        return new AssetResponse("Success", true, responseData);
    }
}