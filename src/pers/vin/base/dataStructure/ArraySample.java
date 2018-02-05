package pers.vin.base.dataStructure;


import com.sun.deploy.util.StringUtils;


import java.util.Arrays;

/**
 * Created by liutong on 02/02/2018.
 */
public class ArraySample {
    public static void main(String[] args) {

        int[] intArraySou = new int[10];
        int[] intArrayTar = new int[10];

        Arrays.equals(intArraySou, intArrayTar);//compare two array element count and element equals
        System.out.println(Arrays.equals(intArraySou, intArrayTar));
        Arrays.fill(intArraySou, 1);// fill array with val 1
        System.out.println(Arrays.toString(intArraySou));
        Arrays.fill(intArrayTar, 1, 5, 1);// fill with index
        System.out.println(Arrays.toString(intArrayTar));

        Arrays.sort(intArrayTar);// sort default asc
        System.out.println(Arrays.toString(intArrayTar));

        // binary search , the array should be sort otherwise the result is unknown
        int i = Arrays.binarySearch(intArrayTar, 0);
        System.out.println(i);
        //print the array elements
        System.out.println(Arrays.toString(intArrayTar));




    }
}
