public class MyThread2 implements Runnable {
    int num = 10;

    @Override
    public void run() {
        while (num > 0) {
            synchronized (this) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "" + num);
                num--;
            }
        }
    }

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread thread1 = new Thread(myThread2, "线程一");
        Thread thread2 = new Thread(myThread2, "线程二");
        Thread thread3 = new Thread(myThread2, "线程三");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
