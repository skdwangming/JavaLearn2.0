package design.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class Test1 {
    public static void main(String[] args) {
        String name = "name";
        MyHandler myHandler = new MyHandler(name);
        Object o = Proxy.newProxyInstance(null, new Class[]{Comparable.class,CharSequence.class}, myHandler);
        CharSequence c = (CharSequence) o;
        c.length();
        c.charAt(1);
        c.equals("sex");
        c.hashCode();
        c.toString();

        Comparable c2 = (Comparable) o;
        c2.compareTo("sex");
    }

    @Test
    public void test1(){
        BigCar bigCar = new BigCar();
        MyHandler myHandler = new MyHandler(bigCar);
        Car c = (Car)Proxy.newProxyInstance(BigCar.class.getClassLoader(), new Class[]{Car.class}, myHandler);
        c.drive();

    }


}
