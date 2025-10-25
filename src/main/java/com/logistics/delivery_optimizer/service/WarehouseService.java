package com.logistics.delivery_optimizer.service;


public interface WarehouseService {

    WarehouseResponseDTO getWarehouseById(Long id);
    WarehouseResponseDTO createWarehouse(WarehouseRequestDTO warehouseRequestDTO);
    WarehouseResponseDTO updateWarehouse(Long id, WarehouseRequestDTO warehouseRequestDTO);
    void deleteWarehouse(Long id);
    
}