package com.logistics.delivery_optimizer.service.optimizer;

import com.logistics.delivery_optimizer.Model.Delivery;
import com.logistics.delivery_optimizer.Model.Vehicle;
import com.logistics.delivery_optimizer.Model.Warehouse;
import com.logistics.delivery_optimizer.Model.Enums.VehicleType;
import com.logistics.delivery_optimizer.util.DistanceCalculator;

import java.util.*;

public class ClarkeWrightOptimizer implements TourOptimizer {


    private static class Saving {
        Delivery deliveryA;
        Delivery deliveryB;
        double savingAmount;

        Saving(Delivery a, Delivery b, double saving) {
            this.deliveryA = a;
            this.deliveryB = b;
            this.savingAmount = saving;
        }
    }

    @Override
    public List<Delivery> calculateOptimalTour(Warehouse startPoint, List<Delivery> deliveries, Vehicle vehicle) {
        
        List<Saving> savingsList = new ArrayList<>();
        
        for (int i = 0; i < deliveries.size(); i++) {
            for (int j = i + 1; j < deliveries.size(); j++) {
                Delivery a = deliveries.get(i);
                Delivery b = deliveries.get(j);

                double distWA = DistanceCalculator.distanceBetween(startPoint, a);
                double distWB = DistanceCalculator.distanceBetween(startPoint, b);
                double distAB = DistanceCalculator.distanceBetween(a, b);

                double savingAmount = (distWA + distWB) - distAB;

                if (savingAmount > 0) {
                    savingsList.add(new Saving(a, b, savingAmount));
                }
            }
        }

        savingsList.sort((s1, s2) -> Double.compare(s2.savingAmount, s1.savingAmount));

    
        Map<Long, List<Delivery>> tourMap = new HashMap<>();
        for (Delivery d : deliveries) {
            List<Delivery> singleTour = new ArrayList<>();
            singleTour.add(d);
            tourMap.put(d.getId(), singleTour);
        }
        
        VehicleType vehicleLimits = vehicle.getType();

        for (Saving saving : savingsList) {
            Delivery a = saving.deliveryA;
            Delivery b = saving.deliveryB;

            List<Delivery> tourA = tourMap.get(a.getId());
            List<Delivery> tourB = tourMap.get(b.getId());

            if (tourA == tourB) {
                continue;
            }

            double combinedWeight = tourA.stream().mapToDouble(Delivery::getWeightKg).sum() +
                                tourB.stream().mapToDouble(Delivery::getWeightKg).sum();
            
            double combinedVolume = tourA.stream().mapToDouble(Delivery::getVolumeM3).sum() +
                                tourB.stream().mapToDouble(Delivery::getVolumeM3).sum();
                                
            int combinedCount = tourA.size() + tourB.size();

            if (combinedWeight > vehicleLimits.getMaxWeightKg() ||
                combinedVolume > vehicleLimits.getMaxVolumeM3() ||
                combinedCount > vehicleLimits.getMaxDeliveries()) {
                continue; 
            }

            List<Delivery> mergedTour = null;
            
            if (tourA.get(tourA.size() - 1).equals(a) && tourB.get(0).equals(b)) {
                mergedTour = new ArrayList<>(tourA);
                mergedTour.addAll(tourB);
            } 
            else if (tourA.get(0).equals(a) && tourB.get(tourB.size() - 1).equals(b)) {
                mergedTour = new ArrayList<>(tourB);
                mergedTour.addAll(tourA);
            }

            if (mergedTour != null) {
                for (Delivery d : mergedTour) {
                    tourMap.put(d.getId(), mergedTour);
                }
            }
        }

    
        List<Delivery> bestTour = tourMap.values().stream()
                .distinct()
                .max(Comparator.comparingInt(List::size))
                .orElse(new ArrayList<>());

        return bestTour;
    }
}