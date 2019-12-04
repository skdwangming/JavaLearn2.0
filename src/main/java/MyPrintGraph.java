import org.junit.jupiter.api.Test;

/**
 * 打印图形
 */
public class MyPrintGraph {

    /**
     * 菱形
     */
    @Test
    public void test1() {
        int size = 111;
        System.out.println("start");
        for (int i = 1; i <= size / 2 + 1; i++) {
            for (int j = size / 2; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= size / 2; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = (size - 2 * i); j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println();

        }
        System.out.println("end");
    }

    /**
     * 九九乘法表
     */
    @Test
    public void test2() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d=%d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    /**
     * 平行四边形
     */
    @Test
    public void test3() {
        int size = 5;
        for (int i = 1; i <= size; i++) {
            for (int j = size; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= size; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Test
    public void test4() {

    }

    @Test
    public void test5() {

    }

    @Test
    public void test6() {

    }

    @Test
    public void test7() {

    }
}

