package pers.vin.base.dataType;

/**
 * Created by vin on 28/02/2018.
 *
 */
public class StringReplace {

    public static void main(String[] args) {


        System.out.println("hello".replaceAll("l", "_"));

        System.out.println("hello".replaceFirst("l", "_"));

        System.out.println("he2l3l4o".replaceAll("\\d", "_"));
        System.out.println("hello".replaceAll("^.{2}", "_"));
        System.out.println("hello".replaceAll("[he]", "_"));
    }
}
