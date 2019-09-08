import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Demo6 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> list = new ArrayList<>();
        list.add("wm");
        //通过反射可以绕过编译器的校验，传入不同数据类型的数据
        Method add = list.getClass().getDeclaredMethod("add", Object.class);
        add.invoke(list, 123);

        for (Object o :
                list) {
            System.out.println(o.getClass().getName());
            System.out.println(o);
        }

    }
}
