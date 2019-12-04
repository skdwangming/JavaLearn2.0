import java.io.IOException;

public class StopThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        StopThread stopThread = new StopThread();
        stopThread.start();
        System.in.read();
        stopThread.interrupt();
        System.out.println(121);



    }
}
