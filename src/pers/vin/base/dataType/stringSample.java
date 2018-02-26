package pers.vin.base.dataType;

/**
 * Created by vin on 26/02/2018.
 */
public class stringSample {

    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 10;

        System.out.println("num1 == num2                    : " + (num1 == num2));

        String str1 = "hel";
        String str2 = "hel";
        String str3 = new String("hel");

        System.out.println("str1 equals str2                 : " + str1.equals(str3));

        System.out.println("str1.intern() == str2            : " + (str1.intern() == str2));
        System.out.println("str1 == \"h\" + \"e\" + \"l\"    : " + (str1 == "h" + "e" + "l"));//true
        System.out.println("str1 == \"hello\"                : " + (str1 == "hello"));//true
        System.out.println("str2 intern                      : " + str2.intern());//hel

        char[] char1 = new char[]{
                'h', 'e', 'l'
        };


        System.out.println(str1 == str2);
        System.out.println(str1 == str3);

        System.out.println("string char[]                    :  " + (str1 == char1.toString()));

        for (int i = 0; i < str1.length(); i++) {
            System.out.println(str1.charAt(i));
        }


        // "hel" String 的匿名对象, 匿名对象可调用对象的所有方法
        // 匿名对象必然保存在堆内存之中
        System.out.println("\"hel\".equals(str1)             : " + "hel".equals(str1));

        // 提醒用 字符串. equals 输入值 避免 nullPointerException
        String strInput = null;
        String strInput2 = "hel";

        System.out.println("hel".equals(strInput2));// false
        //--------------- 错误实例
        //System.out.println(strInput.equals(str1)); // nullPointerException
        //--------------

        //part 0
        //1. String 类使用了一种共享设计模式，JVM维护的字符串对象池，可理解为对象池数组
        // 面向对象（想象一个工具可能被A使用，B使用，。。而不用每个人都有这个工具，造成不必要的浪费）
        //  == 分配一个或者不分配堆内存 ,第二个之后可共享堆内存
        // "hel"== str1 // is true , 比较值!比较值!有对象的话就是对象的堆存地址值
        //2. 两种创建字符串实例的区别
        //a. 直接赋值：匿名对象，开辟一块堆内存空间，存储在对象池，可共享，供下次使用。
        //b. 构造方法：开辟两块堆内存，一个成为垃圾。不会保存在对象池，可使用String.intern 手动设置入池（共享）

        //part 1
        //1. "==" is compare num value
        //2. if "==" use to compare Object , then compare the Object's memory address's num value;
        //   compare num value not Object's content
        //3. compare Object's content with  equals()

        //part 2
        //1. "equals" is use to compare String Object's content

        //part 3
        //1. String.intern return 返回字符串对象的规范化表示形式。 
        //2. 当 有多个（s、t） == "abc" ; 产生多个栈(内存地址值相同,用==比较的话为 true)指向同一堆内存
        //               if and only if s.equals(t)
        //                 so s==t is true (堆内存地址值相同)

        //part 4
        // "hel" 为 String 匿名对象 , 可调用 String 对象的所有方法
        //

        //part 5
        // 提醒用 字符串. equals 输入值; 反例: 输入值(strInput=null) strInput.equals  引发 nullPointerException
        // "hel" 匿名对象永远不会为 null , 所以安全


    }
}
