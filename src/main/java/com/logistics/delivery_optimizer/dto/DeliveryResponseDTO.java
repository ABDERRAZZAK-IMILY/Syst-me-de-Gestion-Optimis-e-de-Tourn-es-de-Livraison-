package com.logistics.delivery_optimizer.dto;

import com.logistics.delivery_optimizer.Model.Enums.DeliveryStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryResponseDTO {
    private Long id;
    private double longitude;
    private double latitude;
    private double weightKg;
    private double volumeM3;
    private String preferredTimeWindow;
    private DeliveryStatus status;

    
}
