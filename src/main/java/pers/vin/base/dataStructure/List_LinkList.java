package pers.vin.base.dataStructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vin on 05/02/2018.
 * List interface
 */
public class List_LinkList {

    public static void main(String[] args) {

        //LinkedList
        //1. get whit index
        //2. add
        //3. permit loop remove
        //4. implement queue


        List<Integer> listLink = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            listLink.add(i);
        }

        listLink.set(9, 100);//replace
        //listLink.add(9,100);// insert at index

        System.out.println("=== print listLink  ===");


        for (int a : listLink) {

            //listLink.remove(a); // the same problem  like ArrayList
            System.out.println(a);
        }

        Iterator<Integer> integerIterator = listLink.iterator();
        while (integerIterator.hasNext()) {

            Object obj = integerIterator.next();
            System.out.println("iterator " + obj);
        }

        System.out.println(listLink);

        System.out.println("=== list get ===");
        for (int i = 0; i < listLink.size(); i++) {
            System.out.println("get(" + i + ") : " + listLink.get(i));

        }
        System.out.println("=== list get end===");


        for (int i = listLink.size() - 1; i >= 0; i--) {
            listLink.remove(i);
        }


        System.out.println("=== remove result ===");
        System.out.println(listLink);

    }
}
