import bean.Car;
import bean.ParkingPlace;
import scanner.ScannerWrapper;

import java.util.HashSet;
import java.util.Set;

public class ParkingMain {

    public static void main(String[] args) {
        ScannerWrapper scanner = new ScannerWrapper();

        String outputText;
        scanner.openScanner();
        outputText = "You can: 1.Send car to parking\n" +
                "2.Get information about cars in parking\n" +
                "3.Finish work";
        System.out.println(outputText);
        int option = scanner.readInput();
        if (option == 1){
            sendCar();
        }else if(option == 2){
            int carIdInfo = getParkingInfo();
        }else if(option == 3){
            System.out.println("Good bye, my friends");
            scanner.closeScanner();
        }else{
            System.out.println("Please, enter number from 1 to 3.");
        }

    }

    private static int getParkingInfo() {

        return 0;
    }

    private static void sendCar() {

    }

    private Set<ParkingPlace> createParkingPlaceSet() {
        Car car1 = new Car(5);
        ParkingPlace place1 = new ParkingPlace(false);
        ParkingPlace place2 = new ParkingPlace(false);
        ParkingPlace place3 = new ParkingPlace(false);
        ParkingPlace place4 = new ParkingPlace(true);
        ParkingPlace place5 = new ParkingPlace(true);
        ParkingPlace place6 = new ParkingPlace(true);
        ParkingPlace place7 = new ParkingPlace(true);
        ParkingPlace place8 = new ParkingPlace(true);
        Set<ParkingPlace> parkingSet = new HashSet<ParkingPlace>(8);
        parkingSet.add(place1);
        parkingSet.add(place2);
        parkingSet.add(place3);
        parkingSet.add(place4);
        parkingSet.add(place5);
        parkingSet.add(place6);
        parkingSet.add(place7);
        parkingSet.add(place8);
        return parkingSet;
    }
}
