
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        // Let us create task that is going to
        // wait for four threads before it starts
        CountDownLatch latch = new CountDownLatch(3);

        long start = System.currentTimeMillis();

        // Let us create four worker
        // threads and start them.
        WorkerThread first = new WorkerThread(1000, latch, "worker-1");
        WorkerThread second = new WorkerThread(2000, latch, "worker-2");
        WorkerThread third = new WorkerThread(3000, latch, "worker-3");

        first.start();
        second.start();
        third.start();

        // The main task waits for four threads
        latch.await();

        // Main thread has started
        System.out.println(Thread.currentThread().getName() + " has finished. Spend Time = " + (System.currentTimeMillis() - start));
    }

    // A class to represent threads for which
    // the main thread waits.
    static class WorkerThread extends Thread {

        private int delay;
        private CountDownLatch latch;

        public WorkerThread(int delay, CountDownLatch latch, String name) {
            super(name);
            this.delay = delay;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(delay);
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + " finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
