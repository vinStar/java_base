package pers.vin.base.interfaceSample;

/**
 * Created by vin on 03/03/2018.
 */


interface IAa {

    public String hello = "str1"; // 常量少见

    abstract void get();// 多为 方法

    public void print();// abstract 可以省略

}


abstract class Eabstract {
    abstract void printE();
}

class FfImpl extends Eabstract implements IAa {
    public void get() {   //  不写 public , 会权限严格   报错

    }

    public void print() {
        //有方法体就叫覆写
    }

    public void printE() {

    }
}


public class Apply {

    public static void main(String[] args) {
        //0. 方法建议为 public
        //1. 接口只允许 public 权限
        //2. 抽象类可以用 implements 实现接口
        //3. 接口不可以继承抽象类
        //4. 接口可以多继承 接口 , 所有父类方法都要覆写
        //5. 可定义内部类 内部接口 . 内部结构非首选


        new FfImpl();


        // FfImpl 是 抽象类和接口的共同子类
        Eabstract eabstract = (Eabstract) new FfImpl();
        eabstract.printE();

    }

}
