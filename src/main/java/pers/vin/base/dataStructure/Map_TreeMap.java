package pers.vin.base.dataStructure;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by vin on 07/02/2018.
 */
public class Map_TreeMap {

    public static void main(String[] args) {

        //1. the  result or iterator read   ordered by key asc
        //2. order by the key , the key not allow null can't compare with other keys
        //  permit is normal than allow
        //3. can use custom comparator

        Map<String, String> treeMap = new TreeMap<String,String>(new Comparator<String>() {

            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return -1;
                } else if (o1.length() < o2.length()) {

                    return 1;
                }
                return 0;
            }
        });

        treeMap.put("name", "1 vin");
        treeMap.put("name", "1 vinton");
        treeMap.put("a", "aa");
        treeMap.put("b", "bb");
        //treeMap.put(null,null);//NullPointerException
        //treeMap.put(null,"vin");//
        treeMap.put("nullKey", null);
        treeMap.put("firstName", "vin");
        treeMap.put("lastName", "li");

        Iterator iterator = treeMap.keySet().iterator();

        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("iterator key " + obj + " " + treeMap.get(obj));
        }

        for (String a : treeMap.keySet()) {
            //treeMap.remove(a);//ConcurrentModificationException
        }

        System.out.println(treeMap);// ordered by key asc


    }
}
