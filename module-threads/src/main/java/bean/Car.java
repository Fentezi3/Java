package bean;

import java.util.Random;

public class Car extends Thread{
    int carID;
    int waitingTime;

    public Car(int waitingTime) {
        Random random = new Random();
        this.carID = random.nextInt(10);
        this.waitingTime = waitingTime;
    }

    public int getCarID() {
        return carID;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", waitingTime=" + waitingTime +
                '}';
    }
}
