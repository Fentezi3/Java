package bean;

public class Car extends Thread {
    private final long id;
    private int waitingTime;

    public Car(int waitingTime) {
        this.id = System.nanoTime();
        this.waitingTime = waitingTime;
    }

    public long getId() {
        return id;
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
                "carID=" + id +
                ", waitingTime=" + waitingTime +
                '}';
    }
}
