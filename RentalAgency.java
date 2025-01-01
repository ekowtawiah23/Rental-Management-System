package com.rental.agency;

import com.rental.vehicle.Vehicle;
import com.rental.customer.Customer;
import com.rental.transaction.RentalTransaction;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> fleet;
    private List<RentalTransaction> transactions;

    public RentalAgency() {
        this.fleet = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public List<Vehicle> getFleet() {
        return fleet;
    }

    public Vehicle findVehicleById(String vehicleId) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equalsIgnoreCase(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    public void rentVehicle(String vehicleId, Customer customer, int days) {
        Vehicle vehicle = findVehicleById(vehicleId);
        if (vehicle != null && vehicle.isAvailable()) {
            vehicle.setAvailable(false);
            RentalTransaction transaction = new RentalTransaction(
                    "TXN" + (transactions.size() + 1), vehicle, customer, days
            );
            transactions.add(transaction);
            customer.addRentalHistory(transaction.toString());
            customer.addLoyaltyPoints(days * 10);
            System.out.println("Rental Successful:\n" + transaction);
        } else {
            System.out.println("Vehicle is not available for rental.");
        }
    }

    public void returnVehicle(String vehicleId) {
        for (RentalTransaction transaction : transactions) {
            if (transaction.getVehicle().getVehicleId().equalsIgnoreCase(vehicleId) && !transaction.isCompleted()) {
                transaction.completeTransaction();
                System.out.println("Vehicle returned successfully:\n" + transaction);
                return;
            }
        }
        System.out.println("No ongoing transaction found for the given vehicle ID.");
    }

    public void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (RentalTransaction transaction : transactions) {
                System.out.println(transaction + "\n");
            }
        }
    }
}