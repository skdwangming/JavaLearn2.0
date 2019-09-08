

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 泛型：泛指的类型
 * 例子：public class ArrayList<E> extends AbstractList<E>
 * 特点：
 *      1、不支持基本数据类型
 * 通配符
 *      上界通配符：<? extends T>
 *      下界通配符：<? super T>
 * 类型
 *      T 代表一般的任何类。
 *      E 代表 Element 的意思，或者 Exception 异常的意思。
 *      K 代表 Key 的意思。
 *      V 代表 Value 的意思，通常与 K 一起配合使用。
 *      S 代表 Subtype 的意思，文章后面部分会讲解示意。
 * @param <T>
 */
public class Demo<T> {
    T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public static void main(String[] args) {
        Demo<String> stringDemo = new Demo<>();
        stringDemo.setT("字符串");
        String t = stringDemo.getT();
        System.out.println(t);
    }

    /**
     * 如果不使用泛型，往集合里添加Stirng和Integer时，不会报错
     * 使用泛型后，只能添加制定类型的数据，否则报错。
     *      因为在编译时，会检测到类型错误。idea会预编译。
     */
    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
//        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("123");
        arrayList.add(123);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println((String)arrayList.get(i));
        }
    }

    @Test
    public void test2(){
        ArrayList<String> s = new ArrayList<String>();
        ArrayList<Integer> i = new ArrayList<Integer>();
        Class aClass = s.getClass();
        Class iClass = i.getClass();
        System.out.println(aClass);
        System.out.println(iClass);



    }

}
