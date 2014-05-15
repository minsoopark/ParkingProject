package ajou.cse.oop.models.vehicles.truck;

import ajou.cse.oop.models.vehicles.Vehicle;

public abstract class Truck extends Vehicle {
    protected Truck(int carNum) {
        super(carNum, 1440, 1440);
        this.type = TYPE_TRUCK;
    }
}
