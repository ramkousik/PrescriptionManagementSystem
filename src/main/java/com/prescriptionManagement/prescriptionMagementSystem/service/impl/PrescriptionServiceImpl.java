package com.prescriptionManagement.prescriptionMagementSystem.service.impl;

import com.prescriptionManagement.prescriptionMagementSystem.entity.Prescription;
import com.prescriptionManagement.prescriptionMagementSystem.repository.PrescriptionRepository;
import com.prescriptionManagement.prescriptionMagementSystem.service.PrescriptionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    public PrescriptionRepository prescriptionRepository;

    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository){
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public Prescription createPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    @Override
    public void updatePrescription(Prescription prescription, Long id) {

        Optional<Prescription> existingPrescriptionOptional = prescriptionRepository.findById(id);

        if (existingPrescriptionOptional.isPresent()) {
            Prescription existingItem = existingPrescriptionOptional.get();


            existingItem.setPName(prescription.getPName());
            existingItem.setQuantity(prescription.getQuantity());
            existingItem.setTabletName(prescription.getTabletName());
            existingItem.setTimePeriod(prescription.getTimePeriod());


            prescriptionRepository.save(existingItem);
        } else {
            throw new EntityNotFoundException("Item with ID " + id + " not found");
        }
    }

    @Override
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);

    }
}
