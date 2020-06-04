package design.proxy;

public class BigCar implements Car {

    @Override
    public String drive() {
        System.out.println("BigCar");
        return "BigCar";
    }
}
