package pers.vin.base.dataType;

/**
 * Created by vin on 25/02/2018.
 */
public class IntSample {
    static void test() {

        //正例,when declare then initialize
        int i = 1;
        System.out.println(i);
        //反例
        //错误实例
        //int i;
        //System.out.println(i);//variable i might not have been initialized
    }

    public static void main(String[] args) {
        test();

        int num = 2147483647;
        long temp = num + 2L;
        System.out.println(temp);// result : 2147483647 ;num自动升级为long

        num = 2147483647;
        // 还是int,+= autoboxing
        // but num = num + 2L; will occur exception
        num += 2L;
        System.out.println(num);// result : 2147483647 ;num自动升级为long

        // 没事别在前边加0
        int tNum = 011;//8进制
        System.out.println(tNum);//9 满8进1
        tNum = 0x11;//16进制
        System.out.println(tNum);//17 满16进1
    }
}
