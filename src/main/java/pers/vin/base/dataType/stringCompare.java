package pers.vin.base.dataType;

/**
 * Created by vin on 28/02/2018.
 */
public class stringCompare {

    public static void main(String[] args) {

        //大 "A" 和小 "a" ascII 差 32
        System.out.println("A".compareTo("a"));//65 - 97

        System.out.println("AB".compareTo("AC"));//-1
        System.out.println("Ac".compareTo("AC"));//32


        System.out.println("a".compareTo("A"));//32

        //知道小写求大写
        char c1 = 'a';
        System.out.println((char) (c1 - 32));//A


    }


}
