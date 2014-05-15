package ajou.cse.oop.models.vehicles.truck;

import ajou.cse.oop.models.Costs;

public class MediumTruck extends Truck {
    public MediumTruck(int carNum) {
        super(carNum);
    }

    @Override
    public int getMinimumCost() {
        return Costs.mediumTruckCost;
    }

    @Override
    public int getAddingCost() {
        return Costs.mediumTruckCost;
    }
}
