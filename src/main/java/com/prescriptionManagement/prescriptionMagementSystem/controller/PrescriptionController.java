package com.prescriptionManagement.prescriptionMagementSystem.controller;

import com.prescriptionManagement.prescriptionMagementSystem.entity.Prescription;
import com.prescriptionManagement.prescriptionMagementSystem.service.PrescriptionService;
import com.prescriptionManagement.prescriptionMagementSystem.service.impl.PrescriptionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/prescription")
public class PrescriptionController {

    public PrescriptionServiceImpl prescriptionServiceImpl;

    public PrescriptionController(PrescriptionServiceImpl prescriptionServiceImpl){
        this.prescriptionServiceImpl = prescriptionServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription){
        return new ResponseEntity<>(prescriptionServiceImpl.createPrescription(prescription), HttpStatus.CREATED);
    }

    @GetMapping("{prescriptionId}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long prescriptionId) {
        Prescription prescription = prescriptionServiceImpl.getPrescriptionById(prescriptionId);
        return ResponseEntity.ok(prescription);

    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updatePrescription(@RequestBody Prescription prescription, @PathVariable("id") Long id){
        prescriptionServiceImpl.updatePrescription(prescription, id);

        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrescription(@PathVariable("id") Long id) {
        prescriptionServiceImpl.deletePrescription(id);
        return new ResponseEntity<>("Post entity Deleted successfully", HttpStatus.OK);
    }

}
