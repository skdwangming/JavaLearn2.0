import java.util.concurrent.CountDownLatch;

public class MyCountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(3);

        WorkThread wt1 = new WorkThread(1000, cdl, "一");
        WorkThread wt2 = new WorkThread(2000, cdl, "二");
        WorkThread wt3 = new WorkThread(3000, cdl, "三");

        wt1.start();
        wt2.start();
        wt3.start();

        cdl.wait();
        System.out.println("结束");
    }


    static class WorkThread extends Thread {
        private long delay;
        private CountDownLatch cdl;

        WorkThread(long delay, CountDownLatch cdl, String name) {
            super(name);
            this.delay = delay;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(delay);
                cdl.countDown();
                System.out.println("线程:" + Thread.currentThread().getName() + "完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
