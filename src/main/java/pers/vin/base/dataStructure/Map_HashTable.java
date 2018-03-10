package pers.vin.base.dataStructure;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by vin on 06/02/2018.
 */
public class Map_HashTable {

    public static void main(String[] args) {


        // 0. extends Dictionary
        // 1. thread safe (synchronized) like Arrays Vector
        // 2. not allow null  key or value --occur nullPointerException
        // source code :
        //    if (value == null) {
        //        throw new NullPointerException();
        //    }
        //
        // 3. find the source code
        // public synchronized V put(K key, V value)
        // hashTable support synchronized , so when put will slow
        Map<String, String> hashTable = new Hashtable<String, String>();
        //hashTable.put(null,"null");// NullPointerException
        //hashTable.put(null,"null");// NullPointerException
        // hashTable.put("null key", null); // NullPointerException
        hashTable.put("a", "aa");
        hashTable.put("b", "bb");
        hashTable.put("name", "vin");
        hashTable.put("name", "vin");//if the key exists , the pre value will be replaced
        hashTable.put("fistName", "vin");
        hashTable.put("name", "grace");

        //hashTable.put(null,null);
        //hashTable.put("age",null);
        // not allow null value,
        // otherwise will occur java.lang.NullPointerException


        for (String a : hashTable.keySet()) {
            System.out.println(hashTable.get(a));
        }

        for (String a : hashTable.keySet()) {
            //hashTable.remove(a);// like arrayList occur ConcurrentModificationException
        }

        System.out.println("is contain value : " + hashTable.containsValue("vin")); //false
        System.out.println("size : " + hashTable.size());
        System.out.println(hashTable);

    }
}
