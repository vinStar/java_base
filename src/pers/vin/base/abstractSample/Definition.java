package pers.vin.base.abstractSample;

/**
 * Created by vin on 03/03/2018.
 */

// 0. 不要出现一个类继承一个已经实现好的类
// 1. 一个类只能继承抽象类和接口
// 2. 不能使用 final 声明 , 因为 final 不能有子类 而 抽象类必须被覆写

//I. 抽象类: 在不同类的基础上添加了一些抽象方法,偏向于概念(只声明,无具体实现)
//II. 无法实例 new ,不知道具体实现? 怎么调用呢?
//III. 非private
//IV . 抽象类的子类必须覆写全部父类的抽象方法, 与普通继承最大的特点:父类可对子类有要求(必须覆写)
// 只允许内部 抽象类 使用 static
abstract class A {
    public void print() {
        System.out.println("this is method print()");
    }

    public A() {

    }

    // {}是方法体,抽象方法没有方法体,即不知道具体实现.

    abstract void fun();

    // 抽象类 内部实现辅助类
    public static A getInstance() {
        class C extends A {
            public void fun() {
                System.out.println("getInstance A");
            }
        }
        return new C();
    }

}

class B extends A {

    void fun() {
        System.out.println("fun method override");
    }
}


public class Definition {

    public static void main(String[] args) {
        B b1 = new B();
        b1.fun();

        // 调用辅助类
        A.getInstance().fun();
    }
}
