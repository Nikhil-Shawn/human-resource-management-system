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
@RequestMapping("/api/vacations")
public class VacationController {

    @Autowired
    private VacationService vacationService;

    @GetMapping
    public ResponseEntity<ResponseData> getAllVacations() {
        List<VacationDTO> vacations = vacationService.getAllVacations();

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("vacations", vacations);

        return ResponseEntity.ok(new ResponseData("Success", true, responseData));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseData> getVacationById(@PathVariable Long id) {
        VacationDTO vacationDTO = vacationService.getVacationById(id);
        if (vacationDTO != null) {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("vacation", vacationDTO);
            return ResponseEntity.ok(new ResponseData("Success", true, responseData));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addVacation/{id}")
    public ResponseEntity<ResponseData> createVacation(@PathVariable Long id, @RequestBody VacationDTO vacationDTO) {
        ResponseData responseData = vacationService.createVacation(id, vacationDTO);
        return ResponseEntity.ok(responseData);
    }

    @PutMapping("/updateVacation/{id}")
    public ResponseEntity<ResponseData> updateVacation(@PathVariable Long id, @RequestBody VacationDTO vacationDTO) {
        ResponseData responseData = vacationService.updateVacation(id, vacationDTO);
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/deleteVacation/{id}")
    public ResponseEntity<ResponseData> deleteVacation(@PathVariable Long id) {
        ResponseData responseData = vacationService.deleteVacation(id);
        return ResponseEntity.ok(responseData);
    }
}
