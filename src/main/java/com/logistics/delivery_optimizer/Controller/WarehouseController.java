package com.logistics.delivery_optimizer.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.logistics.delivery_optimizer.service.WarehouseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.logistics.delivery_optimizer.dto.WarehouseRequestDTO;
import com.logistics.delivery_optimizer.dto.WarehouseResponseDTO;


@RestController
@RequestMapping("/api/v1/warehouses")
public class WarehouseController {

    private WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping
    public WarehouseResponseDTO createWarehouse(@RequestBody WarehouseRequestDTO requestDTO) {
        return warehouseService.createWarehouse(requestDTO);
    }
    


    
}
