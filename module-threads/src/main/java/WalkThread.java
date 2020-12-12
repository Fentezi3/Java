import java.util.concurrent.TimeUnit;

public class WalkThread extends java.lang.Thread {
    public void run (){
        for (int i = 0; i < 7; i++){
            System.out.println("Walk " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
