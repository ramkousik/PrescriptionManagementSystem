package com.prescriptionManagement.prescriptionMagementSystem.response;

import lombok.Data;

@Data
public class PrescriptionResponse {
    private Long id;
    private String pName;
    private String tabletName;
    private int quantity;
    private String timePeriod;
}
