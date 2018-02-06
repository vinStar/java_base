package pers.vin.base.dataStructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Created by vin on 06/02/2018.
 */
public class List_Vector {

    public static void main(String[] args) {

        // Vector
        // 1. thread save (synchronized) but didn't recommend
        // 2. can use synchronized wrap ,
        // List safeList = Collections.synchronizedList(new ArrayList());
        List<Integer> listVector = new Vector<>();
        for (int i = 0; i < 10; i++) {
            listVector.add(i + 1);
        }

        System.out.println("=== print listVector  ===");


        for (int a : listVector) {

            //listVector.remove(a); // the same problem  like ArrayList
            System.out.println(a);
        }

        System.out.println(listVector);

        for (int i = listVector.size() - 1; i >= 0; i--) {
            listVector.remove(i);
        }


        System.out.println("=== remove result ===");
        System.out.println(listVector);
    }
}
