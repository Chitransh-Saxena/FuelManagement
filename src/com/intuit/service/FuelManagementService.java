package com.intuit.service;

import com.intuit.model.Employee;
import com.intuit.model.Vehicle;
import com.intuit.model.VehicleQueue;

import java.util.List;
import java.util.Queue;

public interface FuelManagementService {

    public void startStation(List<Employee> employees);

    public VehicleQueue initializeVehicles(Queue<Vehicle> vehicles);

    public void manageStation(VehicleQueue vehicleQueue, Integer petrolStations, Integer dieselStatons, Integer employees, Integer categoryOfStations);

    public void managePriorityVehicles(Queue<Vehicle> priorityVehicle, Integer employees, Integer petrolStation);
}
