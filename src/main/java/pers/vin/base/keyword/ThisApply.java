package pers.vin.base.keyword;

/**
 * Created by vin on 10/03/2018.
 * <p>
 * this 表示当前对象 (相对概念)
 */


class Tree {

    public Tree() {

    }

    public void wave() {
        System.out.println("print this: " + this);
    }
}


public class ThisApply {


    public static void main(String[] args) {

        Tree t1 = new Tree();
        // this 与 t1 值 相等
        // 相对概念
        System.out.println("print object t1: " + t1);//pers.vin.base.keyword.Tree@2503dbd3
        t1.wave();//pers.vin.base.keyword.Tree@2503dbd3


        Tree t2 = new Tree();
        // his 与 t2 值 相等
        // 相对概念
        System.out.println("print object t1: " + t2);//pers.vin.base.keyword.Tree@2503dbd3
        t2.wave();//pers.vin.base.keyword.Tree@2503dbd3


    }

}
