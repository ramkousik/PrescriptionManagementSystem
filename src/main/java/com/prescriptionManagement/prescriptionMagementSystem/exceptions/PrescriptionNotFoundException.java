package com.prescriptionManagement.prescriptionMagementSystem.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PrescriptionNotFoundException extends RuntimeException{
    public PrescriptionNotFoundException(String message){
        super(message);
    }
}
