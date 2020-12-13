package bean;

public class Car extends Thread {
    private final long carID;
    int waitingTime;

    public Car(int waitingTime) {
        this.carID = System.nanoTime();
        this.waitingTime = waitingTime;
    }

    public long getCarID() {
        return carID;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", waitingTime=" + waitingTime +
                '}';
    }
}
