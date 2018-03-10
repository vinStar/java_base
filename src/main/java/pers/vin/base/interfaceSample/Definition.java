package pers.vin.base.interfaceSample;

/**
 * Created by vin on 03/03/2018.
 */

interface IMessage {
    public static final String str1 = "hello";

    public abstract void print();
}

interface INews {

    public abstract void get();
}

class MessageImpl implements IMessage, INews {
    public void print() {
        System.out.println("override print method");
    }

    public void get() {
        System.out.println(IMessage.str1);//常量建议加上类名称

    }
}

public class Definition {

    //0. 避免单继承
    //1. 开发设计中接口优先
    //2. 抽象方法+全局常量
    //3. 一个子类可以实现多个接口,实现多继承
    //4. 如果子类为非 abstract 需要覆写 父类全部方法

    public static void main(String[] args) {

        IMessage message = new MessageImpl();//子类为父接口实例化
        message.print();//只能调用 print
        INews news = new MessageImpl();//子类为父接口实例化
        news.get();// 只能调用 get

        System.out.println("=========================");

        MessageImpl ms = (MessageImpl) message;
        ms.get();
        ms.print();

        System.out.println("=========================");

        new MessageImpl().print();
        new MessageImpl().get();

    }
}
