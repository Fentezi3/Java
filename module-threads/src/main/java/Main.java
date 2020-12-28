import bean.Car;
import scanner.ScannerWrapper;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int SEND_CAR_TO_PARKING = 1;
    private static final int GET_CARS_ID = 2;
    private static final int FINISH_WORK = 3;
    private static BlockingQueue<Car> parking;

    public static void main(String[] args) {
        parking = createParking();
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
                        System.out.println("How long is car standing in parking?");
                        int standingTime = scanner.readInput();
                        parkTheCar(inputTime, parking, standingTime);
                        break;
                    case GET_CARS_ID:
                        getInfoAboutCarsInParking();
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

    private static void parkTheCar(int time, final BlockingQueue<Car> parking, int standingTime) {
        Car newCar = new Car(time);
        new Thread(() -> {
            try {
                parking.offer(newCar, time, TimeUnit.SECONDS);
                TimeUnit.SECONDS.sleep(standingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            parking.remove(newCar);
        }).start();
    }

    private static void getInfoAboutCarsInParking() {
        for (Car car : parking) {
            System.out.println(car.toString());
        }
    }

    private static BlockingQueue<Car> createParking() {
        BlockingQueue<Car> parkingQueue = new LinkedBlockingQueue<>(4);
        parkTheCar(5, parkingQueue, 5);
        parkTheCar(10, parkingQueue, 10);
        return parkingQueue;
    }
}
