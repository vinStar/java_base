package pers.vin.base.dataStructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by vin on 06/02/2018.
 */
public class Map_HashMap {

    public static void main(String[] args) {

        //0. extends AbstractMap
        //1. thread not safe
        //2. key or value allow null and value can multi null
        //3. the result order didn't same with write order
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("name", "1 vin");
        hashMap.put("name", "2 vin");// pre value replace
        hashMap.put("firstName", "3 vin");// allow
        hashMap.put("a", "4 aa");
        hashMap.put("b", "5 aa");

        hashMap.put(null, null);//allow
        hashMap.put("lastName", null);//allow


        Iterator iterator = hashMap.keySet().iterator();

        System.out.println("=== iterate ===");

        while (iterator.hasNext()) {
            Object key = iterator.next();
            //System.out.println("key : " + key);
            System.out.println("iterate " + key + " : " + hashMap.get(key));
        }

        System.out.println("=== iterate  end ===");

        System.out.println("=== for  end ===");

        for (String a : hashMap.keySet()) {
            System.out.println(a);
            //hashMap.remove(a);//ConcurrentModificationException
        }

        System.out.println(hashMap);//
    }
}
