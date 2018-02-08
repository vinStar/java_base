package pers.vin.base.dataStructure;

import java.util.Arrays;

/**
 * Created by vin on 05/02/2018.
 */
public class Sort_ChooseSort {


    static void chooseSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i ++) {
            //as
            int least = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[least]) {
                    least = j;
                }

            }
            temp = arr[i];
            arr[i] = arr[least];
            arr[least] = temp;

        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3, 1};
        int[] arr2 = arr.clone();


        System.out.println(Arrays.toString(arr));

        chooseSort(arr2);

        System.out.println(Arrays.toString(arr2));


    }
}
