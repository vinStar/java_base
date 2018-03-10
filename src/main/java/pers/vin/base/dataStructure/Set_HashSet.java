package pers.vin.base.dataStructure;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vin on 05/02/2018.
 * Set
 */
public class Set_HashSet {

    public static void main(String[] args) {


        System.out.println("HashSet");
        // 1. not allow repeat value
        // 2. didn't  guarantee order
        // 3. only can contain one null element

        // 4. a fixed spending insert and select and can optimize by load factor

        Set<Integer> hastSet = new HashSet<Integer>();
        for (int i = 0; i < 10; i++) {
            hastSet.add(i + 1);
        }

        for (int a : hastSet) {
            //hastSet.remove(a);// like array occur the concurrent modification exception
            System.out.println(a);
        }

    }
}
