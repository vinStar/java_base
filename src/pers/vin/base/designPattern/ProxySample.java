package pers.vin.base.designPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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


/**
 * -------------------动态代理----------------
 * 1. 在JDK1.3之后加入了可协助开发的动态代理功能.不必为特定对象与方法编写特定的代理对象,使用动态代理,
 * 可以使得一个处理者(Handler)服务于各个对象.
 * 2. 一个处理者的类设计必须实现java.lang.reflect.InvocationHandler接口.
 * 3. 通过InvocationHandler接口实现的动态代理只能代理接口的实现类.
 */


// 处理者
class DynamicProxyHandler implements InvocationHandler {

    Object target = null;// 真正的业务操作者

    public DynamicProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        method.invoke(target, args);

        return null;
    }
}

//代理对象工厂


class DynamicProxyFactory {

    public static Object getInstance(Object obj) {

        DynamicProxyHandler handler = new DynamicProxyHandler(obj);
        ClassLoader classLoader = obj.getClass().getClassLoader();
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, interfaces, handler);

    }

}


public class ProxySample {


    public static void main(String[] args) {

        //1. 一般套路
        ISubjectTicket train = new RealSubjectTrainImpl();
        train.buyTicket();


        System.out.println("=================静态 代理实现================");

        //2. 二班套路
        ISubjectTicket s1 = ProxyFactory.getInstance("train");
        s1.buyTicket();
        ISubjectTicket s2 = ProxyFactory.getInstance("plane");
        s2.buyTicket();

        System.out.println("=================jdk 动态 代理实现================");

        //3. 三班套路
        ISubjectTicket s3 = (ISubjectTicket)
                DynamicProxyFactory.getInstance(new RealSubjectTrainImpl());

        s3.buyTicket();


    }
}
