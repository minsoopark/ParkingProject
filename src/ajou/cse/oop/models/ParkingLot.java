package ajou.cse.oop.models;

import ajou.cse.oop.models.vehicles.Vehicle;
import ajou.cse.oop.struct.FixedArrayList;

import java.util.*;

public class ParkingLot {
    private List<Vehicle> vehicles;
    private Map<Integer, ArrayList<Parking>> parkings;

    public ParkingLot(int size) {
        vehicles = new FixedArrayList<Vehicle>(size);
        parkings = new HashMap<Integer, ArrayList<Parking>>();
    }

    public void enter(Vehicle vehicle, Date inDate) {
        vehicle.setInDate(inDate);
        vehicles.add(vehicle);
    }

    public Parking out(int carNum, Date outDate) {
        int index = findVehicleIndex(carNum);
        Parking parking;

        if (index == -1) {
            throw new NullPointerException();
        } else {
            Vehicle vehicle = vehicles.get(index);

            if (vehicle.getInDate().getTime() > outDate.getTime()) {
                throw new IllegalArgumentException();
            }

            vehicle.setOutDate(outDate);

            parking = new Parking(vehicle);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(outDate);

            Integer time = calendar.get(Calendar.YEAR) * 365
                    + calendar.get(Calendar.MONTH) * 30
                    + calendar.get(Calendar.DAY_OF_MONTH);

            if (parkings.get(time) == null) {
                parkings.put(time, new ArrayList<Parking>());
            }
            parkings.get(time).add(parking);

            vehicles.remove(index);
        }

        return parking;
    }

    public void showAll() {
        sort();

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    private int findVehicleIndex(int carNum) {
        int index = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getCarNum() == carNum) {
                return index;
            }
            index++;
        }

        return -1;
    }

    public long getTotalCost(Date date) {
        long cost = 0;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        Integer time = calendar.get(Calendar.YEAR) * 365
                + calendar.get(Calendar.MONTH) * 30
                + calendar.get(Calendar.DAY_OF_MONTH);

        for (Parking parking : parkings.get(time)) {
            cost += parking.getCost();
        }

        return cost;
    }

    public void sort() {
        Collections.sort(vehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle vehicle, Vehicle vehicle2) {
                return vehicle.getInDate().compareTo(vehicle2.getInDate());
            }
        });

        Collections.sort(vehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle vehicle, Vehicle vehicle2) {
                return vehicle.getType() - vehicle2.getType();
            }
        });
    }
}
