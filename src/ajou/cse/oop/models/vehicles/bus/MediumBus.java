package ajou.cse.oop.models.vehicles.bus;

import ajou.cse.oop.models.Costs;

public class MediumBus extends Bus {
    public MediumBus(int carNum) {
        super(carNum);
    }

    @Override
    public int getMinimumCost() {
        return Costs.mediumBusMinCost;
    }

    @Override
    public int getAddingCost() {
        return Costs.mediumBusAddCost;
    }
}
