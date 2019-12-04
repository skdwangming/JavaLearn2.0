import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

public class MyDate {


    @Test
    public void test1() {
        class MyStack {
            private int size;
            private int[] stack;
            private int index;

            MyStack(int size) {
                this.size = size;
                stack = new int[size];
                index = -1;
            }

            public void put(int i) {
                stack[++index] = i;
            }

            public int pop() {

                return stack[index--];
            }

            public boolean isEmpty() {
                return index == -1;
            }

        }
        MyStack myStack = new MyStack(10);
        myStack.put(1);
        myStack.put(2);
        myStack.put(3);
        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
            System.out.println();
        }
    }

    @Test
    public void test2() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        queue.poll();
        for (Integer i : queue) {
            System.out.println(i);

        }
        queue.element();

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

