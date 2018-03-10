package pers.vin.base.boxing;

/**
 * Created by liutong on 26/01/2018.
 * Auto-unboxing
 */
public class Auto_Unboxing {
    public static void main(String[] args) {
        int i1 = 1;
        Integer i2 = 1;//Autoboxing

        int i4 = 173;
        Integer i5 = 173;
        Integer i6 = 173;


        // == when compare  primitive type with wrapped type
        // wrapped type auto-unboxing
        System.out.println(i1 == i2);//true

        // 0. find [source code] value(i2) Integer value is int type
        // 1. equals param require Integer type , i1 autoboxing
        // 2. value(i2) == i1 [source code] , i1 auto-unboxing
        // 3. true
        System.out.println(i2.equals(i1));


        System.out.println(i4 == i5); // true

        System.out.println(i5.equals(i6)); //true
    }
}
