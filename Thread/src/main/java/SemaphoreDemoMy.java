import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemoMy {
    public static void main(String[] args) throws InterruptedException {
        int totalPeople = 20;
        int servicePeople = 3;

        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(servicePeople);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0 ; i<totalPeople;i++){
            final int finalI = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    resolve(finalI);
                    semaphore.release();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
        countDownLatch.await();
        System.out.println("结束");
    }

    public static void resolve(int i) throws InterruptedException {
        int time = (int)(Math.random()*5000);
        Thread.sleep(time);
        System.out.println("第"+i+"个人正在办理业务,使用时间"+time/1000);
    }




}
