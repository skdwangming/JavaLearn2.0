package MyThread;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.Socket;


public class MyThread implements Runnable {
    public int num = 20;
    @Override
    public void run() {
        while (num>0){
            System.out.println(Thread.currentThread().getName()+"==>"+num);
            num -- ;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread,"1").start();
        new Thread(myThread,"2").start();
        new Thread(myThread,"3").start();
    }

    @Test
    public void test1() throws IOException {
            Socket socket = new Socket("localhost",1234);
    }

    @Test
    public void test2() {

    }

    @Test
    public void test3() {

    }

    @Test
    public void test4() {

    }

    @Test
    public void test5() {

    }

    @Test
    public void test6() {

    }

    @Test
    public void test7() {

    }



}

