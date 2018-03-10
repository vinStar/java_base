package pers.vin.base.inheritSample;


public class Main {

    static int a = 1;
    int b = 1;

    Main() {
        print();
        a = 2;
        b = 2;
        print();
    }

    static {
        System.out.println("===before new=====");
    }


    {
        System.out.println("main");
        System.out.println("b is " + b);
    }

    static {
        System.out.println("static main");
        System.out.println("static a is " + a);
    }

    static void staticPrint() {
        System.out.println("static print");
    }

    void print() {

        System.out.println("print b " + b);
    }

    public static void main(String[] args) {


        //1. 消除结构定义上的重复[人=>工人(name,age)\学生(name,age)]
        //2. 子类最低与父类功能相同
        //3. 子类可对父类进行扩充


        Main.staticPrint();
        System.out.println("===after new======");
        //new Main();

        new Main();
        System.out.println("main is over ");
        new B();
    }
}

class A {

    public A() {
        Print();
    }

    public void Print() {
    }
}

class B extends A {
    {
        x = 2;
    }

    public int x = 1;
    public int y;

    {
        x = 3;
    }

    {
        System.out.println(x);
    }

    static {
        System.out.println("static");

    }

    public B() {
        System.out.println("x=" + this.x + " y=" + this.y);
        y = 12;
        x = 12;
        System.out.println("x=" + this.x + " y=" + this.y);

    }

    {
        System.out.println("=====");
        System.out.println("x=" + this.x + " y=" + this.y);
        x = 13;
        y = 13;

        System.out.println("x=" + this.x + " y=" + this.y);
        System.out.println("=====");
    }


    //@Override
    public void Print() {
        {
            x = 1;
        }

        System.out.println("x=" + x + " y=" + y);

    }


}
