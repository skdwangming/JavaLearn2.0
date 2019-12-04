package My;

import sun.jvm.hotspot.utilities.RBNode;

import javax.management.relation.RoleUnresolved;

/**
 * 生产者消费者模型
 * cubbyhole中可以存一个数字，生产者将数字存入，消费者将数字取出。使用synchronized按序存取，使用wait让该线程进入等待池
 * 将锁放开；使用notify将所有在wait中的线程从等待池进入锁池，参与锁的竞争。
 */
public class ProducerConsumerTestMy {
    public static void main(String[] args) {
        CubbyHole cubbyHole = new CubbyHole();
        Producer producer = new Producer(cubbyHole);
        Thread thread1 = new Thread(producer);
        thread1.start();
        Consumer consumer = new Consumer(cubbyHole);
        Thread thread2 = new Thread(consumer);
        thread2.start();
    }
}

class CubbyHole {
    private int contents;
    private boolean available = false; //  是否有数据可供获取

    public synchronized int get() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return contents;
    }

    public synchronized void put(int contents) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.contents = contents;
        available = true;
        notifyAll();
    }
}

class Producer  implements Runnable {
    private CubbyHole cubbyHole;

    Producer(CubbyHole cubbyHole) {
        this.cubbyHole = cubbyHole;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            cubbyHole.put(i);
            System.out.println("生产者生产了：" + i);
            try {
                Thread.sleep((int) Math.random() * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private CubbyHole cubbyHole;

    Consumer(CubbyHole cubbyHole) {
        this.cubbyHole = cubbyHole;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            cubbyHole.get();
            System.out.println("消费者消费了：" + i);
        }
    }
}

