package pers.vin.base.designPattern;

/**
 * Created by vin on 05/03/2018.
 */

interface IFruit {

    public void eat();
}

class AppleImpl implements IFruit {

    public void eat() {
        System.out.println("eat Apple");
    }
}

class OrangeImpl implements IFruit {

    public void eat() {
        System.out.println("eat Orange");
    }
}


class Factory {

    public static IFruit getInstance(String fruit) {

        if ("apple".equals(fruit)) {
            return new AppleImpl();
        } else if ("orange".equals(fruit)) {
            return new OrangeImpl();
        }

        return null;
    }

}

public class FactorySample {
    public static void main(String[] args) {


        // new 是耦合的元凶
        IFruit f1 = new AppleImpl();
        f1.eat();

        System.out.println("===============interface factory=============");

        // 取消 new 降低耦合
        // 对于工厂实现端有变动不影响 client 端
        IFruit f2 = Factory.getInstance("apple");
        f2.eat();
        IFruit f3 = Factory.getInstance("orange");
        f3.eat();


    }

}
