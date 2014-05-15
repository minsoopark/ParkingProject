package ajou.cse.oop.models.vehicles.truck;

import ajou.cse.oop.models.Costs;

public class BigTruck extends Truck {
    public BigTruck(int carNum) {
        super(carNum);
    }

    @Override
    public int getMinimumCost() {
        return Costs.bigTruckCost;
    }

    @Override
    public int getAddingCost() {
        return Costs.bigTruckCost;
    }
}
