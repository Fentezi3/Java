package bean;

import java.util.Random;

public class ParkingPlace {
    int placeID;
    boolean free;
    Car car;

    public ParkingPlace(boolean free) {
        Random random = new Random();
        this.placeID = random.nextInt(42);
        this.free = free;
    }

    public ParkingPlace(boolean free, Car car) {
        Random random = new Random();
        this.placeID = random.nextInt(42);
        this.free = free;
        this.car = car;
    }

    public int getPlaceID() {
        return placeID;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "ParkingPlace{" +
                "placeID=" + placeID +
                ", free=" + free +
                ", car=" + car +
                '}';
    }
}
