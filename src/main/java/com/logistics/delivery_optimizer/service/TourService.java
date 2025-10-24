package com.logistics.delivery_optimizer.service;

import com.logistics.delivery_optimizer.Model.Delivery;
import com.logistics.delivery_optimizer.Model.Tour;
import com.logistics.delivery_optimizer.Model.Warehouse;
import java.util.List;

public interface TourService {
    Tour createOptimizedTour(Long vehicleId, Long warehouseId, List<Long> deliveryIds);

    double getTotalDistance(Tour tour);

    double calculateTourDistance(Warehouse warehouse, List<Delivery> orderedDeliveries);
}
