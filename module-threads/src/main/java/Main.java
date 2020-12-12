import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        WalkThread walk = new WalkThread();
        walk.start();
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(new CallThread());
        try {
            String result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
