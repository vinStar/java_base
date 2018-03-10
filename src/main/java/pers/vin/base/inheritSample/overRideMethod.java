package pers.vin.base.inheritSample;

/**
 * Created by vin on 02/03/2018.
 */


// 1. 子类与父类 定义了相同的方法
// 2. private 对子类不可见

class Computer {
    public void print() {
        System.out.println("this Computer 1");
    }

    public void println() {
        System.out.println("this Computer 2");
    }

    // private 只能被父类所调用
    private void println2() {
        System.out.println("this Computer 2");
    }
}

class Server extends Computer {
    public void println() {
        System.out.println("this Server 2");
    }

    // 父类 为 private 与此方法 无任务关系
    public void println2() {
        System.out.println("this Computer 2");
    }

}


public class overRideMethod {

    public static void main(String[] args) {
        Server s1 = new Server();
        s1.print();//子类没有 ,  调用父类方法

        s1.println();//覆写后 ,调用子类方法

        //s1.println2(); 不可见
    }
}
