package com.logistics.delivery_optimizer.mapper;

import com.logistics.delivery_optimizer.Model.Delivery;

public class DeliveryMapper {
    public Delivery toEntity(Delivery dto){

        return Delivery.builder()
                .longitude(dto.getLongitude())
                .latitude(dto.getLatitude())
                .weightKg(dto.getWeightKg())
                .volumeM3(dto.getVolumeM3())
                .preferredTimeWindow(dto.getPreferredTimeWindow())
                .status(dto.getStatus())
                .build();
    }

    public Delivery toDto(Delivery dto){
        return Delivery.builder()
                .id(dto.getId())
                .longitude(dto.getLongitude())
                .latitude(dto.getLatitude())
                .weightKg(dto.getWeightKg())
                .volumeM3(dto.getVolumeM3())
                .preferredTimeWindow(dto.getPreferredTimeWindow())
                .status(dto.getStatus())
                .build();
    }

    
}
