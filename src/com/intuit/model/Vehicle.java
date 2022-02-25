package com.intuit.model;

public class Vehicle {

    private final FuelType fuelType;
    private String vehicleNumber;
    private Integer amount;
    private Boolean priortyVehicle;

    public Vehicle(FuelType fuelType, Boolean priortyVehicle) {
        this.fuelType = fuelType;
        this.priortyVehicle = priortyVehicle;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public Boolean getPriortyVehicle() {
        return priortyVehicle;
    }
}
