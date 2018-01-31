package pers.vin.base.block;

/**
 * Created by vin on 24/01/2018.
 * non-static block and static block and the init order
 */

class AAA {
    int x;
    boolean enable=false;

    //block num 1
    {
        assert enable = true;
        x = 1;
        System.out.println("non-static block num 1 x is " + x);
    }

    AAA() {
        x = 3;
        System.out.println("constructor x is " + x);

    }

    //block num 2
    {
        x = 2;
        System.out.println("non-static block num 2 x is " + x);
    }


    // The static block only gets called once,when the class itself is initialized,
    // no matter how many objects of that type you create
    static {
        System.out.println("static block");
    }


    //Gets called every time an instance of the  class is constructed.
    //the non-static block is actually copied by the Java compiler into every constructor the class has (source).
    //So it is still the constructor's job to initialize fields.
    //to understand "actually " , find the result in the .class file of A.class
    {
        System.out.println("non-static block");
    }
}


public class BlockSample {

    public static void main(String[] args) {

        String newLine = System.getProperty("line.separator");

        System.out.println("====first time instantiate AAA ====" + newLine);
        new AAA();

        System.out.println(" \n====second time instantiate AAA ====" + newLine);
        new AAA();

    }
}


