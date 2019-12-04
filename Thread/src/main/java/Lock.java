import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Lock {
    static String lock1 = "lock1";
    static String lock2 = "lock2";

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        new Thread(a).start();
        new Thread(b).start();
        new Semaphore(1);
        ExecutorService executorService = Executors.newCachedThreadPool();

    }
}

class A implements Runnable {

    @Override
    public void run() {
        synchronized (Lock.lock1) {
            System.out.println("A占用lock1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Lock.lock2) {
                System.out.println("A占用lock2");
            }
        }


    }
}

class B implements Runnable {

    @Override
    public void run() {
        synchronized (Lock.lock2) {
            System.out.println("B占用lock2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Lock.lock1) {
                System.out.println("B占用lock1");
            }
        }
    }
}

