package pers.vin.base.dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vin on 05/02/2018.
 * List interface
 */
public class List_LinkList {

    public static void main(String[] args) {

        //LinkedList
        List<Integer> listLink = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            listLink.add(i + 1);
        }

        System.out.println("=== print listLink  ===");


        for (int a : listLink) {

            //listLink.remove(a); // the same problem  like ArrayList
            System.out.println(a);
        }

        System.out.println(listLink);

        for (int i = listLink.size() - 1; i >= 0; i--) {
            listLink.remove(i);
        }


        System.out.println("=== remove result ===");
        System.out.println(listLink);

    }
}
