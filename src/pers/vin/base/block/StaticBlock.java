package pers.vin.base.block;

/**
 * Created by vin on 24/01/2018.
 */


class AA {

    AA() {
        x = 3;
        System.out.println("constructor x is " + x);
    }

    static int x = 1;

    //block num 1
    static {
        System.out.println("static block num 1 , x is " + x);
    }

    //block num 2
    static {
        x = 2;
        System.out.println("static block num 2 , x is " + x);
    }

    static void print() {
        System.out.println("static method");
    }
}


public class StaticBlock {

    static {
        System.out.println("==== first ====");
    }

    public static void main(String[] args) {
        String newLine = System.getProperty("line.separator");

        System.out.println("==== class init ====" + newLine);
        AA.print();

        System.out.println("====first time instantiate ====" + newLine);
        new AA();
        System.out.println(" \n====second time instantiate ====" + newLine);
        new AA();
    }
}
