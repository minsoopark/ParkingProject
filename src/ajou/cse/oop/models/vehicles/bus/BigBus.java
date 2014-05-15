package ajou.cse.oop.models.vehicles.bus;

import ajou.cse.oop.models.Costs;

public class BigBus extends Bus{
    public BigBus(int carNum) {
        super(carNum);
    }

    @Override
    public int getMinimumCost() {
        return Costs.bigBusMinCost;
    }

    @Override
    public int getAddingCost() {
        return Costs.bigBusAddCost;
    }
}
