package com.prescriptionManagement.prescriptionMagementSystem.service;

import com.prescriptionManagement.prescriptionMagementSystem.entity.Prescription;

import java.util.List;

public interface PrescriptionService {
    Prescription createPrescription(Prescription prescription);
    Prescription getPrescriptionById(Long id);
    List<Prescription> getAllPrescriptions();


    void updatePrescription(Prescription prescription, Long id);

    void deletePrescription(Long id);
}
