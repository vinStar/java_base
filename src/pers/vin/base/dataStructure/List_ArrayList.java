package pers.vin.base.dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vin on 05/02/2018.
 * List interface
 */
public class List_ArrayList {

    public static void main(String[] args) {

        System.out.println("=== ArrayList  maybe occur exception when update or insert ===");
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }

        List list1 = list;
        list2.addAll(list);// list2=list is reference

        System.out.println("=== for :  ===");
        //  concurrent modification exception
        // 1. list will invoke iterator
        // 2. iterator invoke hasNext method will check the modCount
        for (int a : list) {
            //list.remove(a); //occur exception
            System.out.println(a);
        }
        System.out.println("=== for :  end ===");


        System.out.println(list);

        System.out.println("=== for i ===");
        // not recommend this , every remove other element will move left 1 location
        for (int i = 0; i < list1.size(); i++) {
            list.remove(i);
        }
        System.out.println(list1.toString());

        //no concurrent modification exception
        // or list2.removeAll(delArray)
        System.out.println("=== list2 remove descend ===");
        System.out.println(list2.toString());
        for (int i = list2.size() - 1; i >= 0; i--) {
            list2.remove(i);
        }

        System.out.println("=== remove result ===");
        System.out.println(list2.toString());
        System.out.println("=== ArrayList end ===");

        System.out.println("=== LinkedList  get value by index  when data is large the performance is low ===");

    }
}
