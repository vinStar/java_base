package pers.vin.base.assertSample;

/**
 * Created by vin on 31/01/2018.
 */
public class AssertSample {

    public static void main(String[] args) {

        test1(5);
        test2(-3);
    }

    private static void test1(int a){
        boolean enable=false;
        assert a > 0;
        assert enable=true;
        System.out.println(a);
    }
    private static void test2(int a){
        assert a > 0 : "something goes wrong here, a cannot be less than 0";
        System.out.println(a);
    }
}
