package com.rental.vehicle;

import com.rental.customer.Customer;

public interface Rentable {
    void rent(Customer customer, int days);
    void returnVehicle();
}