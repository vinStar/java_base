package pers.vin.base.dataStructure;

/**
 * Created by vin on 05/02/2018.
 */
public class BinarySearch {

    // 1  2  3
    //with while implement binary search
    static int find(int[] arr, int value) {
        int lowIndex = 0;
        int highIndex = arr.length - 1;
        int curIndex = 0;

        while (lowIndex <= highIndex) {

            curIndex = (highIndex + lowIndex) / 2;
            System.out.println(curIndex);

            if (arr[curIndex] == value) {

                return curIndex;

            } else if (arr[curIndex] > value) {

                highIndex = curIndex - 1;

            } else {

                lowIndex = curIndex + 1;
            }
        }

        return -1;

    }

    // with recursive implement binary search
    private static int recursiveFind(int[] arr,int start,int end,int searchKey){
        if (start <= end) {
            // 中间位置
            int middle = (start + end) >> 1; // (start+end)/2
            if (searchKey == arr[middle]) {
                // 等于中值直接返回
                return middle;
            } else if (searchKey < arr[middle]) {
                // 小于中值时在中值前面找
                return recursiveFind(arr, start, middle - 1, searchKey);
            } else {
                // 大于中值在中值后面找
                return recursiveFind(arr, middle + 1, end, searchKey);
            }
        } else {
            // 找不到
            return -1;
        }
    }


    public static void main(String[] args) {
        int[] intArr = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("find(intArr,5) " + find(intArr, 5));
        int[] intArr2 = new int[]{1, 2};

        System.out.println(System.nanoTime());

        System.out.println("recursiveFind " + recursiveFind(intArr,1,6,5));

    }
}
