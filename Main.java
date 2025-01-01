package com.rental.main;

import com.rental.vehicle.*;
import com.rental.customer.Customer;
import com.rental.agency.RentalAgency;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();

        Vehicle car = new Car("C001", "Mercedes Benz GLE Class", 70.0, true);
        Vehicle motorcycle = new Motorcycle("M002", "Yamaha MT-07", 35.0, true);
        Vehicle truck = new Truck("T003", "Ford F-150", 100.0, true, 0.5);

        agency.addVehicle(car);
        agency.addVehicle(motorcycle);
        agency.addVehicle(truck);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter your customer ID: ");
        String customerId = scanner.nextLine();
        Customer customer = new Customer(customerId, customerName);

        int choice;

        do {
            System.out.println("\n1. Rent a Vehicle\n2. Return a Vehicle\n3. View Rental History\n4. View Loyalty Points\n5. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Vehicles:");
                    for (Vehicle vehicle : agency.getFleet()) {
                        if (vehicle.isAvailable()) {
                            System.out.println(vehicle.getVehicleId() + ": " + vehicle.getModel());
                        }
                    }

                    System.out.print("Enter Vehicle ID: ");
                    String rentVehicleId = scanner.nextLine();
                    System.out.print("Enter rental days: ");
                    int days = scanner.nextInt();
                    scanner.nextLine();

                    agency.rentVehicle(rentVehicleId, customer, days);
                    break;

                case 2:
                    System.out.print("Enter Vehicle ID to return: ");
                    String returnVehicleId = scanner.nextLine();
                    agency.returnVehicle(returnVehicleId);
                    break;

                case 3:
                    System.out.println("Rental History:");
                    for (String history : customer.getRentalHistory()) {
                        System.out.println(history);
                    }
                    break;

                case 4:
                    System.out.println("Loyalty Points: " + customer.getLoyaltyPoints());
                    break;

                case 5:
                    agency.viewTransactions();
                    break;

                case 6:
                    System.out.println("Exiting. Thank you!");
                    break;



                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}