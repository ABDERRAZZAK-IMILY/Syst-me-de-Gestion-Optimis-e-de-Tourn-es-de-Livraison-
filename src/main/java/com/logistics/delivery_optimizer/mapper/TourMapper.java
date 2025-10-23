package com.logistics.delivery_optimizer.mapper;

import com.logistics.delivery_optimizer.dto.TourResponseDto;
import com.logistics.delivery_optimizer.dto.TourRequestDto;
import com.logistics.delivery_optimizer.Model.Tour;
import com.logistics.delivery_optimizer.Model.Vehicle;
import com.logistics.delivery_optimizer.Model.Warehouse;

public class TourMapper {

     public Tour toEntity(TourRequestDto dto, Warehouse warehouse, Vehicle vehicle) {
        if (dto == null) return null;

        return Tour.builder()
                .TourDate(dto.getTourDate())
                .warehouse(warehouse)
                .vehicle(vehicle)
                .build();
    }

    public TourResponseDto toDto(Tour entity){
        return TourResponseDto.builder()
                .id(entity.getId())
                .tourDate(entity.getTourDate())
                .build(
        );
    }
    
}
