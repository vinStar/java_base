package pers.vin.base.designPattern;

/**
 * Created by vin on 10/03/2018.
 * <p>
 * 单例 : 一个类只允许产生一个实例化对象
 * 懒汉式: 用到时实例化
 * 饿汉式: 类加载就实例化
 */


// 恶汉式
class Singleton {

    // 类内部可产生实例化对象
    // Singleton singleton=new Singleton();

    static Singleton singleton = new Singleton();

    // private 权限控制 外部类不可 new
    private Singleton() {
        System.out.println("hello world");
    }

    // static 非实例化对象 可用(static)
    public static final Singleton getInstance() {

        return singleton;

    }

    public void print() {
        System.out.println("print");
    }
}


// 懒汉式
class SingletonLazy {

    // 类内部可产生实例化对象
    // Singleton singleton=new Singleton();

    static SingletonLazy singletonLasy = null;

    // private 权限控制 外部类不可 new
    private SingletonLazy() {
        System.out.println("hello world");
    }

    // static 非实例化对象 可用(static)
    public static final SingletonLazy getInstance() {

        // 多线程 存在性能问题
        if (singletonLasy == null) {
            singletonLasy = new SingletonLazy();
        }
        return singletonLasy;
    }

    public void print() {
        System.out.println("print");
    }
}


public class SingletonSample {

    public static void main(String[] args) {

        //Singleton s1 = new Singleton(); // 非 private 权限 才可以访问
        System.out.println(Singleton.getInstance().equals(Singleton.getInstance()));//true
        System.out.println(Singleton.getInstance() == Singleton.getInstance());//true

        Singleton.getInstance().print();

        System.out.println(" ===  懒汉式 ====");

        System.out.println(SingletonLazy.getInstance().equals(SingletonLazy.getInstance()));//true
        System.out.println(SingletonLazy.getInstance() == SingletonLazy.getInstance());//true
    }
}
