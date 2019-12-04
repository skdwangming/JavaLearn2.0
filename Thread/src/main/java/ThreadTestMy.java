/**
 * 线程的几种状态，在Thread类中的枚举state，有new、runnable、timed_waiting、waiting、terminated五种
 * <p>
 * new:刚被new出来
 * runnable:调用start之后，此时只是有资格被cpu挑选进入运行。
 * timed_waiting：在sleep时，并且声明了sleep的时间
 * waiting：一般在两个线程时可以复现，主线程启动了子线程，然后调用join方法，使得子线程完成后祝线程才可以继续下去。
 * 这时子线程未结束，父线程则处于waiting
 * terminated：子线程join方法结束，再输出子线程状态即为terminated
 */
public class ThreadTestMy {
    static Thread thread1;

    public static void main(String[] args) {
        thread1 = new Thread(new Thread1());
        System.out.println("1:" + thread1.getState());
        thread1.start();
        System.out.println("2:" + thread1.getState());

    }

    static class Thread1 implements Runnable {

        @Override
        public void run() {
            Thread thread2 = new Thread(new Thread2());
            thread2.start();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("3:" + thread2.getState());

            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("5:" + thread2.getState());


        }
    }

    static class Thread2 implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("4:" + thread1.getState());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}