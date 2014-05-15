package ajou.cse.oop.models.vehicles;

import java.util.Calendar;
import java.util.Date;

public abstract class Vehicle {

    public static final int TYPE_CAR = 0;
    public static final int TYPE_BUS = 1;
    public static final int TYPE_TRUCK = 2;

    protected final int minimumMin;
    protected final int addingMin;

    protected final int carNum;

    protected int type;

    protected Date inDate;
    protected Date outDate;

    public Vehicle(int carNum, int minimumMin, int addingMin) {
        this.carNum = carNum;
        this.minimumMin = minimumMin;
        this.addingMin = addingMin;
    }

    public int getMinimumMin() {
        return minimumMin;
    }

    public int getAddingMin() {
        return addingMin;
    }

    public abstract int getMinimumCost();
    public abstract int getAddingCost();

    public int getCarNum() {
        return carNum;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        String type = this.type == TYPE_CAR ? "승용차" : this.type == TYPE_BUS ? "버스" : "트럭";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getInDate());
        return String.format(
                "%s %04d %d/%02d/%02d %02d:%02d",
                type,
                getCarNum(),
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE)
        );
    }
}
