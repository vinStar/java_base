package pers.vin.base.dataType;

/**
 * Created by vin on 28/02/2018.
 */
public class StringEquals {

    public static void main(String[] args) {

        String str1 = "hello";
        String str2 = "hello-";

        String str4 = new String("hello");


        System.out.println(str1 == str2);
        System.out.println("Hello".equals(str1));
        System.out.println("hello".equals(str4));


        System.out.println("Hello".equalsIgnoreCase(str1));


    }

}
