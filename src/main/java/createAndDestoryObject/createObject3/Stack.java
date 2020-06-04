package createAndDestoryObject.createObject3;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    Stack(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object o) {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, size * 2 + 1);
        }
        elements[size++] = o;
    }

    public Object pop(){
        if (size == elements.length){
            throw new EmptyStackException();
        }
        Object o =  elements[--size];
        elements[size] = null;// 不加这行，会内存泄露
        return o;
    }
}