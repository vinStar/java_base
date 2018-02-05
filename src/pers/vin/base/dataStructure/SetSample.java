package pers.vin.base.dataStructure;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vin on 05/02/2018.
 * Set
 */
public class SetSample {

    public static void main(String[] args) {

        System.out.println("HashSet");
        // 1. not allow repeat value
        // 2. didn't  guarantee order
        // 3. only can contain one null element

        // 4. a fixed spending insert and select and can optimize by load factor

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i <10 ; i++) {
            set.add(i+1);
        }

        for(int a:set){
            //set.remove(a);// like array occur the concurrence problem
            System.out.println(a);
        }



        System.out.println("HashTree");
        // 1. not allow repeat value
        // 2. ordered by some regular
        // 3. not contain null element

        // 4. base  red black tree ,the result u get sorted

//        使用同步包装器
//        List safedList = Collections.synchronizedList(new ArrayList());
//        Set safedSet=Collections.synchronizedSet(new HashSet());
//        Map safedMap=Collections.synchronizedMap(new HashMap());
    }
}
