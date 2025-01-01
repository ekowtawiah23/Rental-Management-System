package com.rental.transaction;

import com.rental.vehicle.Vehicle;
import com.rental.customer.Customer;

import java.time.LocalDate;

public class RentalTransaction {
    private  final String transactionId;
    private final Vehicle vehicle;
    private final Customer customer;
    private final LocalDate rentalDate;
    private final LocalDate returnDate;
    private final int rentalDays;
    private final double totalCost;
    private boolean isCompleted;

    public RentalTransaction(String transactionId, Vehicle vehicle, Customer customer, int rentalDays) {
        this.transactionId = transactionId;
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentalDate = LocalDate.now();
        this.returnDate = rentalDate.plusDays(rentalDays);
        this.rentalDays = rentalDays;
        this.totalCost = vehicle.calculateRentalCost(rentalDays);
        this.isCompleted = false; // Transaction starts as incomplete
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void completeTransaction() {
        this.isCompleted = true;
        vehicle.setAvailable(true); // Mark the vehicle as available
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
                "\nVehicle: " + vehicle.getModel() +
                "\nCustomer: " + customer.getName() +
                "\nRental Date: " + rentalDate +
                "\nReturn Date: " + returnDate +
                "\nRental Days: ¢" + rentalDays +
                "\nTotal Cost: ¢" + totalCost +
                "\nStatus: " + (isCompleted ? "Completed" : "Ongoing");
    }
}