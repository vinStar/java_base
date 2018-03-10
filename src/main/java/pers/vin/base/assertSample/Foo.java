package pers.vin.base.assertSample;

/**
 * Created by vin on 31/01/2018.
 */
public class Foo {
    public static void main(String[] args) {
        Baz.testAsserts();
        Baz.testAsserts();

        Baz.test();
        Baz.testAsserts();

        // Will execute after Baz is initialized.
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
        boolean enabled = false;
        //assert (enabled = true);
        assert test();//An assert statement that is executed before its class has completed initialization is enabled.
        System.out.println("Asserts " +
                (enabled ? "enabled" : "disabled"));
        System.out.println("x is " + x);
    }

    static boolean test() {
        x = x + 2;
        System.out.println("111");

        return true;
    }
}
