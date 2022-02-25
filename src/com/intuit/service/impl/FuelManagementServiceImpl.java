package com.intuit.service.impl;

import com.intuit.model.Employee;
import com.intuit.model.FuelType;
import com.intuit.model.Vehicle;
import com.intuit.model.VehicleQueue;
import com.intuit.service.FuelManagementService;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class FuelManagementServiceImpl implements FuelManagementService {

    @Override
    public void startStation(List<Employee> employees) {

        // We will instantiate employees here.
        System.out.println("Today, " + employees.toString() + " will serve you!!");
    }

    @Override
    public VehicleQueue initializeVehicles(Queue<Vehicle> vehicles) {

        VehicleQueue vehicleQueue = new VehicleQueue();

        Queue<Vehicle> petrolVehicles = new LinkedList<>();
        Queue<Vehicle> dieselVehicles = new LinkedList<>();
        Queue<Vehicle> priorityVehicles = new LinkedList<>();


        for(Vehicle vehicle: vehicles) {

            if(vehicle.getPriortyVehicle()) {
                priorityVehicles.add(vehicle);
            }

            if(vehicle.getFuelType() == FuelType.PETROL) {
                petrolVehicles.add(vehicle);
            }
            if(vehicle.getFuelType() == FuelType.DIESEL) {
                dieselVehicles.add(vehicle);
            }
        }

        vehicleQueue.setDieselVehicles(dieselVehicles);
        vehicleQueue.setPetrolVehicles(petrolVehicles);
        vehicleQueue.setPriorityVehicles(priorityVehicles);

        return vehicleQueue;

    }

    @Override
    public void managePriorityVehicles(Queue<Vehicle> priorityVehicle, Integer employees, Integer petrolStation) {

        try {

            while(!priorityVehicle.isEmpty()) {

                System.out.println("Filling Priority Cars First");
                System.out.println("Remaining cars: " + priorityVehicle.size());

                // Assuming petrol_stations = diesel_stations.
                int numberOfCarsToBeEvicted = Math.min(employees, petrolStation);

                for(int i = 0; i < numberOfCarsToBeEvicted; i++) {
                    if(!priorityVehicle.isEmpty()) {
                        priorityVehicle.remove();
                    }
                }

                TimeUnit.SECONDS.sleep(2);
            }
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void manageStation(VehicleQueue vehicleQueue, Integer petrolStations, Integer dieselStations, Integer employees, Integer categoryOfStations) {

        if(employees == 0) {
            System.out.println("Sorry, nobody to assist you today");
            return;
        }

        Queue<Vehicle> petrolVehicles = vehicleQueue.getPetrolVehicles();
        Queue<Vehicle> dieselVehicles = vehicleQueue.getDieselVehicles();
        Queue<Vehicle> priorityVehicles = vehicleQueue.getPriorityVehicles();


        if(petrolStations == 0) {
            System.out.println("Sorry, Petrol Station is closed today");
            petrolVehicles.clear();
        }

        if(dieselStations == 0) {
            System.out.println("Sorry, Diesel Station is closed today");
            dieselVehicles.clear();
        }

        // Take care of priority cars first.
        managePriorityVehicles(priorityVehicles, employees, petrolStations);

        // 2 Queues will be processed simultaneously
        if(!petrolVehicles.isEmpty() && !dieselVehicles.isEmpty()) {
            System.out.println("Both the stations In Business!!");
        }

        try {
            while(!petrolVehicles.isEmpty() && !dieselVehicles.isEmpty()) {

                // Pick one car from Petrol and one from Diesel and fill it.

                System.out.println("Remaining Petrol Vehicles: " + petrolVehicles.size());
                System.out.println("Remaining Diesel Vehicles: " + dieselVehicles.size());

                // As long as cars are there in petrol and diesel stations, at least one guy has to be there on each of these stations.
                // Now, if we have some extra employee or new employees, we can devise a logic of where to put them.
                // At least 2 workers (according to question) workers are occupied
                // Assuming petrol_stations = diesel_stations

                int flexibleEmployees = employees % categoryOfStations;
                int fixedEmployeesPerStation = (employees - flexibleEmployees) / 2;

                // First remove fixed cars
                for(int i = 0; i<fixedEmployeesPerStation * categoryOfStations; i++) {

                    if(!petrolVehicles.isEmpty()) {
                        petrolVehicles.remove();
                    }

                    if(!dieselVehicles.isEmpty()) {
                        dieselVehicles.remove();
                    }

                }

                // Where is the flexible employee supposed to go?
                if(flexibleEmployees > 0) {
                    if(petrolVehicles.size() > dieselVehicles.size()) {

                        System.out.println("Extra employee filling Petrol now.");
                        for(int i = 0; i < flexibleEmployees; i++) {

                            if(!petrolVehicles.isEmpty()) {
                                petrolVehicles.remove();
                            }
                        }
                    }
                    else {
                        System.out.println("Extra employee filling Diesel now.");
                        for(int i = 0; i < flexibleEmployees; i++) {

                            if(!dieselVehicles.isEmpty()) {
                                dieselVehicles.remove();
                            }
                        }
                    }
                }


                TimeUnit.SECONDS.sleep(2);
            }

            // All the diesel cars were done, only petrol cars left, so both / all employees can come here.
            if(!petrolVehicles.isEmpty()) {
                System.out.println("All employees dedicated to Petrol Station");
            }
            while(!petrolVehicles.isEmpty()) {

                System.out.println("Remaining Petrol Cars: " + petrolVehicles.size());
                System.out.println("Filling ONLY Petrol");

                int numberOfCarsToBeEvicted = Math.min(employees, petrolStations);
                for(int i = 0; i < numberOfCarsToBeEvicted; i+=1) {
                    if(!petrolVehicles.isEmpty()) {
                        petrolVehicles.remove();
                    }
                }

                TimeUnit.SECONDS.sleep(2);
            }

            // All the petrol cars were done, only diesel cars left, so both employees can come here.
            if(!dieselVehicles.isEmpty()) {
                System.out.println("All employees dedicated to Diesel Station");
            }
            while(!dieselVehicles.isEmpty()) {


                System.out.println("Remaining Diesel Cars: " + dieselVehicles.size());
                System.out.println("Filling ONLY Diesel");

                int numberOfCarsToBeEvicted = Math.min(employees, dieselStations);
                for(int i = 0; i<numberOfCarsToBeEvicted; i+=1) {
                    if(!dieselVehicles.isEmpty()) {
                        dieselVehicles.remove();
                    }
                }

                TimeUnit.SECONDS.sleep(2);
            }

            System.out.println("\n*** Break Time ***\n");
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
