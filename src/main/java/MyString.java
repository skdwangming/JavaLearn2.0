import org.junit.jupiter.api.Test;

public class MyString {

    @Test
    public void test(){
        String s = "hello world";
        String substring = s.substring(0, 2);
        System.out.println(substring);
    }

    @Test
    public void test1(){
        String s = "hello h 3w3o344rld";
        s = s.replaceAll("\\d","");
        System.out.println(s);
    }

    @Test
    public void test2(){
        String s = "hello world";
        StringBuffer reverse = new StringBuffer(s).reverse();
        System.out.println(reverse);
    }

    @Test
    public void test3(){
        String s = "hello world";
        int wo = s.indexOf("wo");
        System.out.println(wo);
    }

    @Test
    public void test4(){
        String s = "eee";
        String s2 = new String("eee");
        System.out.println();

    }

    @Test
    public void test5(){

    }

    @Test
    public void test6(){

    }

    @Test
    public void test7(){

    }

    @Test
    public void test8(){

    }
}

