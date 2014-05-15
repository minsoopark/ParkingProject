package ajou.cse.oop.models.vehicles.truck;

import ajou.cse.oop.models.Costs;

public class SmallTruck extends Truck {
    public SmallTruck(int carNum) {
        super(carNum);
    }

    @Override
    public int getMinimumCost() {
        return Costs.smallTruckCost;
    }

    @Override
    public int getAddingCost() {
        return Costs.smallTruckCost;
    }
}
