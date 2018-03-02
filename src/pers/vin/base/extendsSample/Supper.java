package pers.vin.base.extendsSample;

/**
 * Created by vin on 02/03/2018.
 */


//supper  1. 父类()         2. 父类                       3. 覆写 public
//this    1. 本类(属性\方法) 2. 范围: 先子类 ,找不到 找父类  3. 标识当前对象


class Cup {

    public String info = "hello";

    public void print() {
        System.out.println("父类");
    }

    public void print2() {
        System.out.println("父类--2");
    }
}

class ChildCup extends Cup {

    public int info = 100;

    public void print() {
        //this.print() ;// 就近原则调用 子类自己的 print 方法 ; 死循环 栈溢出 StackOverflow
        super.print();// 调用父类用 supper
        System.out.println("子类");


        // this 先从子类查找,如果子类没有从父类查找
        // this 属性同上
        this.print2();

        System.out.println(this.info);// 子类
    }
}


public class Supper {

    public static void main(String[] args) {
        ChildCup c1 = new ChildCup();
        c1.print();
    }
}
