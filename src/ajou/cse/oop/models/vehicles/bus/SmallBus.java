package ajou.cse.oop.models.vehicles.bus;

import ajou.cse.oop.models.Costs;

public class SmallBus extends Bus {
    public SmallBus(int carNum) {
        super(carNum);
    }

    @Override
    public int getMinimumCost() {
        return Costs.smallBusMinCost;
    }

    @Override
    public int getAddingCost() {
        return Costs.smallBusAddCost;
    }
}
