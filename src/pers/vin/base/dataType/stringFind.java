package pers.vin.base.dataType;

/**
 * Created by vin on 28/02/2018.
 */
public class stringFind {

    public static void main(String[] args) {

        System.out.println("**@@hello".contains("o"));

        System.out.println("hello".indexOf("e"));
        System.out.println("hello");
        System.out.println("hello".indexOf("l", 3));
        System.out.println("hello".lastIndexOf("l"));

        System.out.println("**@@hello".startsWith("**"));
        System.out.println("**@@hello".startsWith("@@", 2));
        System.out.println("hello--".endsWith("--"));
    }
}
