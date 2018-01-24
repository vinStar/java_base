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

    //num 1
    static {
        System.out.println("static block num 1 , x is " + x);
    }

    //num 2
    static {
        x=2;
        System.out.println("static block num 2 , x is " + x);
    }
}


public class StaticBlock {

    public static void main(String[] args) {
        String newLine = System.getProperty("line.separator");

        System.out.println("====first time instantiate ====" + newLine);
        new AA();

        System.out.println(" \n====second time instantiate ====" + newLine);
        new AA();
    }
}
