import org.junit.jupiter.api.Test;

public class Demo3<T> {
    public static void test1_(Demo<Number> demo){
        System.out.println(demo);
    }

    @Test
    public void test1(){
        Demo<Integer> demo = new Demo<Integer>();
//        test1_(demo);虽然Integer是Number的子类，但是泛型不能这样用
    }

    public static void test2_(Demo<?> demo){
        System.out.println(demo);
    }

    @Test
    public void test2(){
        Demo<Integer> demo = new Demo<Integer>();
        test2_(demo);//使用?可以解决test1的问题，?视为所有类型的父类
    }
}
