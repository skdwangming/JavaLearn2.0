/**
 * 接口、抽象类、普通类的关系：
 *      接口声明规范后，某一部分特性抽象为一个抽象类去实现接口，然后又分为多个不同功能普通类去继承该抽象类，以便实例化。
 *      1、为什么不直接通过普通类去实现该接口？
 *          因为普通类实现接口后，需要实现所有方法（接口中的方法默认为抽象方法），不够灵活
 */
public interface InterfaceA {
    String getName();
}