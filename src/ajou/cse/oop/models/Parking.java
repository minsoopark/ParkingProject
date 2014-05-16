package ajou.cse.oop.models;

import ajou.cse.oop.models.vehicles.Vehicle;
import ajou.cse.oop.utils.MathUtil;

public class Parking<T extends Vehicle> {

    private T vehicle;
    private long cost;
    private long duration;

    public Parking(T vehicle) {
        this.vehicle = vehicle;
        this.cost = calcCost();
    }

    private long calcCost() {
        long inTimestamp = vehicle.getInDate().getTime();
        long outTimestamp = vehicle.getOutDate().getTime();

        long gap = outTimestamp - inTimestamp;
        long gapMin = gap / 1000 / 60;

        this.duration = gapMin;

        gapMin = MathUtil.ceil(gapMin, 10);

        long gapMinWithoutMinimum = gapMin - vehicle.getMinimumMin();

        long cost = vehicle.getMinimumCost() + vehicle.getAddingCost() * (gapMinWithoutMinimum / vehicle.getAddingMin());

        return cost;
    }

    public T getVehicle() {
        return vehicle;
    }

    public long getCost() {
        return cost;
    }

    public long getDuration() {
        return duration;
    }
}
