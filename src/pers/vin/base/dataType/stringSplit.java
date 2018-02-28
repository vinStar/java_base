package pers.vin.base.dataType;

import java.util.Arrays;

/**
 * Created by vin on 28/02/2018.
 */
public class stringSplit {

    public static void main(String[] args) {
        System.out.println(Arrays.toString("hello world i here".split(" ")));
        System.out.println(Arrays.toString("hello world i here".split(" ", 2)));
        System.out.println(Arrays.toString("192.168.1.1".split(".")));// 无法拆分 需要转义
        System.out.println(Arrays.toString("192.168.1.1".split("\\.")));//转义
        System.out.println(Arrays.toString("name:tome|name:grace".split("\\|")));//转义  [name:tome, name:grace]

    }
}
