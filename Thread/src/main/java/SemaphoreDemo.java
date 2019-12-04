import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


public class SemaphoreDemo {

    // 排队总人数（请求总数）
    public static int clientTotal = 10;

    // 可同时受理业务的窗口数量（同时并发执行的线程数）
    public static int threadTotal = 2;


    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(2);
//        final CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    resolve(count);
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                countDownLatch.countDown();
            });
        }
//        countDownLatch.await();
//        executorService.shutdown();
    }

    private static void resolve(int i) throws InterruptedException {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        System.out.println(format+"服务号{"+i+"}，受理业务中。。。");
        Thread.sleep(2000);
    }
}
