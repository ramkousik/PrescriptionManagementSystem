package com.prescriptionManagement.prescriptionMagementSystem.service;

import com.prescriptionManagement.prescriptionMagementSystem.entity.Prescription;
import com.prescriptionManagement.prescriptionMagementSystem.payload.RequestDTO;
import com.prescriptionManagement.prescriptionMagementSystem.response.PrescriptionResponse;

import java.util.List;

public interface PrescriptionService {
    PrescriptionResponse createPrescription(RequestDTO prescription);
    PrescriptionResponse getPrescriptionById(Long id);
    List<PrescriptionResponse> getAllPrescriptions();


    PrescriptionResponse updatePrescription(RequestDTO requestDTO, Long id);

    void deletePrescription(Long id);
}
