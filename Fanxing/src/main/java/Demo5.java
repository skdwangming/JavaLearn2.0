import java.lang.reflect.Field;

//public class Demo5<T> { // 由于类型擦除，<T>没有指定上限，所以<T>会被转译成Object类型
public class Demo5<T extends String> { //由于指定了上限，所以会替换为String类型
    T t;

    public Demo5(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Demo5<String> wm = new Demo5<>("wm");
        Field[] declaredFields = wm.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println(declaredFields[i].getType().getName());
        }
    }
}
