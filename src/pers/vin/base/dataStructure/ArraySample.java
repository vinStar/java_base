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

        transposeArray();
    }

    public static void transposeArray() {

        int[][] data = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};

        for (int x = 0; x < data.length; x++) {
            for (int y = 0; y < data.length; y++) {

                System.out.print(data[x][y] + " ");
                if (data[x][y] < 10) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


        // 依次替换中轴以下y轴所有数据
        // x=0 ,所有y轴数据
        // x=1 ,所有y轴数据
        // x=...
        for (int x = 0; x < data.length; x++) {
            for (int y = x; y < data.length; y++) {
                if (x != y) {
                    int temp = data[x][y];
                    data[x][y] = data[y][x];
                    data[y][x] = temp;
                }
            }
        }

        System.out.println("transpose :");

        for (int x = 0; x < data.length; x++) {
            for (int y = 0; y < data.length; y++) {
                System.out.print(data[x][y] + " ");
                if (data[x][y] < 10) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


    }


}
