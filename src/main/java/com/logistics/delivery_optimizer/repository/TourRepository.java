package com.logistics.delivery_optimizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logistics.delivery_optimizer.Model.Delivery;
import com.logistics.delivery_optimizer.Model.Tour;
import java.util.List;

public interface TourRepository extends JpaRepository<Tour , Long> {
    List<Delivery> findByTourId(Long tourId);
    
}
