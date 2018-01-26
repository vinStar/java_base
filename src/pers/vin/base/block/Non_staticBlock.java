package pers.vin.base.block;

/**
 * Created by vin on 24/01/2018.
 */


class A {

    int x ;

    //block num 1
    {
        x = 1;
        System.out.println("block num 1, x is " + x);
    }

    A() {
        x = 3;
        System.out.println("constructor x is " + x);
    }

    //block num 2
    {
        x = 2;
        System.out.println("block num 2, x is " + x);
    }

}


public class Non_staticBlock {

    public static void main(String[] args) {

        String newLine = System.getProperty("line.separator");

        System.out.println("====first time instantiate ====" + newLine);
        new A();

        System.out.println(" \n====second time instantiate ====" + newLine);
        new A();
    }

}
