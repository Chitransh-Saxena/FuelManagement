package com.intuit.model;

import java.util.LinkedList;
import java.util.Queue;

public class VehicleQueue {

    Queue<Vehicle> petrolVehicles;
    Queue<Vehicle> dieselVehicles;
    Queue<Vehicle> priorityVehicles;

    public Queue<Vehicle> getPetrolVehicles() {
        return petrolVehicles;
    }

    public void setPetrolVehicles(Queue<Vehicle> petrolVehicles) {
        this.petrolVehicles = petrolVehicles;
    }

    public Queue<Vehicle> getDieselVehicles() {
        return dieselVehicles;
    }

    public void setDieselVehicles(Queue<Vehicle> dieselVehicles) {
        this.dieselVehicles = dieselVehicles;
    }

    public Queue<Vehicle> getPriorityVehicles() {
        return priorityVehicles;
    }

    public void setPriorityVehicles(Queue<Vehicle> priorityVehicles) {
        this.priorityVehicles = priorityVehicles;
    }

}
