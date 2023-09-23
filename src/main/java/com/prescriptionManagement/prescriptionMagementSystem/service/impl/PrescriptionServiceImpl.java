package com.prescriptionManagement.prescriptionMagementSystem.service.impl;

import com.prescriptionManagement.prescriptionMagementSystem.entity.Prescription;
import com.prescriptionManagement.prescriptionMagementSystem.exceptions.PrescriptionNotFoundException;
import com.prescriptionManagement.prescriptionMagementSystem.payload.RequestDTO;
import com.prescriptionManagement.prescriptionMagementSystem.repository.PrescriptionRepository;
import com.prescriptionManagement.prescriptionMagementSystem.response.PrescriptionResponse;
import com.prescriptionManagement.prescriptionMagementSystem.service.PrescriptionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PrescriptionResponse createPrescription(RequestDTO requestDTO) {
        Prescription newPrescription = modelMapper.map(requestDTO, Prescription.class);
        Prescription prescription = prescriptionRepository.save(newPrescription);
        PrescriptionResponse prescriptionResponse = modelMapper.map(prescription, PrescriptionResponse.class);
        return prescriptionResponse;
    }

    @Override
    public PrescriptionResponse getPrescriptionById(Long id) {
//        try{
//            Optional<Prescription> prescription = prescriptionRepository.findById(id);
//            if (prescription.isPresent()){
//                PrescriptionResponse prescriptionResponse = modelMapper.map(prescription, PrescriptionResponse.class);
//                return prescriptionResponse;
//            } throw new PrescriptionNotFoundException();
//
//        } catch (PrescriptionNotFoundException e) {
//           throw new PrescriptionNotFoundException(e.getMessage());
//        }

        try {
            Prescription prescription = prescriptionRepository.findById(id)
                    .orElseThrow(() -> new PrescriptionNotFoundException("Prescription with ID: " + "'" + id + "'"+ " Not Found"));
            PrescriptionResponse prescriptionResponse = modelMapper.map(prescription, PrescriptionResponse.class);
            return prescriptionResponse;

        } catch (PrescriptionNotFoundException e) {
           throw new PrescriptionNotFoundException(e.getMessage());
        }
    }

    @Override
    public List<PrescriptionResponse> getAllPrescriptions() {
       try {

           List<Prescription> prescriptions = prescriptionRepository.findAll();
           if (!prescriptions.isEmpty()){
               List<PrescriptionResponse> prescriptionResponseList = new ArrayList<>();
               for (Prescription p : prescriptions) {
                   PrescriptionResponse prescriptionResponseUtil = modelMapper.map(p, PrescriptionResponse.class);
                   prescriptionResponseList.add(prescriptionResponseUtil);
               }
               return prescriptionResponseList;
           } throw new PrescriptionNotFoundException("No prescriptions found");

       } catch (PrescriptionNotFoundException e) {
           throw new PrescriptionNotFoundException(e.getMessage());
       }


    }

    @Override
    public PrescriptionResponse updatePrescription(RequestDTO requestDTO, Long id) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new PrescriptionNotFoundException("Prescription with ID: " + "'" + id + "'" + " Not Found"));


        Prescription prescriptionEntity = modelMapper.map(requestDTO, Prescription.class);
        prescriptionEntity.setId(id);
        Prescription updatedPrescription = prescriptionRepository.save(prescriptionEntity);
        PrescriptionResponse prescriptionResponse = modelMapper.map(updatedPrescription, PrescriptionResponse.class);
        return prescriptionResponse;
    }

    @Override
    public void deletePrescription(Long id) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new PrescriptionNotFoundException("Prescription with ID: " + "'" + id + "'" + " Not Found"));

        prescriptionRepository.deleteById(id);

    }
}