package pers.vin.base.block;

/**
 * Created by vin on 31/01/2018.
 */
public class Foo {
    public static void main(String[] args) {
        Baz.testAsserts();
        Baz.testAsserts();
        // Will execute after Baz is initialized.


        //1. Invoking Baz.testAsserts() cause Baz to be initialized
        //2. default int x=0;
        //3. Before Baz initialize , Bar must be initialized
        //4. Bar's static initializer again invoking Baz.testAsserts()
        //5. so x is 0 , then x+2 , x=2
        //6.  go on initializing Baz , init x = 1;
        //7. Invoking Baz.testAsserts() x = 1 , so x is 1;

    }
}

class Bar {
    static {
        Baz.testAsserts();
        // Will execute before Baz is initialized!
    }
}


class Baz extends Bar {
    static int x = 1;

    static void testAsserts() {

        System.out.println("x is " + x);
        x=x+2;
    }

}
