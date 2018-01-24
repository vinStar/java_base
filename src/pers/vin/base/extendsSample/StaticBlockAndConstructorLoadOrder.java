package pers.vin.base.extendsSample;


/**
 * Created by vin on 24/01/2018.
 */
class Parent {
    // The static block only gets called once, no matter how many objects of that type you create
    static {
        System.out.println("parent static block");
    }

    //Gets called every time an instance of the Parent class is constructed.
    //the non-static block is actually copied by the Java compiler into every constructor the class has (source).
    //So it is still the constructor's job to initialize fields.
    {
        System.out.println("parent non-static block");
    }

    Parent() {
        System.out.println("parent constructor");
    }

}

class Child extends Parent {

    static {
        System.out.println("child static block ");
    }

    Child() {
        System.out.println("child constructor");
    }

}


public class StaticBlockAndConstructorLoadOrder {

    public static void main(String[] args) {
        System.out.println("====first time instantiate parent====");
        new Parent();
        System.out.println("====second time instantiate parent====");
        new Parent();
    }

}
