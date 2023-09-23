package com.prescriptionManagement.prescriptionMagementSystem.controller;

import com.prescriptionManagement.prescriptionMagementSystem.entity.Prescription;
import com.prescriptionManagement.prescriptionMagementSystem.payload.RequestDTO;
import com.prescriptionManagement.prescriptionMagementSystem.response.PrescriptionResponse;
import com.prescriptionManagement.prescriptionMagementSystem.service.impl.PrescriptionServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionServiceImpl prescriptionServiceImpl;

    @PostMapping()
    public ResponseEntity<PrescriptionResponse> createPrescription(@RequestBody @Valid RequestDTO requestDto){
        PrescriptionResponse responseDto = prescriptionServiceImpl.createPrescription(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<PrescriptionResponse> getPrescriptionById(@PathVariable Long id) {
        PrescriptionResponse prescriptionResponse = prescriptionServiceImpl.getPrescriptionById(id);
        return ResponseEntity.ok().body(prescriptionResponse);
    }

    @GetMapping
    public ResponseEntity<List<PrescriptionResponse>> getAllPrescriptions(){
        List<PrescriptionResponse> prescriptionResponseList = prescriptionServiceImpl.getAllPrescriptions();
        return ResponseEntity.ok().body(prescriptionResponseList);
    }
//
//
    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionResponse> updatePrescription(@RequestBody @Valid RequestDTO requestDTO, @PathVariable("id") Long id){
        PrescriptionResponse prescriptionResponse = prescriptionServiceImpl.updatePrescription(requestDTO, id);
        return ResponseEntity.ok().body(prescriptionResponse);
    }
//
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrescription(@PathVariable("id") Long id) {
        prescriptionServiceImpl.deletePrescription(id);
        return new ResponseEntity<>("Prescription deleted successfully", HttpStatus.OK);
    }

}
