package com.logistics.delivery_optimizer.service;

import com.logistics.delivery_optimizer.Model.Vehicle;
import com.logistics.delivery_optimizer.dto.VehicleRequestDTO;
import com.logistics.delivery_optimizer.dto.VehicleResponseDTO;
import com.logistics.delivery_optimizer.mapper.VehicleMapper;
import com.logistics.delivery_optimizer.repository.VehicleRepository;

public class VehicleServiceImpl implements VehicleService {


    private VehicleRepository vehicleRepository;
    private VehicleMapper vehicleMapper;

    @Override
    public VehicleResponseDTO registerVehicle(VehicleRequestDTO vehicleRequestDTO){
        Vehicle vehicle = vehicleMapper.toEntity(vehicleRequestDTO);
        Vehicle save = vehicleRepository.save(vehicle);
        VehicleResponseDTO response = vehicleMapper.tDto(save);
        return response;
    }


    @Override
    public VehicleResponseDTO getVehicleInfo(Long vehicleId){
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(RuntimeException::new);
        VehicleResponseDTO response = vehicleMapper.tDto(vehicle);
        return response;
    }

    
}
