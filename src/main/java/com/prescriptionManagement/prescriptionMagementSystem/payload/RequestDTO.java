package com.prescriptionManagement.prescriptionMagementSystem.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {

    @NotEmpty(message = "Please enter the Patient name")
    private String pName;
    @NotEmpty(message = "Please enter the medicine name")
    private String tabletName;
    @NotNull(message = "Please give the quantity of the medicine")
    private int quantity;
    @NotEmpty(message = "Please specify at what time the medicine should be consumed")
    private String timePeriod;
}
