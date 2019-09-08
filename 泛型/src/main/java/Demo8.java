import java.util.ArrayList;

class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}

public class Demo8 {
    public static void main(String[] args) {

        // 上界
        ArrayList<? extends Fruit> fruitTop = new ArrayList<>();
//        fruitTop.add(new Fruit()); //报错
        Fruit fruit = fruitTop.get(0);

        //下界
        ArrayList<? super Apple> appleBottem = new ArrayList<>();
        appleBottem.add(new Apple());
        appleBottem.add(new Jonathan());
//        Apple object = appleBottem.get(0); // 报错
        Object object = appleBottem.get(0); // 不报错
    }
}
