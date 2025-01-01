package com.rental.vehicle;

public class Truck extends Vehicle {
    private double loadFactor;

    public Truck(String vehicleId, String model, double baseRentalRate, boolean isAvailable, double loadFactor) {
        super(vehicleId, model, baseRentalRate, isAvailable);
        this.loadFactor = loadFactor;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * (1 + loadFactor);
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
}