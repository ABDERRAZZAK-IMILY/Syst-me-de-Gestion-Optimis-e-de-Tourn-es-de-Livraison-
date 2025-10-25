package com.logistics.delivery_optimizer.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseResponseDTO {

    private Long id;
    private String name;
    private double longitude;
    private double latitude;
    private String openingTime;
    private String closingTime;
}