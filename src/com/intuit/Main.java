package com.intuit;

import com.intuit.model.*;
import com.intuit.service.FuelManagementService;
import com.intuit.service.impl.FuelManagementServiceImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public static void addEmployees(Admin admin) {

        Employee petrolMan = new Employee(123, "Petrol Man");
        Employee dieselMan = new Employee(234, "Diesel Man");

        admin.hireEmployee(petrolMan);
        admin.hireEmployee(dieselMan);
    }


    public static void main(String[] args) {

        // Take car input here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Vehicles");

        Integer carsCount = sc.nextInt();
        Queue<Vehicle> vehicles = new LinkedList<>();
        sc.nextLine();

        System.out.println("Please enter the type of Vehicle(s) - Type 'D' or 'd' for Diesel Car and 'P' or 'p' for Petrol type Vehicle");
        System.out.println("Please enter 'i' or 'I' for Important / Priority Vehicles");
        for(int i = 0; i<carsCount; i++) {

            String inputString = sc.nextLine();

            if(inputString.equals("i") || inputString.equals("I")) {

                // Providing any fuel type here.
                vehicles.add(new Vehicle(FuelType.PETROL, true));
            }


            if(inputString.equals("D") || inputString.equals("d")) {
                vehicles.add(new Vehicle(FuelType.DIESEL, false));
            }
            else if(inputString.equals("P") || inputString.equals("p")) {
                vehicles.add(new Vehicle(FuelType.PETROL, false));
            }
        }

        FuelManagementService fuelManagementService = new FuelManagementServiceImpl();


        // Start the station now.
        Admin admin = new Admin();
        addEmployees(admin);
        fuelManagementService.startStation(admin.getEmployees());
        VehicleQueue vehicleQueue = fuelManagementService.initializeVehicles(vehicles);
        fuelManagementService.manageStation(vehicleQueue, admin.getPetrolStations(), admin.getDieselStations(), admin.getEmployees().size(), admin.getCategoriesOfStations());

    }
}
