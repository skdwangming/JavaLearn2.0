import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class MyArray_Time_Enum_Label {

    @Test
    public void test() {
        int[] arr = {1, 2, -3, -2, 6, 0, -9};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int i = Arrays.binarySearch(arr, 3);
        System.out.println(i);

        int index = -i - 1;

        int[] destArr = new int[arr.length + 1];

        System.arraycopy(arr, 0, destArr, 0, index);
        destArr[index] = 3;
        System.arraycopy(arr, index, destArr, index + 1, arr.length - index);

        for (int j = 0; j < destArr.length; j++) {
            System.out.println(destArr[j]);
        }

    }

    @Test
    public void test1() {
        int[] ints = {1, 2, 3, 4};
        int[] ints2 = {1, 2, 3, 4};
        boolean equals = Arrays.equals(ints, ints2);
        System.out.println(equals);

    }

    @Test
    public void test2() {
        ArrayList<String> strings = new ArrayList<>();
        strings.remove(1);
        String s = "211";
        s.equals("333");

    }

    /**
     * 创建时间三种方式
     */
    @Test
    public void test3() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat.format(new Date());//第一种
//        String format = simpleDateFormat.format(new Date(System.currentTimeMillis()));//第二种
        String format = simpleDateFormat.format(Calendar.getInstance().getTime());//第二种

        System.out.println(format);

    }

    /**
     * lable标签使用
     * 规则：lable后必须紧跟循环
     * 只有双层循环时才是最合适使用的，并且感觉只有在内层循环中使用break是唯一作用。
     */
    @Test
    public void test4() {
        lable:
        for (int i = 0; i < 10; i++) {
            System.out.printf("i:%d\n", i);
            for (int j = 0; j < 10; j++) {
                System.out.printf("j:%d\n", j);
                if (j == 2) {
                    break lable;
                }
            }
        }

    }

    public enum Car {
        Tesla(100), toyota(200), volvo(300);
        private int price;

        Car(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    /**
     * 枚举
     */
    @Test
    public void test5() {
        Car car = Car.Tesla;
        System.out.println(car);

        for (Car c : Car.values()) {
            System.out.println(c);
        }
    }

    /**
     * 可变参数
     */
    @Test
    public void test6() {
        test7(1,2,3);

    }

    @Test
    public void test7(int... ints) {
        for (int i :ints) {
            System.out.println(i);
        }
    }

}

