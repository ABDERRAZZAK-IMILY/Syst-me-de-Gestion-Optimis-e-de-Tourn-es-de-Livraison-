package com.logistics.delivery_optimizer.Model;

import com.logistics.delivery_optimizer.Model.Enums.DeliveryStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double longitude;
    
    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private  double weightKg;

    @Column(nullable = false)
    private double volumeM3;

    private String preferredTimeWindow;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status;


    




    
}
