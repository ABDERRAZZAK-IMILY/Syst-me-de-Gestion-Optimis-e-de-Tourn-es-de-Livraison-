package com.logistics.delivery_optimizer.dto;

import com.logistics.delivery_optimizer.Model.Enums.VehicleType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequestDTO {

    private String licensePlate;
    private VehicleType type;
    
}
