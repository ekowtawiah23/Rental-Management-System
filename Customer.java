package com.rental.customer;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private List<String> rentalHistory;
    private int loyaltyPoints;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.rentalHistory = new ArrayList<>();
        this.loyaltyPoints = 0;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<String> getRentalHistory() {
        return rentalHistory;
    }

    public void addRentalHistory(String rentalDetails) {
        rentalHistory.add(rentalDetails);
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }
}