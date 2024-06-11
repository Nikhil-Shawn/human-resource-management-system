package com.humanresourcemanagementsystem.Service;
import com.humanresourcemanagementsystem.Dto.SeparationDTO;

import java.util.List;

public interface SeparationService {

    // Add Single Separation
    String addSeparation(SeparationDTO separationDTO);

    //Display Separation By ID
    SeparationDTO getSeparationById(int id);

    //Display All Separations
    List<SeparationDTO> getAllSeparations();

    //Update Separation By ID
    String updateSeparationById(int id, SeparationDTO separationDTO);
}