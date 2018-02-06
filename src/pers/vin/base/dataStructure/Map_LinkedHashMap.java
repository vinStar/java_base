package pers.vin.base.dataStructure;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vin on 06/02/2018.
 */
public class Map_LinkedHashMap {
    public static void main(String[] args) {

        // 1. compare with hashMap the iterate result is ordered

        Map<String, String> lhmMap = new LinkedHashMap<>();
        lhmMap.put("name", "vin");
        lhmMap.put("name", "vin");// pre value replace
        lhmMap.put("firstName", "vin");// allow
        lhmMap.put(null, null);//allow
        lhmMap.put("lastName", null);//allow
        lhmMap.put("last","last");

        Iterator iterator = lhmMap.keySet().iterator();

        System.out.println("=== iterate ===");

        while (iterator.hasNext()) {
            Object key = iterator.next();
            //System.out.println("key : " + key);
            System.out.println("iterate "+key+" : " + lhmMap.get(key));

        }
        System.out.println("=== iterate end===");

        for(String a:lhmMap.keySet()){
           // lhmMap.remove(a); // ConcurrentModificationException
        }




        System.out.println(lhmMap);
    }
}
