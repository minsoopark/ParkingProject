package ajou.cse.oop.models.vehicles.bus;

import ajou.cse.oop.models.vehicles.Vehicle;

public abstract class Bus extends Vehicle {
    protected Bus(int carNum) {
        super(carNum, 60, 30);
        this.type = TYPE_BUS;
    }
}
