package pers.vin.base.dataType;

/**
 * Created by vin on 28/02/2018.
 */
public class stringByte {


    public static void main(String[] args) {

        String str = "世界和平";

        System.out.println("str");

        byte[] data = str.getBytes();

        //-28 -72 -106 -25 -107 -116 -27 -110 -116 -27 -71 -77
        //结果为负数: byte[-128,127], byte 存储汉字溢出 , 所以 byte 不适合处理汉字
        //汉字用字符 char 来处理 char 范围[]
        System.out.println(Integer.MAX_VALUE);
        System.out.println("char max " + (int) Character.MAX_VALUE);
        System.out.println("char min " + (int) Character.MIN_VALUE);
        System.out.println(Character.SIZE);

        for (byte datum : data) {
            System.out.print(datum + " ");
        }

        System.out.println();

        String str2 = "helloworld";

        byte[] data2 = str2.getBytes();


        for (byte datum : data2) {
            System.out.print(datum + " ");
        }

        System.out.println();
        System.out.println(new String(data2));
    }

}
