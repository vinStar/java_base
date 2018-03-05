package pers.vin.base.designPattern;

/**
 * Created by vin on 05/03/2018.
 */


// 模拟现实中 找个代理(中介)给买 火车票,飞机票


// 核心目的 买火车票,飞机票
interface ISubjectTicket {

    void buyTicket();
}


// 核心实现-- 买火车票
class RealSubjectTrainImpl implements ISubjectTicket {

    public void buyTicket() {
        System.out.println("buy train ticket");
    }
}


// 核心实现-- 买飞机票
class RealSubjectPlaneImpl implements ISubjectTicket {

    public void buyTicket() {
        System.out.println("buy plane ticket");
    }
}

//代理实现
class SubjectProxy implements ISubjectTicket {

    ISubjectTicket iSubjectTicket = null;// 真正的操作业务

    //设置代理对象的真实主题(核心实现)
    public SubjectProxy(ISubjectTicket iSubjectTicket) {
        this.iSubjectTicket = iSubjectTicket;
    }


    // 代理帮忙--查
    public void searchTicket() {
        System.out.println("代理--查票!!!");
    }

    // 代理帮忙--送票
    public void sentTicket() {
        System.out.println("代理--送票");
    }


    // 接口实现
    public void buyTicket() {

        this.searchTicket();
        this.iSubjectTicket.buyTicket();// 真正业务
        this.sentTicket();
    }
}


//代理工厂
class ProxyFactory {

    public static ISubjectTicket getInstance(String ticketType) {
        if ("train".equals(ticketType)) {
            return new SubjectProxy(new RealSubjectTrainImpl());
        } else if ("plane".equals(ticketType)) {
            return new SubjectProxy(new RealSubjectPlaneImpl());
        }

        return null;
    }
}


public class ProxySample {


    public static void main(String[] args) {

        //1. 一般套路
        ISubjectTicket train = new RealSubjectTrainImpl();
        train.buyTicket();


        System.out.println("=================代理实现================");

        //2. 二班套路
        ISubjectTicket s1 = ProxyFactory.getInstance("train");
        s1.buyTicket();
        ISubjectTicket s2 = ProxyFactory.getInstance("plane");
        s2.buyTicket();

    }
}
