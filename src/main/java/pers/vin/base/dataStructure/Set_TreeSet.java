package pers.vin.base.dataStructure;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by vin on 05/02/2018.
 * Set
 */
public class Set_TreeSet {

    public static void main(String[] args) {


        System.out.println("TreeSet");
        // 1. not allow repeat value but will replaced
        // 2. ordered by some regular
        // 3. not contain null element

        // 4. base  red black tree ,the result u get is sorted


        Set<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < 10; i++) {
            treeSet.add(i + 1);
        }

        treeSet.add(1);
        treeSet.add(1);

        for (int a : treeSet) {
            //treeSet.remove(a);// like array occur the concurrent modification exception
            System.out.println(a);
        }

//        使用同步包装器
//        List safedList = Collections.synchronizedList(new ArrayList());
//        Set safedSet=Collections.synchronizedSet(new HashSet());
//        Map safedMap=Collections.synchronizedMap(new HashMap());
    }
}
