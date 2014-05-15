package ajou.cse.oop.utils;

import ajou.cse.oop.models.Costs;

public class ParkingSystem {
    public static void updateCarCost(int min, int add) {
        Costs.carMinCost = min;
        Costs.carAddCost = add;
    }

    public static void updateBusCost(int ... costs) {
        Costs.bigBusMinCost = costs[0];
        Costs.bigBusAddCost = costs[1];
        Costs.mediumBusMinCost = costs[2];
        Costs.mediumBusAddCost = costs[3];
        Costs.smallBusMinCost = costs[4];
        Costs.smallBusAddCost = costs[5];
    }

    public static void updateTruckCost(int ... costs) {
        Costs.bigTruckCost = costs[0];
        Costs.mediumTruckCost = costs[1];
        Costs.smallTruckCost = costs[2];
    }
}
