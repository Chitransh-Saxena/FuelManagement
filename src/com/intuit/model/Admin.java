package com.intuit.model;

import java.util.ArrayList;
import java.util.List;

public class Admin {

    /*
        Admin can modify the number of petrol and diesel stations.
        Admin can hire and fire of an employee

        If this were an spring boot project, counts like petrolStations could be saved in properties file
        This would make it easy to modify in future.
    */

    private List<Employee> employees = new ArrayList<>();


    private Integer petrolStations = 2;
    private Integer dieselStations = 2;

    public Integer getCategoriesOfStations() {
        return categoriesOfStations;
    }

    private Integer categoriesOfStations = 2;

    public void hireEmployee(Employee e) {

        employees.add(e);
    }

    public List<Employee> getEmployees() {

        return employees;
    }

    public Integer getPetrolStations() {
        return this.petrolStations;
    }

    public Integer getDieselStations() {
        return this.dieselStations;
    }

}
