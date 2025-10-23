package com.logistics.delivery_optimizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logistics.delivery_optimizer.Model.Delivery;
import com.logistics.delivery_optimizer.Model.Enums.DeliveryStatus;
import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findByStatus(DeliveryStatus status);
    List<Delivery> findByTourId(Long tourId);
}
