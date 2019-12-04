import org.junit.jupiter.api.Test;

public class MyThread extends Thread{

    @Override
    public void run() {
        for(int i = 0;i<10;i++){
            System.out.println(Thread.currentThread()+""+i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1(){
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread.isAlive();
        myThread.start();
        myThread2.start();
    }
}
