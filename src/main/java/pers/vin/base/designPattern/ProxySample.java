package pers.vin.base.designPattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by vin on 05/03/2018.
 * <p>
 * 动态代理与静态代理的区别:
 * <p>
 * 静态代理需要手工编写代理类，代理类引用被代理对象
 * 动态代理是内存中构建的，不需要手动编写代
 * <p>
 * 动态代理AOP：
 * （JDK）  本质：在内存中构建出接口的实现
 * 特点：被代理对象，必须有接口
 * （cglib） 本质：在内存中生成被代理类的子
 * 特点：可以在没有接口的情况下代理
 * 对于不使用接口的业务类，无法使用JDK动态代理，cglib采用非底层的字节码技术，可以为一个类创建子类，
 * 解决无接口代理问题
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
 * -------------------动态代理 jdk----------------
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


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        method.invoke(target, args);

        return null;
    }
}

//动态代理对象工厂


class DynamicProxyFactory {

    public static Object getInstance(Object obj) {

        DynamicProxyHandler handler = new DynamicProxyHandler(obj);
        ClassLoader classLoader = obj.getClass().getClassLoader();
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, interfaces, handler);

    }

}


/**
 * 动态代理=======cglib
 * <p>
 * 使用cglib完成动态代理，大概的原理是：cglib继承被代理的类，重写方法，织入通知，动态生成字节码并运行，
 * 因为是继承所以final类是没有办法动态代理的。
 */


class DynamicProxyCglib implements MethodInterceptor {


    Object targetObject = null;// 真正的业务操作者


    // 通过带参构造方法传入 业务操作者对象
    public DynamicProxyCglib(Object targetObject) {
        this.targetObject = targetObject;
    }

    //动态生成一个新的类 , 创建一个指定了特定回调的代理实例
    public Object getInstance() {
        //增强器，动态代码生成器
        Enhancer enhancer = new Enhancer();
        //回调方法
        enhancer.setCallback(this);

        //设置生成类的父类类型
        enhancer.setSuperclass(targetObject.getClass());

        //动态生成字节码并返回代理对象
        return enhancer.create();

    }

    // override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy)
            throws Throwable {

        System.out.println("买票前 do something");

        // 调用方法
        Object result = methodProxy.invoke(targetObject, args);

        System.out.println("买票后 do something");


        return result;
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

        System.out.println("=================Cglib 动态 代理实现================");

        ISubjectTicket s4 = (ISubjectTicket) new DynamicProxyCglib(new RealSubjectPlaneImpl()).getInstance();
        s4.buyTicket();

    }


}
