package com.intuit.model;

public class Employee {

    private Integer uniqueId;
    private String employeeName;

    public Employee(Integer uniqueId, String employeeName) {
        this.uniqueId = uniqueId;
        this.employeeName = employeeName;
    }

    public Integer getUniqueId() {
        return uniqueId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public String toString() {
        return employeeName;
    }
}
