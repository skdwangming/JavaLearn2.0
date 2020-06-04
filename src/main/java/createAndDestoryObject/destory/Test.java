package createAndDestoryObject.destory;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        String s = null;
        try {
            s = Destory.FirstLin("111");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
