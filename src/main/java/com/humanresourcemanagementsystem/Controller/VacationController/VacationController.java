package com.humanresourcemanagementsystem.Controller.VacationController;

import com.humanresourcemanagementsystem.Dto.VacationDTO;
import com.humanresourcemanagementsystem.Service.VacationService;
import com.humanresourcemanagementsystem.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//Mapping the HTTP requests to the methods in the vacation controller
@RequestMapping("/api/vacations")
public class VacationController {

    @Autowired
    private VacationService vacationService;

    // Get all vacations
    @GetMapping
    public ResponseEntity<ResponseData> getAllVacations() {
        // Fetches vacations using the service
        List<VacationDTO> vacations = vacationService.getAllVacations();

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("vacations", vacations);

        return ResponseEntity.ok(new ResponseData("Success", true, responseData));
    }


    // Get vacation by ID
    @GetMapping("/{id}")
    public ResponseEntity<ResponseData> getVacationById(@PathVariable Long id) {
        // Fetches vacation using the service
        VacationDTO vacationDTO = vacationService.getVacationById(id);
        if (vacationDTO != null) {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("vacation", vacationDTO);
            return ResponseEntity.ok(new ResponseData("Success", true, responseData));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Create Vacation
    @PostMapping("/addVacation/{id}")
    public ResponseEntity<ResponseData> createVacation(@PathVariable Long id, @RequestBody VacationDTO vacationDTO) {
        // Calls the service to add the vacation
        ResponseData responseData = vacationService.createVacation(id, vacationDTO);
        return ResponseEntity.ok(responseData);
    }

    // Update vacation by id
    @PutMapping("/updateVacation/{id}")
    public ResponseEntity<ResponseData> updateVacation(@PathVariable Long id, @RequestBody VacationDTO vacationDTO) {
        // Calls the service to update the vacation
        ResponseData responseData = vacationService.updateVacation(id, vacationDTO);
        return ResponseEntity.ok(responseData);
    }

    //Delete vacation by ID
    @DeleteMapping("/deleteVacation/{id}")
    public ResponseEntity<ResponseData> deleteVacation(@PathVariable Long id) {
        // Calls the service to delete the vacation
        ResponseData responseData = vacationService.deleteVacation(id);
        return ResponseEntity.ok(responseData);
    }
}
