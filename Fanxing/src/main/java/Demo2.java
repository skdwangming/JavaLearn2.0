import java.util.Date;

public class Demo2 extends Date {
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        demo2.print();
    }
    /**
     * 使用this与super的.getClass()方法时，调用的都是Object的方法，返回的都是当前运行时的类，也就是Demo2。
     * 想要获取父类的名字，需要使用getSuperClass()方法
     */
    public void print(){
        System.out.println("当前运行类的名字为："+this.getClass().getName());
        System.out.println("当前运行类的名字为："+super.getClass().getName());
        System.out.println("当前运行类的父类的名字为："+this.getClass().getSuperclass().getName());
    }
}
