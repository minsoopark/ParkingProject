package ajou.cse.oop.main;

import ajou.cse.oop.models.Parking;
import ajou.cse.oop.models.ParkingLot;
import ajou.cse.oop.models.vehicles.Car;
import ajou.cse.oop.models.vehicles.Vehicle;
import ajou.cse.oop.models.vehicles.bus.BigBus;
import ajou.cse.oop.models.vehicles.bus.MediumBus;
import ajou.cse.oop.models.vehicles.bus.SmallBus;
import ajou.cse.oop.models.vehicles.truck.BigTruck;
import ajou.cse.oop.models.vehicles.truck.MediumTruck;
import ajou.cse.oop.models.vehicles.truck.SmallTruck;
import ajou.cse.oop.utils.ParkingSystem;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        ParkingLot parkingLot = new ParkingLot(10);

        int menu;

        do {
            System.out.println();
            System.out.println("원하는 기능을 선택하세요!");
            System.out.println("1. 입차");
            System.out.println("2. 출차");
            System.out.println("3. 전체 주차 차량");
            System.out.println("4. 주차 요금 변경");
            System.out.println("5. 일일 매출 총액");
            System.out.println("6. 종료");
            System.out.print("> ");

            Scanner scanner = new Scanner(System.in);

            menu = scanner.nextInt();

            switch (menu) {
                case 1:
                {
                    System.out.println();
                    System.out.println("차량 종류 및 용량을 입력하세요! 승용차(c), 트럭(t), 버스(b)");
                    System.out.print("> ");

                    String t = scanner.next();
                    int capacity = scanner.nextInt();

                    int type = t.equals("c") ? Vehicle.TYPE_CAR : t.equals("t") ? Vehicle.TYPE_TRUCK : Vehicle.TYPE_BUS;

                    System.out.println();
                    System.out.println("차량 번호를 입력하세요! (4자리 숫자)");
                    System.out.print("> ");

                    int carNum = scanner.nextInt();

                    System.out.println();
                    System.out.println("입차시간을 입력하세요!");
                    System.out.print("> ");

                    Date date = inputDate();

                    Vehicle vehicle = null;

                    switch (type) {
                        case Vehicle.TYPE_CAR:
                            vehicle = new Car(carNum);
                            break;
                        case Vehicle.TYPE_BUS:
                            if (capacity >= 40) {
                                vehicle = new BigBus(carNum);
                            } else if (capacity < 40 && capacity >= 24) {
                                vehicle = new MediumBus(carNum);
                            } else {
                                vehicle = new SmallBus(carNum);
                            }
                            break;
                        case Vehicle.TYPE_TRUCK:
                            if (capacity >= 10) {
                                vehicle = new BigTruck(carNum);
                            } else if (capacity < 10 && capacity >= 5) {
                                vehicle = new MediumTruck(carNum);
                            } else {
                                vehicle = new SmallTruck(carNum);
                            }
                            break;
                        default:
                            System.out.println();
                            System.out.println("차량 종류 입력이 잘못되었습니다!");
                            continue;
                    }

                    parkingLot.enter(vehicle, date);

                    break;
                }
                case 2:
                {
                    System.out.println();
                    System.out.println("출차할 차량번호를 입력하세요!");
                    System.out.print("> ");

                    int carNum = scanner.nextInt();

                    System.out.println();
                    System.out.println("출차시간을 입력하세요!");
                    System.out.print("> ");

                    Date date = inputDate();

                    Parking parking;
                    try {
                        parking = parkingLot.out(carNum, date);
                    } catch (NullPointerException e) {
                        System.out.println();
                        System.out.println("입력한 차랑 번호에 대한 입차 정보가 없습니다!");
                        continue;
                    } catch (IllegalArgumentException e1) {
                        System.out.println();
                        System.out.println("출차시간이 입차시간보다 앞설 수 없습니다!");
                        continue;
                    }

                    long day = parking.getDuration() / 60 / 24;
                    long hour = (parking.getDuration() - (day * 60 * 24)) / 60;
                    long minute = parking.getDuration() - hour * 60;

                    String format = "주차시간은 "
                            + (day > 0 ? (day + "일 ") : "")
                            + (hour > 0 ? (hour + "시간 ") : "")
                            + minute + "분입니다.";

                    System.out.println();
                    System.out.println(format);
                    System.out.println(String.format("주차요금은 %d 원입니다.", parking.getCost()));

                    break;
                }
                case 3:
                {
                    System.out.println();
                    parkingLot.showAll();
                    break;
                }
                case 4:
                {
                    System.out.println();
                    System.out.println("변경할 차량종류를 입력하세요!");
                    System.out.println("1. 승용차  2. 버스  3. 트럭");
                    System.out.print("> ");

                    int type = scanner.nextInt() - 1;

                    System.out.println();
                    System.out.println("변경할 요금을 입력하세요!");
                    System.out.print("> ");

                    if (type == Vehicle.TYPE_CAR) {
                        ParkingSystem.updateCarCost(
                                scanner.nextInt(),
                                scanner.nextInt()
                        );
                    } else if (type == Vehicle.TYPE_BUS) {
                        ParkingSystem.updateBusCost(
                                scanner.nextInt(),
                                scanner.nextInt(),
                                scanner.nextInt(),
                                scanner.nextInt(),
                                scanner.nextInt(),
                                scanner.nextInt()
                        );
                    } else if (type == Vehicle.TYPE_TRUCK) {
                        ParkingSystem.updateTruckCost(
                                scanner.nextInt(),
                                scanner.nextInt(),
                                scanner.nextInt()
                        );
                    } else {
                        System.out.println();
                        System.out.println("차량 종류 입력이 잘못되었습니다!");
                        continue;
                    }
                    break;
                }
                case 5:
                {
                    System.out.println();
                    System.out.println("매출액을 계산할 날짜를 입력하세요!");
                    System.out.print("> ");

                    Date date = inputDateSimple();

                    long cost;
                    try {
                        cost = parkingLot.getTotalCost(date);
                    } catch (NullPointerException e) {
                        System.out.println();
                        System.out.println("해당 날짜에 매출 정보가 없습니다!");
                        continue;
                    }

                    System.out.println();
                    System.out.println(String.format("매출총액 : %d원", cost));
                    break;
                }
                case 6:
                    break;
            }

        } while (menu != 6);
    }

    public static Date inputDate() {
        Scanner scanner = new Scanner(System.in);

        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day, hour, minute, 0);

        return calendar.getTime();
    }

    public static Date inputDateSimple() {
        Scanner scanner = new Scanner(System.in);

        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);

        return calendar.getTime();
    }
}
