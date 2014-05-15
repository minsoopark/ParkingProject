package ajou.cse.oop.models.vehicles;

import ajou.cse.oop.models.Costs;

public class Car extends Vehicle {
    public Car(int carNum) {
        super(carNum, 30, 10);
        this.type = TYPE_CAR;
    }

    @Override
    public int getMinimumCost() {
        return Costs.carMinCost;
    }

    @Override
    public int getAddingCost() {
        return Costs.carAddCost;
    }
}
