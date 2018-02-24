package pers.vin.base.classLoad;

/**
 * Created by vin on 25/01/2018.
 */
class SingleTon {

    private static SingleTon singleTon = new SingleTon();

    public static int count1;
    public static int count2 = 0;
    // init by default order  , so count1=1,count2=1
    // private static SingleTon singleTon = new SingleTon();

    private SingleTon() {

        count1++;
        count2++;

        System.out.println("constructor after ++ count1= " + count1);
        System.out.println("constructor after ++ count2= " + count2);

    }

    static {
        System.out.println("static count1= " + count1);
        System.out.println("static count2= " + count2);

    }

    static void print() {
        System.out.println("static print");
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}

public class Test {


    static void test() {
        int i = 1;
        //错误实例
//      test    int i;
//        System.out.println(i);
    }


    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        SingleTon.print();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + SingleTon.count2);


        int num = 2147483647;
        long temp = num + 2L;
        System.out.println(temp);

        num = 2147483647;
        num += 2L;
        System.out.println(num);
        test();

    }
}
