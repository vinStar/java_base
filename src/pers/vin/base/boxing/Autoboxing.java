package pers.vin.base.boxing;

/**
 * Created by vin on 25/01/2018.
 * Autoboxing & source code
 */
public class Autoboxing {

    public static void main(String[] args) {

        Integer i3 = 1;//Autoboxing
        Integer i4 = 1;

        Integer i5 = 129;
        Integer i6 = 129;



        // == default(didn't override) is to compare object reference
        // find the Autoboxing source code Integer.valueOf() will cache -128~127 value
        // so i3 and i4 is the same object reference
        System.out.println(i3 == i4);//true

        // out of the cache range
        // both of i5 i6 is  new Integer , so they are not the same object reference
        System.out.println(i5 == i6);//false

        System.out.println(i5.equals(i6)); // true

        System.out.println(i3.compareTo(i4));//0 compare int ==




    }
}
