import bean.Car;
import scanner.ScannerWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int SEND_CAR_TO_PARKING = 1;
    private static final int GET_CARS_ID = 2;
    private static final int FINISH_WORK = 3;

    public static void main(String[] args) {
        BlockingQueue<Car> parking = createParkingPlace();
        ScannerWrapper scanner = new ScannerWrapper();
        int check = 0;
        try {
            while (check != FINISH_WORK) {
                String outputText;
                scanner.openScanner();
                outputText = "You can:"
                        + String.format("\n%d.Send car to parking", SEND_CAR_TO_PARKING)
                        + String.format("\n%d.Get information about cars in parking", GET_CARS_ID)
                        + String.format("\n%d.Finish work", FINISH_WORK);
                System.out.println(outputText);
                int option = scanner.readInput();
                switch (option) {
                    case SEND_CAR_TO_PARKING:
                        System.out.println("How long car can wait free place?");
                        int inputTime = scanner.readInput();
                        sendCar(inputTime, parking);
                        break;
                    case GET_CARS_ID:
                        List<Long> carInParking = getCarsIdFromParking(parking);
                        for (long carId : carInParking) {
                            System.out.println(carId);
                        }
                        break;
                    case FINISH_WORK:
                        System.out.println("Good bye, my friends!");
                        check = FINISH_WORK;
                        break;
                    default:
                        System.out.println("Please, enter...");
                        break;
                }
            }
        } finally {
            scanner.closeScanner();
        }

    }

    private static void sendCar(int time, final BlockingQueue<Car> parking) {
        Car newCar = new Car(time);
        new Thread(() -> {
            try {
                parking.offer(newCar, time, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static List<Long> getCarsIdFromParking(BlockingQueue<Car> parking) {
        List<Long> carsIDList = new ArrayList<>();
        for (Car car : parking) {
            carsIDList.add(car.getCarID());
        }
        return carsIDList;
    }

    private static BlockingQueue<Car> createParkingPlace() {
        Car car1 = new Car(5);
        Car car2 = new Car(10);
        Car car3 = new Car(6);
        Car car4 = new Car(3);
        Car car5 = new Car(7);
        BlockingQueue<Car> parkingQueue = new LinkedBlockingQueue<>(8);
        parkingQueue.add(car1);
        parkingQueue.add(car2);
        parkingQueue.add(car3);
        parkingQueue.add(car4);
        parkingQueue.add(car5);
        return parkingQueue;
    }
}
