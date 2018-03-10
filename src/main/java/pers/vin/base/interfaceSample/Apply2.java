package pers.vin.base.interfaceSample;

/**
 * Created by vin on 03/03/2018.
 */


interface IUSB {
    public void setUp();//安装驱动

    public void work();//工作
}

class Flash implements IUSB {


    @Override
    public void setUp() {
        System.out.println("flash set up");
    }

    @Override
    public void work() {
        System.out.println("flash work");
    }
}


class Computer {

    public void plugIn(IUSB iusb) {
        iusb.setUp();
        iusb.setUp();
    }


}

public class Apply2 {
    public static void main(String[] args) {


        // 0. 定义标准(usb  U盘 打印机等...)
        // 1. 能力
        // 2. 分布式开发 暴露接口
        // 3. 接口编程 ioc


        // 4. 接口的好处, 使用接口和对象的多态性相结合之后, 对于参数的统一更加明确
        // 5. 接口在类之上的设计抽象

        // 6. 先接口(标准) 再 类


        Flash flash = new Flash();

        Computer computer = new Computer();

        computer.plugIn(flash);

    }
}
