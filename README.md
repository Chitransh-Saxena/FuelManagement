Fuel Management System

* Use Cases
    * Allow taking input of incoming cars and let them fill fuel (Diesel and Petrol)
    * Initially 2 employees are there (base case, but scalable), so divide them optimally
    * Petrol and Diesel Stations could be added or removed.
    * Important vehicles like ambulance take priority
    
* Actors
    * Admin
        * To start the gas station
        * Add or remove employees
        * Add or remove petrol / diesel stations (they can be sometimes down for maintenance)
    * Employee
        * Fill the fuel and then evict the car
    * Vehicle
        * This is like a consumer
        * Come, get the fuel filled and move out.